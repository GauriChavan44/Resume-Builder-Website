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

b {
	margin-left: 2cm;
}

h2 {
	margin-left: 4cm;
}

.container {
	width: 50%;
	margin: 0 auto;
}
</style>
<script>
	function updateProjectNo() {
		if (document.getElementById('projectNumber').value == 0) {
			document.getElementById('title1').style.visibility = "hidden";
			document.getElementById('description1').style.visibility = "hidden";
			document.getElementById('title2').style.visibility = "hidden";
			document.getElementById('description2').style.visibility = "hidden";
			document.getElementById('title3').style.visibility = "hidden";
			document.getElementById('description3').style.visibility = "hidden";
		}
		if (document.getElementById('projectNumber').value == 1) {
			document.getElementById('title1').style.visibility = "visible";
			document.getElementById('description1').style.visibility = "visible";
			document.getElementById('title2').style.visibility = "hidden";
			document.getElementById('description2').style.visibility = "hidden";
			document.getElementById('title3').style.visibility = "hidden";
			document.getElementById('description3').style.visibility = "hidden";
		}
		if (document.getElementById('projectNumber').value == 2) {
			document.getElementById('title1').style.visibility = "visible";
			document.getElementById('description1').style.visibility = "visible";
			document.getElementById('title2').style.visibility = "visible";
			document.getElementById('description2').style.visibility = "visible";
			document.getElementById('title3').style.visibility = "hidden";
			document.getElementById('description3').style.visibility = "hidden";
		}
		if (document.getElementById('projectNumber').value == 3) {
			document.getElementById('title1').style.visibility = "visible";
			document.getElementById('description1').style.visibility = "visible";
			document.getElementById('title2').style.visibility = "visible";
			document.getElementById('description2').style.visibility = "visible";
			document.getElementById('title3').style.visibility = "visible";
			document.getElementById('description3').style.visibility = "visible";
		}
	}
</script>
</head>
<body background="img1.jpg">
	<table width="100%">
		<tr>
			<td align="right"><a href="<%=response.encodeURL("Logout")%>">Logout</a></td>
		</tr>
	</table>
	<div class="container">
		<form action="Controller" method="post" name="academicprojectjsp">
			<h2>
				<span style='color: green'>Academic Projects</span>
			</h2>
			<table cellpadding="6" cellspacing="6">
				<tr>
					<td><b>Number of projects</b></td>
					<td><input id="projectNumber" type="text"
						placeholder="No. of Projects" name="numberOfProject"
						pattern="[0-3]{1}"
						title="No. of Projects field can only contain numbers from 0 to 3"
						onChange="updateProjectNo();"></td>
				</tr>
				<tr id="title1">
					<td><b>1] Title</b></td>
					<td><input id="projectNumber1" type="text" id="textBox"
						placeholder="Title 1" name="project1Title"
						value="${projectAttribute.project1title}"></td>
				</tr>
				<tr id="description1">
					<td><b>Description</b></td>
					<td><textarea id="projectNumber11" rows="4" cols="50" maxlength="45"
							placeholder="Description 1" name="project1Description">${projectAttribute.project1description}</textarea></td>
				</tr>
				<tr id="title2">
					<td><b>2] Title</b></td>
					<td><input id="projectNumber2" type="text"
						placeholder="Title 2" id="textBox" name="project2Title"
						value="${projectAttribute.project2title}"></td>
				</tr>
				<tr id="description2">
					<td><b>Description</b></td>
					<td><textarea id="projectNumber22" rows="4" cols="50" maxlength="45"
							placeholder="Description 2" name="project2Description">${projectAttribute.project2description}</textarea></td>
				</tr>
				<tr id="title3">
					<td><b>3] Title</b></td>
					<td><input id="projectNumber3" type="text"
						placeholder="Title 3" id="textBox" name="project3Title"
						value="${projectAttribute.project3title}"></td>
				</tr>
				<tr id="description3">
					<td><b>Description</b></td>
					<td><textarea id="projectNumber33" rows="4" cols="50" maxlength="45"
							placeholder="Description 3" name="project3Description">${projectAttribute.project3description}</textarea></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><span style='padding-left: 250px'></span></td>
					<td><input type="hidden" name="pageName"
						value="academicprojectjsp"> <input type="submit"
						id="button1" name="action" value="Previous" /> <input
						type="submit" id="button1" name="action" value="Next" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>