#!/usr/bin/env bash

#
# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

#
# Script to create a binary distribution for easy deploys of Spark.
# The distribution directory defaults to dist/ but can be overridden below.
# The distribution contains fat (assembly) jars that include the Scala library,
# so it is completely self contained.
# It does not contain source or *.class files.
#
# Optional Arguments
#      --tgz: Additionally creates spark-$VERSION-bin.tar.gz
#      --hadoop VERSION: Builds against specified version of Hadoop.
#      --with-yarn: Enables support for Hadoop YARN.
#      --with-hive: Enable support for reading Hive tables.
#      --name: A moniker for the release target. Defaults to the Hadoop verison.
#
# Recommended deploy/testing procedure (standalone mode):
# 1) Rsync / deploy the dist/ dir to one host
# 2) cd to deploy dir; ./sbin/start-master.sh
# 3) Verify master is up by visiting web page, ie http://master-ip:8080.  Note the spark:// URL.
# 4) ./sbin/start-slave.sh 1 <<spark:// URL>>
# 5) ./bin/spark-shell --master spark://my-master-ip:7077
#

# Figure out where the Spark framework is installed
FWDIR="$(cd `dirname $0`; pwd)"
DISTDIR="$FWDIR/dist"

VERSION=$(mvn help:evaluate -Dexpression=project.version |grep -v "INFO")
if [ $? == -1 ] ;then
    echo -e "You need Maven installed to build Spark."
    echo -e "Download Maven from https://maven.apache.org."
    exit -1;
fi

# Initialize defaults
SPARK_HADOOP_VERSION=1.0.4
SPARK_YARN=false
SPARK_HIVE=false
SPARK_TACHYON=false
MAKE_TGZ=false
NAME=none

# Parse arguments
while (( "$#" )); do
  case $1 in
    --hadoop)
      SPARK_HADOOP_VERSION="$2"
      shift
      ;;
    --with-yarn)
      SPARK_YARN=true
      ;;
    --with-hive)
      SPARK_HIVE=true
      ;;
    --with-tachyon)
      SPARK_TACHYON=true
      ;;
    --tgz)
      MAKE_TGZ=true
      ;;
    --name)
      NAME="$2"
      shift
      ;;
  esac
  shift
done

if [ "$NAME" == "none" ]; then
  NAME=$SPARK_HADOOP_VERSION
fi

echo "Spark version is $VERSION"

if [ "$MAKE_TGZ" == "true" ]; then
  echo "Making spark-$VERSION-bin-$NAME.tgz"
else
  echo "Making distribution for Spark $VERSION in $DISTDIR..."
fi

echo "Hadoop version set to $SPARK_HADOOP_VERSION"
echo "Release name set to $NAME"
if [ "$SPARK_YARN" == "true" ]; then
  echo "YARN enabled"
else
  echo "YARN disabled"
fi

if [ "$SPARK_TACHYON" == "true" ]; then
  echo "Tachyon Enabled"
else
  echo "Tachyon Disabled"
fi

# Build uber fat JAR
cd $FWDIR

export MAVEN_OPTS="-Xmx2g -XX:MaxPermSize=512M -XX:ReservedCodeCacheSize=512m"

if [ "$SPARK_HIVE" == "true" ]; then
  MAYBE_HIVE="-Phive"
else
  MAYBE_HIVE=""
fi

if [ "$SPARK_YARN" == "true" ]; then
  mvn clean package -DskipTests -Pyarn -Dhadoop.version=$SPARK_HADOOP_VERSION \
    -Dyarn.version=$SPARK_HADOOP_VERSION $MAYBE_HIVE
else
  mvn clean package -DskipTests -Dhadoop.version=$SPARK_HADOOP_VERSION $MAYBE_HIVE
fi

# Make directories
rm -rf "$DISTDIR"
mkdir -p "$DISTDIR/lib"
echo "Spark $VERSION built for Hadoop $SPARK_HADOOP_VERSION" > "$DISTDIR/RELEASE"

# Copy jars
cp $FWDIR/assembly/target/scala*/*assembly*hadoop*.jar "$DISTDIR/lib/"
cp $FWDIR/examples/target/scala*/spark-examples*.jar "$DISTDIR/lib/"

# Copy other things
mkdir "$DISTDIR"/conf
cp "$FWDIR"/conf/*.template "$DISTDIR"/conf
cp "$FWDIR"/conf/slaves "$DISTDIR"/conf
cp -r "$FWDIR/bin" "$DISTDIR"
cp -r "$FWDIR/python" "$DISTDIR"
cp -r "$FWDIR/sbin" "$DISTDIR"


# Download and copy in tachyon, if requested
if [ "$SPARK_TACHYON" == "true" ]; then
  TACHYON_VERSION="0.4.1"
  TACHYON_URL="https://github.com/amplab/tachyon/releases/download/v${TACHYON_VERSION}/tachyon-${TACHYON_VERSION}-bin.tar.gz"

  TMPD=`mktemp -d 2>/dev/null || mktemp -d -t 'disttmp'`

  pushd $TMPD > /dev/null
  echo "Fetchting tachyon tgz"
  wget "$TACHYON_URL"

  tar xf "tachyon-${TACHYON_VERSION}-bin.tar.gz"
  cp "tachyon-${TACHYON_VERSION}/target/tachyon-${TACHYON_VERSION}-jar-with-dependencies.jar" "$DISTDIR/lib"
  mkdir -p "$DISTDIR/tachyon/src/main/java/tachyon/web"
  cp -r "tachyon-${TACHYON_VERSION}"/{bin,conf,libexec} "$DISTDIR/tachyon"
  cp -r "tachyon-${TACHYON_VERSION}"/src/main/java/tachyon/web/resources "$DISTDIR/tachyon/src/main/java/tachyon/web"

  if [[ `uname -a` == Darwin* ]]; then
    # need to run sed differently on osx
    nl=$'\n'; sed -i "" -e "s|export TACHYON_JAR=\$TACHYON_HOME/target/\(.*\)|# This is set for spark's make-distribution\\$nl  export TACHYON_JAR=\$TACHYON_HOME/../lib/\1|" "$DISTDIR/tachyon/libexec/tachyon-config.sh"
  else
    sed -i "s|export TACHYON_JAR=\$TACHYON_HOME/target/\(.*\)|# This is set for spark's make-distribution\n  export TACHYON_JAR=\$TACHYON_HOME/../lib/\1|" "$DISTDIR/tachyon/libexec/tachyon-config.sh"
  fi

  popd > /dev/null
  rm -rf $TMPD
fi

if [ "$MAKE_TGZ" == "true" ]; then
  TARDIR_NAME=spark-$VERSION-bin-$NAME
  TARDIR="$FWDIR/$TARDIR_NAME"
  cp -r "$DISTDIR" "$TARDIR"
  tar czf "spark-$VERSION-bin-$NAME.tgz" -C "$FWDIR" "$TARDIR_NAME"
  rm -rf "$TARDIR"
fi
