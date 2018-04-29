<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

h1 {
	margin-left: 3cm;
	color: green;
}

.container {
	width: 40%;
	margin: 0 auto;
	padding-top: 1cm;
}
</style>
</head>
<body background="img1.jpg">

	<form action="Controller" method="post" name="dashboardjsp">
		<table width="100%">
			<tr>
				<td width="75%" align="left"><h1>
						<span style='padding-left: 320px'>Welcome User
							${user1.userName}</span>
					</h1></td>
				<td align="right"><a href="<%=response.encodeURL("Logout")%>">Logout</a></td>
			</tr>
		</table>
		<div class="container">

			<input type="hidden" name="action" value="dashboardjsp"> <span
				style='padding-left: 80px'></span> <br> <input type="submit"
				id="button1" name="task" value="Enter Details" /> <input
				type="submit" id="button1" name="task" value="View Resume" />
		</div>
	</form>

</body>
</html>