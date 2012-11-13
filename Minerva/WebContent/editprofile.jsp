<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit profile</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>

</head>
<body>
	<div class="container">
	<div class="span6">
		<h1>Endre profil</h1>
	</div>
		<form action="storeuserinfo" method="post">
		<div class="well span6">
				Velg bilde <input type="file" name="img">
				<input type="submit" value="Last opp">
		</div>
		<br> <br>
			<label>Fornavn <input type="text" name="firstname" class="span3 pull-right" /></label><br> 
			<label>Etternavn <input type="text" name="lastname" class="span3 pull-right" /></label><br> 
			<label>Alder <input type="text" name="age" class="span3 pull-right" /></label><br>
			<label>Bosted <input type="text" name="location" class="span3 pull-right" /></label><br>
			<label>Interesser <input type="text" name="interests" class="span3 pull-right" /></label><br>
			
			<label>Sex: 
			<select>
  				<option value="volvo">Male</option>
  				<option value="saab">Female</option>
			</select>
			</label>
			
			<label>Kjønn <input type="text" name="sex" class="span3 pull-right" /></label><br><br> 
			
		<br>
		<div class="well span6">
			<strong>Informasjon:</strong> <br>
			<textarea class="field span6" name="information" id="textarea" rows="6"
			placeholder="Write your bio here..."></textarea>
			<br>
			<button type="submit" class="btn btn-primary">Lagre endringer</button>
		</div>
		</form>
	</div>


</body>
</html>