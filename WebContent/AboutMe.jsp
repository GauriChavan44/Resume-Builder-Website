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

b, input, h2, textarea {
	margin-left: 2cm;
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
			<td align="right"><a href="<%=response.encodeURL("Logout")%>">Logout</a></td>
		</tr>
	</table>
	<div class="container">
		<form action="Controller" method="post" name="aboutMejsp">
			<h2>ABOUT ME PAGE</h2>
			<textarea rows="15" cols="65" name="aboutMe"
				placeholder="Enter about me" maxlength="500" minlength="10"
				title="About Me field should contain minimum 10 characters and maximum 500 characters">${aboutMeAttribute.aboutMe}</textarea>
			<br> <br> <input type="hidden" name="pageName"
				value="aboutMejsp"> <span style='padding-left: 230px'></span>
			<input type="submit" id="button1" name="action" value="Next" />
		</form>
	</div>
</body>
</html>