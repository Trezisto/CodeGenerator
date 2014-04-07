<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <title>Code Generator | Main Page</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="css/style.css" />" />
	<script type="text/javascript" src="<c:url value="js/fsm.js" />"></script>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="http://malsup.github.com/jquery.form.js"></script>
	<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	 <script>
		//using jquery.form.js
		 function uploadJqueryForm(){
		     $('#result').html('');
		  
		    $("#form2").ajaxForm({
		     success:function(data) {
		           $('#result').html(data);
		      },
		      dataType:"text"
		    }).submit();
		 }
	 
		$(function() {
			var availableTags = [
				"C++",
				"Java",
				"JavaScript"
			];
			$( "#lang" ).autocomplete({
				source: availableTags
			});
		});
	</script>
</head>
<body>
	<div id="head"><h1>Code Generator</h1></div>
	
	<div id="menu">
		<form id="form2" method="post" action="/index/upload" enctype="multipart/form-data">
		  <!-- File input -->    
		  <input name="file2" id="file2" type="file" /><br/>
		</form>
		<button value="Upload" onclick="uploadJqueryForm()" >Upload XML file</button>
		<button value="Export" onclick="exportXML()" >Export to XML</button>
		
		<div id="result"></div>
		
		<div class="line"></div>
		
		<div class="ui-widget">
			<label for="lang">Language: </label>
			<input id="lang">
		</div>
		<button value="Submit" onclick="submit()">Submit</button>
		<button value="Reset" onclick="reset()">Reset</button>
		
		<div><a href="1.html">Home</a></div>
		<div><a href="2.html">My page</a></div>
		<div><a href="3.html">Preferences</a></div>
	   	<div class="line"></div>
	  	<div><a href="4.html">About</a></div>
	</div>
	 	
	<div id="content">
		<canvas id="canvas" width="800" height="600">
			Your browser does not support the HTML5 canvas element
		</canvas>
		<h2>About</h2>
	   	<p>Created by Netscape in 1995 as an extension of HTML for Netscape Navigator 2.0, JavaScript had as its main function the manipulation of HTML documents and form validation. Before winning this name so famous nowadays, JavaScript was called Mocha, after LiveScript and finally, when it was released by Sun Microsystems, was baptized with the name by which he is known today. Because of the similar names, people confuses JavaScript with Java. Although both have the lexical structure of programming, they are not the same language. Different from C, C# and Java, JavaScript is an interpreted language. It means that it needs an "interpreter". In case of JavaScript, the interpreter is the browser. </p>
	</div>
	
	<div id="foot">Copyright &copy; Evgheni Prijilevschi</div>
	
	</body>
</html>
