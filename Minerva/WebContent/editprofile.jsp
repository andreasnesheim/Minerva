
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