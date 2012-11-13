<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
</head>
<body>
<div class="container">
	<div class="span6">
	<h1>Edit Profile</h1>
	</div>
	<form action="uploadimage" class="well span6" enctype="multipart/form-data" method="post">
		Velg bilde<input type="file" name="file" >
				  <input type="submit" value="Last opp">
	</form>
	<br>
	<br>
	<form id="storeuserinfo" action="storeuserinfo" method="post" class="well span6">
			<label>Fornavn <input type="text" name="firstname" class="span3 pull-right" /></label><br> 
			<label>Etternavn <input type="text" name="lastname" class="span3 pull-right" /></label><br> 
			<label>Alder <input type="text" name="age" class="span3 pull-right" /></label><br>
			<label>Bosted <input type="text" name="location" class="span3 pull-right" /></label><br>
			<label>Interesser <input type="text" name="interests" class="span3 pull-right" /></label><br>
			<label>Kjønn 
			<select class="span3 pull-right" name="sex">
  				<option value="male">Mann</option>
  				<option value="female">Kvinne</option>
			</select>
			</label>
			<br>
				<strong>Informasjon:</strong> <br>
				<textarea class="field span6" id="textarea" name="information" rows="6">Info her..</textarea>
					<br>
					<button type="submit" class="btn btn-primary">Lagre endringer</button>
			</form>
		</div>
	

</body>
</html>