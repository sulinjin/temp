<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<script src="/resources/js/jquery-3.6.0.js" ></script>
	<script type="text/javascript">
		$(document).ready(function(){
			alert("hello");		
		});
		
	</script>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<div id="button" style="background-color:red; cursor:pointer">버튼</div>
<image src="/resources/image/timmo.PNG">
</body>
</html>
