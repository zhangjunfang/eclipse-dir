<html>
<head>
<title>Common Remote Pool</title>

<link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/style.css">
<script src="scripts/jquery-1.11.0.js"></script>
<script src="scripts/ajaxfileupload.js"></script>

</head>
<body>

<script>
$(function(){
 	$("form#uploadForm").submit(function(){
      var formData = new FormData($(this)[0]);
    $.ajax({
        url: "service/file/upload",
        type: "POST",
        data: formData,
        async: false,
        success: function (data) {
            var uploadResultDiv = document.getElementById("uploadResultDiv");
            uploadResultDiv.innerHTML =data;
        },
        error: function() {
     		alert("FAIL");
    	},
        cache: false,
        contentType: false,
        processData: false
    });

    return false;
    });
});
</script>


<script>
window.onload =function(){
    $.ajax({
    type: "GET",
    url: "service/object/getFactory",
    success: function(data) {
            var currentFactory = document.getElementById("currentFactory");
            currentFactory.innerHTML=data;
    },
    error: function() {
 		alert("FAIL");
	}
    });

    return false;
};
</script>

<script>
$(function(){
    $("#enableForm").submit(function(){
        $.ajax({
        type: "POST",
        url: "service/file/setFactory",
        data: $("#enableForm").serialize(),
        success: function(data) {
                var currentFactory = document.getElementById("currentFactory");
                currentFactory.innerHTML =$("#enableForm").serialize().split("=")[1];
        },
        error: function() {
	 		alert("FAIL");
    }
        });

        return false;

    });
});
</script>


	<h1>ResourceFactory Implement Class Customized</h1>
<p>
<hr>
    <h3>Step 1: Upload ResourceFactory Implement Related Class/Resource</h3>

	<form id="uploadForm"   method="post"
		enctype="multipart/form-data">
		<p>
 		<label for="fileName">* Target full path :</label>
		<input type="text" name="fileName" value="com.googlecode.common.remote.pool.resource.DefaultResourceFactory.class" size="81"/>
 		<p>
		<label for="selectedFile">* Choose file :</label>
			 <input type="file" name="selectedFile" />
		<p>
 		  <button>upload</button>
	</form>
 <p>

     <div id="uploadResultDiv"></div>

    <h3>Step 2: Enable Core ResourceFactory Implement Class</h3>


	<form id="enableForm" enctype="application/x-www-form-urlencoded">
        <p><input type="text" name="fileName" value="com.googlecode.common.remote.pool.resource.DefaultResourceFactory" size="78"/>
        <p> 		    <button>enable</button>

     </form>

    Current Resource Factory is: <div id="currentFactory"></div>

	<p>
	<hr>
		<h4>Note: </h4>
		<p>The class should use implement <code>org.apache.commons.pool.PoolableObjectFactory</code>
		,its code example can refer to <a
			href="https://code.google.com/p/common-remote-pool/source/browse/common-remote-pool/src/main/java/com/googlecode/common/remote/pool/resource/DefaultResourceFactory.java">example</a>.What's
		more, you should add followed dependence into your pom.xml:
	<i>	<xmp>
<dependency>
  <groupId>commons-pool</groupId>
  <artifactId>commons-pool</artifactId>
  <version>1.6</version>
  <type>jar</type>
</dependency>
		</xmp></i>
<p>
</body>
</html>