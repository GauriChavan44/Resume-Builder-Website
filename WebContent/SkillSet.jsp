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
	width: 40%;
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
		<form action="Controller" name="skillsetjsp" method="post">
			<h3>
				<span style='color: green'>Enter top 5 skills and rate yourself on the scale 0 to 10</span>
			</h3>
			<table cellpadding="6" cellspacing="6">
				<tr>
					<td><b>Skill 1</b></td>
					<td><input type="text" id="textBox" name="skill1"
						pattern="[a-zA-Z0-9,.+- ]{2,20}"
						title="Skill field can contain minimum 2 and maximum 20 characters"
						value="${skillAttribute.skill1}"></td>
					<td><span style='padding-left: 70px'></span><b>Rating</b></td>
					<td><input type="number" id="textBox" name="skill1Rating"
						value="${skillAttribute.skill1rating}" min="0" max="10"></td>
				</tr>
				<tr>
					<td><b>Skill 2</b></td>
					<td><input type="text" id="textBox" name="skill2"
						pattern="[a-zA-Z0-9,.+- ]{2,20}"
						title="Skill field can contain minimum 2 and maximum 20 characters"
						value="${skillAttribute.skill2}"></td>
					<td><span style='padding-left: 70px'></span><b>Rating</b></td>
					<td><input type="number" id="textBox" name="skill2Rating"
						value="${skillAttribute.skill2rating}" min="0" max="10"></td>
				</tr>
				<tr>
					<td><b>Skill 3</b></td>
					<td><input type="text" id="textBox" name="skill3"
						pattern="[a-zA-Z0-9,.+- ]{2,20}"
						title="Skill field can contain minimum 2 and maximum 20 characters"
						value="${skillAttribute.skill3}"></td>
					<td><span style='padding-left: 70px'></span><b>Rating</b></td>
					<td><input type="number" id="textBox" name="skill3Rating"
						value="${skillAttribute.skill3rating}" min="0" max="10"></td>
				</tr>
				<tr>
					<td><b>Skill 4</b></td>
					<td><input type="text" id="textBox" name="skill4"
						pattern="[a-zA-Z0-9,.+- ]{2,20}"
						title="Skill field can contain minimum 2 and maximum 20 characters"
						value="${skillAttribute.skill4}"></td>
					<td><span style='padding-left: 70px'></span><b>Rating</b></td>
					<td><input type="number" id="textBox" name="skill4Rating"
						value="${skillAttribute.skill4rating}" min="0" max="10"></td>
				</tr>
				<tr>
					<td><b>Skill 5</b></td>
					<td><input type="text" id="textBox" name="skill5"
						pattern="[a-zA-Z0-9,.+- ]{2,20}"
						title="Skill field can contain minimum 2 and maximum 20 characters"
						value="${skillAttribute.skill5}"></td>
					<td><span style='padding-left: 70px'></span><b>Rating</b></td>
					<td><input type="number" id="textBox" name="skill5Rating"
						value="${skillAttribute.skill5rating}" min="0" max="10"></td>
				</tr>

			</table>
			<br> <br> <span style='padding-left: 80px'></span> <input
				type="hidden" name="pageName" value="skillsetjsp"> <span
				style='padding-left: 20px'></span><input type="submit" id="button1"
				name="action" value="Previous" /> <input type="submit" id="button1"
				name="action" value="Submit" />
		</form>
	</div>
</body>
</html>