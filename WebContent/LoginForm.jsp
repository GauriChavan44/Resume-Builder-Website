<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
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

b, input, h3 {
	margin-left: 2cm;
}

h2 {
	margin-left: 5cm;
}

h1 {
	margin-left: 12cm;
	color: green;
	text-decoration-style: solid;
	font-style: italic;
	font-family: "Times New Roman";
}

.container {
	width: 50%;
	margin: 0 auto;
	padding-top: 1cm;
}
</style>
</head>
<body background="img1.jpg">
	<table width="100%">
		<tr>
			<td align="right"><a
				href="<%=response.encodeURL("AboutUs.jsp")%>">About RESUME
					BUILDER</a></td>
		</tr>
	</table>
	<form action="Controller" method="post" name="loginjsp">
		<h1>RESUME BUILDER</h1>
		<div class="container">
			<h2>LOGIN PAGE</h2>
			<table>
				<tr>
					<td><h3>User Name</h3></td>
					<td><input type="text" name="username" value="" /><br> <br></td>
				</tr>
				<tr>
					<td><h3>Password</h3></td>
					<td><input type="password" name="password" value="" /><br>
						<br></td>
				</tr>
				<tr>
					<td><input type="hidden" name="pageName" value="loginjsp" /></td>
				</tr>
				<tr>
					<td><span style='padding-left: 200px'> <input
							type="submit" id="button1" name="action" value="Login" /></span><br>
						<br> <br> <br></td>
				</tr>
				<tr>
					<td><b>Don't have an account ?</b></td>
					<td><input type="submit" id="button1" name="action"
						value="Registration" /></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>