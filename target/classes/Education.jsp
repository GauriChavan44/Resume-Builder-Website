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
		<form action="Controller" name="educationjsp" method="post">
			<table cellpadding="6" cellspacing="6">
				<tr>
					<td><h3>Graduate School</h3></td>
					<td></td>
					<td><h3>UnderGraduate School</h3></td>
					<td></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" id="textBox" placeholder="Name"
						pattern="[a-zA-Z0-9,-+. ]{2,30}"
						title="Name field should contain minimum 2 and maximum 30 characters"
						name="graduateSchoolName"
						value="${educationAttribute.graduateSchoolName}"></td>
					<td><span style='padding-left: 30px'></span>Name</td>
					<td><input type="text" id="textBox" placeholder="Name"
						pattern="[a-zA-Z0-9,-+. ]{2,30}"
						title="Name field should contain minimum 2 and maximum 30 characters"
						name="underGraduateSchoolName"
						value="${educationAttribute.underGraduateSchoolName}"></td>
				</tr>
				<tr>
					<td>Major</td>
					<td><input type="text" id="textBox" placeholder="Major"
						pattern="[a-zA-Z0-9,-+. ]{2,40}"
						title="Major field should contain minimum 2 and maximum 40 characters"
						name="graduateMajor" value="${educationAttribute.graduateMajor}"></td>
					<td><span style='padding-left: 30px'></span>Major</td>
					<td><input type="text" id="textBox" placeholder="Major"
						pattern="[a-zA-Z0-9,-+. ]{2,40}"
						title="Major field should contain minimum 2 and maximum 40 characters"
						name="underGraduateMajor"
						value="${educationAttribute.underGraduateMajor}"></td>
				</tr>
				<tr>
					<td>Courses</td>
					<td><input type="text" id="textBox" placeholder="Courses"
						pattern="[a-zA-Z0-9,-+. ]{2,40}"
						title="Courses field should contain minimum 2 and maximum 40 characters"
						name="graduateCourses"
						value="${educationAttribute.graduateCourses}"></td>
					<td><span style='padding-left: 30px'></span>Courses</td>
					<td><input type="text" id="textBox" placeholder="Courses"
						pattern="[a-zA-Z0-9,-+. ]{2,40}"
						title="Courses field should contain minimum 2 and maximum 40 characters"
						name="underGraduateCourses"
						value="${educationAttribute.underGraduateCourses}"></td>
				</tr>
				<tr>
					<td>CGPA</td>
					<td><input type="text" id="textBox" placeholder="CGPA"
						pattern="[0-9]+(\.[0-9]{0,2})?"
						title="CGPA field should contain a number with up to 2 decimal places"
						name="graduatecgpa" value="${educationAttribute.graduatecgpa}"></td>
					<td><span style='padding-left: 30px'></span>CGPA</td>
					<td><input type="text" id="textBox" placeholder="CGPA"
						pattern="[0-9]+(\.[0-9]{0,2})?"
						title="CGPA field should contain a number with up to 2 decimal places"
						name="underGraduatecgpa"
						value="${educationAttribute.underGraduatecgpa}"></td>
				</tr>
			</table>
			<br>
			<br> <span style='padding-left: 150px'></span> <input
				type="hidden" name="pageName" value="educationjsp"> <input
				type="submit" id="button1" name="action" value="Previous" /> <input
				type="submit" id="button1" name="action" value="Next" />
		</form>
	</div>
</body>
</html>