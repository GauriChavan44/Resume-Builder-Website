<%@page import="neu.edu.entity.SkillTable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	SkillTable skillSet = (SkillTable) request.getSession().getAttribute("skillAttribute");
	Integer skillone = 0;
	Integer skilltwo = 0;
	Integer skillthree = 0;
	Integer skillfour = 0;
	Integer skillfive = 0;
	if (skillSet.getSkill1rating() != null && skillSet.getSkill2rating() != null
			&& skillSet.getSkill3rating() != null && skillSet.getSkill4rating() != null
			&& skillSet.getSkill5rating() != null) {
		skillone = skillSet.getSkill1rating() * 50;
		skilltwo = skillSet.getSkill2rating() * 50;
		skillthree = skillSet.getSkill3rating() * 50;
		skillfour = skillSet.getSkill4rating() * 50;
		skillfive = skillSet.getSkill5rating() * 50;
	}
%>
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

h2, h1 {
	color: green;
}

.container {
	width: 55%;
	margin: 0 auto;
	padding-top: 1cm;
}

#progressBar {
	position: relative;
	width: 500px;
	height: 30px;
	background-color: #ddd;
}

#skill1 {
	position: absolute;
	width: <%=skillone%>px;
	height: 30px;
	background-color: green;
}

#skill2 {
	position: absolute;
	width: <%=skilltwo%>px;
	height: 30px;
	background-color: green;
}

#skill3 {
	position: absolute;
	width: <%=skillthree%>px;
	height: 30px;
	background-color: green;
}

#skill4 {
	position: absolute;
	width: <%=skillfour%>px;
	height: 30px;
	background-color: green;
}

#skill5 {
	position: absolute;
	width: <%=skillfive%>px;
	height: 30px;
	background-color: green;
}

#label {
	text-align: center;
	line-height: 30px;
	color: white;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://iamrohit.in/lab/js/location.js"></script>
<script>
	function gc() {
		var lat = '';
		var longi = '';
		var zip = '${cityAttribute.zipcode}';
		var geocoder = new google.maps.Geocoder();
		geocoder.geocode({
			'address' : zip
		}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				lat = results[0].geometry.location.lat();
				longi = results[0].geometry.location.lng();
			} else {
			}
			var mapCanvas = document.getElementById('map');
			var mapOptions1 = {
				center : new google.maps.LatLng(lat, longi),
				zoom : 8
			};
			var map = new google.maps.Map(mapCanvas, mapOptions1);
		});

	}
</script>
<script async defer
	src='https://maps.googleapis.com/maps/api/js?key=AIzaSyDBar_R3M919kyfhIJUQrBwnC2bSBWVaLI&callback=func'>
	
</script>
<br>
</head>
<body onload="gc()" background="img1.jpg">
	<table width="100%">
		<tr>
			<td align="right"><a href="<%=response.encodeURL("Logout")%>">Logout</a></td>
		</tr>
	</table>
	<div class="container">
		<form action="Controller" method="post" name="displayresumejsp">
			<table cellpadding="6" cellspacing="6">
				<tr>
					<td colspan="2"><span style='padding-left: 30px'></span>
					<h1>
							<i>RESUME</i>
						</h1></td>
				</tr>
				<tr>
					<td><span style='padding-left: 40px'></span>
					<h2>Name</h2></td>
					<td><span style='padding-left: 60px'></span>
					<h2>${user1.name}</h2></td>
				</tr>
				<tr>
					<td><span style='padding-left: 40px'></span>
					<h2>About Me</h2></td>
					<td><span style='padding-left: 60px'></span>
					<h4>${aboutMeAttribute.aboutMe}</h4></td>
				</tr>
				<tr>
					<td colspan="2"><div id='map'
							style='width: 400px; height: 400px; background: white;'></div></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2">
						<h2>EDUCATION</h2>
					</td>
				</tr>
				<tr>
					<td><span style='padding-left: 40px'></span>
					<h3>Graduate School</h3></td>
					<td><span style='padding-left: 60px'></span>
					<h3>Under Graduate School</h3></td>
				</tr>
				<tr>
					<td><span style='padding-left: 40px'></span>
					<h4>Name : ${educationAttribute.graduateSchoolName}</h4></td>
					<td><span style='padding-left: 60px'></span>
					<h4>Name : ${educationAttribute.underGraduateSchoolName}</h4></td>
				</tr>
				<tr>
					<td><span style='padding-left: 40px'></span>
					<h4>Major : ${educationAttribute.graduateMajor}</h4></td>
					<td><span style='padding-left: 60px'></span>
					<h4>Major : ${educationAttribute.underGraduateMajor}</h4></td>
				</tr>
				<tr>
					<td><span style='padding-left: 40px'></span>
					<h4>Courses :${educationAttribute.graduateCourses}</h4></td>
					<td><span style='padding-left: 60px'></span>
					<h4>Courses : ${educationAttribute.underGraduateCourses}</h4></td>
				</tr>
				<tr>
					<td><span style='padding-left: 40px'></span>
					<h4>CGPA : ${educationAttribute.graduatecgpa}</h4></td>
					<td><span style='padding-left: 60px'></span>
					<h4>CGPA : ${educationAttribute.underGraduatecgpa}</h4></td>
				</tr>
				<tr>
					<td colspan="2"><h2>ACADEMIC PROJECTS</h2></td>
				</tr>
				<tr>
					<td><span style='padding-left: 40px'></span>
					<h4>Project1 Title : ${projectAttribute.project1title}</h4></td>
					<td><span style='padding-left: 60px'></span>
					<h4>Project1 Description :
							${projectAttribute.project1description}</h4></td>
				</tr>
				<tr>
					<td><span style='padding-left: 40px'></span>
					<h4>Project2 Title : ${projectAttribute.project2title}</h4></td>
					<td><span style='padding-left: 60px'></span>
					<h4>Project2 Description :
							${projectAttribute.project2description}</h4></td>
				</tr>
				<tr>
					<td><span style='padding-left: 40px'></span>
					<h4>Project3 Title : ${projectAttribute.project3title}</h4></td>
					<td><span style='padding-left: 60px'></span>
					<h4>Project3 Description :
							${projectAttribute.project3description}</h4></td>
				</tr>
				<tr>
					<td colspan="2"><h2>SKILL SET</h2></td>
				</tr>
				<tr>
					<td colspan="2">${skillAttribute.skill1}
						<div id='progressBar'>
							<div id='skill1'>
								<div id='label'></div>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">${skillAttribute.skill2}
						<div id='progressBar'>
							<div id='skill2'>
								<div id='label'></div>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">${skillAttribute.skill3}
						<div id='progressBar'>
							<div id='skill3'>
								<div id='label'></div>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">${skillAttribute.skill4}
						<div id='progressBar'>
							<div id='skill4'>
								<div id='label'></div>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">${skillAttribute.skill5}
						<div id='progressBar'>
							<div id='skill5'>
								<div id='label'></div>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td></td>
				</tr>
			</table>
			<input type="hidden" name="pageName" value="displayresumejsp" /><br>
			<br>
			<br> <span style='padding-left: 70px'></span> <input
				type="submit" id="button1" name="action" value="Dashboard" />
		</form>
	</div>
</body>
</html>