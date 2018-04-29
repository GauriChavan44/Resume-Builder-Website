<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.container {
	width: 40%;
	margin: 0 auto;
	padding-top: 1cm;
}

h1 {
	color: green;
	margin-left: 1cm;
	font-style: italic;
	text-decoration: underline;
}
</style>
</head>
<body background="img1.jpg">
	<table width="100%">
		<tr>
			<td align="right"><a
				href="<%=response.encodeURL("LoginForm.jsp")%>">Login Page</a></td>
		</tr>
	</table>
	<div class="container">
		<h1>RESUME BUILDER</h1>
		<h4>Resume Builder helps you to build your Resume!</h4>
		<h4>You can fill your information which include</h4>
		<h4>
			<ul>
				<li>Name</li>
				<li>About Me</li>
				<li>Address</li>
				<li>Educational Background</li>
				<li>Projects Completed</li>
				<li>Skills you possess</li>
			</ul>
		</h4>
		<h4>You first need to create an account and then build a resume
			by filling all the above mentioned information</h4>
		<h4>Consolidated view can be seen once you log into your account</h4>
		<h4>GO AHEAD AND BUILD YOUR RESUME !!</h4>
	</div>
</body>
</html>