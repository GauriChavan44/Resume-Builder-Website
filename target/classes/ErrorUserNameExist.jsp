<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#button1 {
	border: none;
	color: white;
	padding: 8px 30px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 3px 2px;
	cursor: pointer;
}

.container {
	width: 20%;
	margin: 0 auto;
	padding-top: 3cm;
}
</style>
</head>
<body background="img1.jpg">
	<div class="container">
		<form action=Controller method="post" name="registrationError">
			<h2>User Name Exists!!</h2>
			<input type="hidden" name="pageName" value="registrationError" /> <input
				type="submit" id="button1" name="action" value="Previous" />
		</form>
	</div>
</body>
</html>