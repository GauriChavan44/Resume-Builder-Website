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

b, input {
	margin-left: 2cm;
}

h2 {
	margin-left: 4cm;
	color: green;
}

.container {
	width: 50%;
	margin: 0 auto;
	padding-top: 1cm;
}

td:nth-of-type(2) {
	padding-right: 30px;
}
</style>
<script>
	function validate() {
		var userName = document.forms["registrationjsp"]["userName"].value;
		var fullName = document.forms["registrationjsp"]["fullName1"].value;
		var passwordLength = document.forms["registrationjsp"]["password"].value.length;
		var password = document.forms["registrationjsp"]["password"].value;
		var confirmPassword = document.forms["registrationjsp"]["confirmPassword"].value;

		if (userName.toString().match('[a-zA-Z0-9][a-zA-Z0-9 ]+[a-zA-Z0-9]$')) {
			document.getElementById('registration1').innerHTML = "";
		} else {
			document.getElementById('registration1').innerHTML = "UserName field should contain minimum 3 characters and maximum 20 characters";
			return false;
		}

		if (fullName.toString().match("[a-zA-Z][a-zA-Z ]+[a-zA-Z]$")) {
			document.getElementById('registration2').innerHTML = "";
		} else {
			document.getElementById('registration2').innerHTML = "Name field should contain minimum 3 characters and maximum 30 characters";
			return false;
		}

		if (passwordLength > 6) {
			document.getElementById('registration3').innerHTML = "";
		} else {
			document.getElementById('registration3').innerHTML = "Password length should be greater than 6";
			return false;
		}

		if (password == confirmPassword) {
			document.getElementById('registration3').innerHTML = "";
		} else {
			document.getElementById('registration3').innerHTML = "Passwords do not match";
			return false;
		}
	}
</script>
</head>
<body background="img1.jpg">
	<table width="100%">
		<tr>
			<td align="right"><a href="<%=response.encodeURL("Logout")%>">Back</a></td>
		</tr>
	</table>
	<div class="container">
		<form action="Controller" name="registrationjsp" method="post"
			onsubmit="return validate()">
			<h2>Register for Free !!</h2>
			<table cellpadding="6" cellspacing="6">
				<tr>
					<td><b>UserName : </b></td>
					<td><input type="text" name="userName" placeholder="Username"
						maxlength="20" required /></td>
					<td><b style="color: red;" id=registration1></b></td>
				</tr>
				<tr>
					<td><b>Name : </b></td>
					<td><input type="text" name="fullName1" placeholder="Name"
						maxlength="30" required /></td>
					<td><b style="color: red;" id=registration2></b></td>
				</tr>
				<tr>
					<td><b>Email id : </b></td>
					<td><input type="text" name="emailAddress"
						placeholder="Email Id" maxlength="35" pattern="[^ @]*@[^ @]*"
						placeholder="Enter your email" /></td>
					<td><b style="color: red;"></b></td>
				</tr>
				<tr>
					<td><b>Password : </b></td>
					<td><input id="passwordid" type="password" name="password"
						placeholder="Password" maxlength="20" /></td>
					<td><b style="color: red;" id="registration3"></b></td>
				</tr>
				<tr>
					<td><b>Confirm Password : </b></td>
					<td><input type="password" name="confirmPassword"
						placeholder="Confirm Password" maxlength="20" /></td>
					<td><b style="color: red;" id="registration3"></b></td>
				</tr>
				<tr>
					<td><b>I am : </b></td>
					<td><span style='padding-left: 75px'></span><select
						name="gender" required>
							<option value="male">Male</option>
							<option value="female">Female</option>
					</select></td>
				</tr>
				<tr>
					<td><b>Age : </b></td>
					<td><input type="text" name="age" placeholder="Age"
						pattern=[0-9]{1,3} title="Age fileld can contain only numbers"
						required /></td>
					<td><b style="color: red;" id=registration7></b></td>
				</tr>
			</table>
			<br>
			<br> <span style='padding-left: 100px'></span> <input
				type="hidden" name="pageName" value="registrationjsp" /> <span
				style='padding-left: 100px'> <input type="submit"
				id="button1" name="action" value="Register" /></span><br>
			<br>
		</form>
	</div>
</body>
</html>