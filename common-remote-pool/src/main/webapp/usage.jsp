<p>
<h3>How to use it?</h3>


<script type="text/javascript">
function openShutManager(oSourceObj,oTargetObj,shutAble,oOpenTip,oShutTip){
var sourceObj = typeof oSourceObj == "string" ? document.getElementById(oSourceObj) : oSourceObj;
var targetObj = typeof oTargetObj == "string" ? document.getElementById(oTargetObj) : oTargetObj;
var openTip = oOpenTip || "";
var shutTip = oShutTip || "";
if(targetObj.style.display!="none"){
   if(shutAble) return;
   targetObj.style.display="none";
   if(openTip  &&  shutTip){
    sourceObj.innerHTML = shutTip;
   }
} else {
   targetObj.style.display="block";
   if(openTip  &&  shutTip){
    sourceObj.innerHTML = openTip;
   }
}
}
</script>


<ul>

   <li><b> http request style</b>
<br>
<br>
<ul>

<li><a href="###" onclick="openShutManager(this,'item1',false)">borrow the object from pool</a></li>

  <pre id="item1" style="display:none">
	Request:
	        GET http://localhost/common-remote-pool/service/object/borrow

	Response: has resource
		response code:200
		response body: json
		example: {"domain":"10.224.64.225","user":"6731"}

	Response: no resource
		response code:404

</pre>


<li><a href="###" onclick="openShutManager(this,'item2',false)">return resource to pool</a></li>

<pre id="item2" style="display:none">
	Request:
		POST http://localhost/common-remote-pool/service/object/return
 		body: json
		example: {"domain":"10.224.64.225","user":"6731"}

	Response:
		response code:204
</pre>


<li><a href="###" onclick="openShutManager(this,'item3',false)">add resource to pool</a></li>

<pre id="item3" style="display:none">
	Request:
		POST http://localhost/common-remote-pool/service/object/add
 		body: json
		example: {"domain":"10.224.64.225","user":"6731"} or [{"domain":"10.224.64.225","user":"6731"},{"domain":"10.224.64.13","user":"6732"}]

	Response:
		response code:200
</pre>


<li><a href="###" onclick="openShutManager(this,'item4',false)">get borrowed resource number</a></li>

<pre id="item4" style="display:none">
	Request:
		GET http://localhost/common-remote-pool/service/object/active

	Response:
		response code:200
		response body: number
</pre>


<li><a href="###" onclick="openShutManager(this,'item5',false)">get idle resource number</a></li>

<pre id="item5" style="display:none">
	Request:
		GET http://localhost/common-remote-pool/service/object/idle

	Response:
		response code:200
		response body: number
</pre>


<li><a href="###" onclick="openShutManager(this,'item6',false)">get pools resource amount info</a></li>

<pre id="item6" style="display:none">
	Request:
		GET http://localhost/common-remote-pool/service/object/idle

	Response:
		response code:200
		response body: {"idleNumber":3,"borrowedNumber":3,"totalNumber":6}
</pre>


<li><a href="###" onclick="openShutManager(this,'item7',false)">flush all resource</a></li>

<pre id="item7" style="display:none">
	Request:
		GET http://localhost/common-remote-pool/service/object/drain

	Response:
		response code:200
 </pre>


<li><a href="###" onclick="openShutManager(this,'item8',false)">query current enabled resource factory</a></li>

<pre id="item8" style="display:none">
	Request:
		GET http://localhost/common-remote-pool/service/object/getFactory

	Response:
		response code:200
		response content: such as com.googlecode.common.remote.pool.resource.DefaultResourceFactory
 </pre>

 <li><a href="###" onclick="openShutManager(this,'item9',false)">list all idle objects in pool</a></li>

<pre id="item9" style="display:none">
	Request:
		GET http://localhost/common-remote-pool/service/object/list

	Response:
		response code:200
		response content: "no any no any resource" or {file=1.txt, owner=jiafu};1398308940353
 </pre>

</ul>
</li>

<br>
<br>

<li><b> client style </b></li>

<br>
The client's code amount is so small that you can copy the <a href="http://code.google.com/p/common-remote-pool/source/browse/common-remote-pool/src/main/java/com/googlecode/common/remote/pool/client/CommonRemotePoolClient.java">code</a> directly.
<p>
<pre>
com.googlecode.common.remote.pool.client.CommonRemotePoolClient.CommonRemotePoolClient(String)
com.googlecode.common.remote.pool.client.CommonRemotePoolClient.borrowObject(Class<T>)
com.googlecode.common.remote.pool.client.CommonRemotePoolClient.returnObject(Object)
com.googlecode.common.remote.pool.client.CommonRemotePoolClient.addObject(Object...)
</pre>

<p>
Dependence:
<i>
<xmp>       <dependency>
            <groupId>org.jboss.resteasy</groupId>
            <artifactId>resteasy-jackson-provider</artifactId>
            <version>2.3.1.GA</version>
        </dependency>
        <dependency>
            <groupId>org.jboss.resteasy</groupId>
            <artifactId>resteasy-client</artifactId>
            <version>3.0.2.Final</version>
        </dependency>
</xmp>
</i>

</ul>
