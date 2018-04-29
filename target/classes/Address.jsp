<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="neu.edu.entity.Users"%>
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

h2 {
	margin-left: 3cm;
}

.container {
	width: 40%;
	margin: 0 auto;
	padding-top: 1cm;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://iamrohit.in/lab/js/location.js"></script>
</head>
<body background="img1.jpg">
	<table width="100%">
		<tr>
			<td align="right"><a href="<%=response.encodeURL("Logout")%>">Logout</a></td>
		</tr>
	</table>
	<div class="container">
		<h2>
			<span style='color: green'>Address</span>
		</h2>
		<form action="Controller" name="addressjsp" method="post">
			<table cellpadding="6" cellspacing="6">
				<tr>
					<td>Street no</td>
					<td><span style='padding-left: 70px'></span><input
						type="text" name="street" value="${cityAttribute.street}"
						placeholder="Street" pattern="[a-zA-Z0-9 ]{5,50}"
						title="Street Name should contain minimum 5 and maximum 50 characters"></td>
				</tr>
				<tr>
					<td>Country</td>
					<td><span style='padding-left: 70px'></span><select 
						name="country" class="countries" id="countryId"><option
								style="color: green;">${cityAttribute.country}</option></select></td>
				</tr>
				<tr>
					<td>State</td>
					<td><span style='padding-left: 70px'></span><select 
						name="state" class="states" id="stateId">
							<option style="color: green;">${cityAttribute.state}</option>
					</select></td>
				</tr>
				<tr>
					<td>City</td>
					<td><span style='padding-left: 70px'></span><select 
						name="city" class="cities" id="cityId">
							<option style="color: green;">${cityAttribute.city}</option>
					</select></td>
				</tr>
				<tr>
					<td>Zip Code</td>
					<td><span style='padding-left: 70px'></span><input 
						type="text" name="zipcode" placeholder="Zipcode"
						value="${cityAttribute.zipcode}"></td>
				</tr>
			</table>
			<br> <input type="hidden" name="pageName" value="addressjsp">
			<span style='padding-left: 50px; color: green'> <input
				type="submit" id="button1" name="action" value="Previous" /> <input
				type="submit" id="button1" name="action" value="Next" /></span>
		</form>
	</div>
</body>
</html>