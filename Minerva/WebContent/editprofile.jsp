<%@ page import="Connection.*, tables.*" %>

<%
long profileId = Long.parseLong(session.getAttribute("id").toString());
Profile profile = ProfileCon.getProfile(profileId);

//	user data
String firstName = profile.getFirstName();
String lastName = profile.getLastName();
int age = profile.getAge();
String location = profile.getLocation();
String interests = profile.getInterests();
String sex = profile.getSex();
String information = profile.getInformation();

//	image
String image = profile.getImage();
%>

<div class="row">
	<div class="span6">
		<h1>Endre profil</h1>
	</div>
</div>
<div class="row">
	<% if (!image.isEmpty()) { %>
	<div class="span2">
		<ul class="thumbnails">
			<li class="well">
				<img src="<%= image %>" alt="Profilbilde" />
			</li>
		</ul>
	</div>
	<% } %>
	<div class="span5">
		<form action="uploadimage" class="well" enctype="multipart/form-data" method="post">
			Endre bilde: <input type="file" name="file" />
			<button class="btn" type="submit">Last opp</button>
		</form>
	</div>
	<div class="span5">
		<form action="storeuserinfo" class="well" method="post">
			<button class="btn btn-inverse" type="submit">Slett bilde</button>
			<input type="hidden" name="deleteImage" value="reset" />
		</form>
	</div>
</div>

<div class="row">
<form id="storeuserinfo" action="storeuserinfo" method="post" class="well span6">
	<label>Fornavn <input type="text" name="firstname" class="span3 pull-right"
		value="<% if (firstName != null) out.print(firstName); %>" />
	</label><br /> 
	<label>Etternavn <input type="text" name="lastname" class="span3 pull-right"
		value="<% if (lastName != null) out.print(lastName); %>" />
	</label><br /> 
	<label>Alder <input type="text" name="age" class="span3 pull-right"
		value="<%= age %>" />
	</label><br />
	<label>Bosted <input type="text" name="location" class="span3 pull-right"
		value="<% if (location != null) out.print(location); %>" />
	</label><br />
	<label>Interesser <input type="text" name="interests" class="span3 pull-right"
		value="<% if (interests != null) out.print(interests); %>" />
	</label><br />
	<label>Kj&oslash;nn
		<select class="span3 pull-right" name="sex">
			<option value="Mann">Mann</option>
			<option value="Kvinne">Kvinne</option>
		</select>
	</label>
	<br />
	<strong>Informasjon:</strong>
	<br />
	<textarea class="field span6" id="textarea" name="information" rows="6"><% if (information != null) out.print(information); %></textarea>
	<br />
	<input type="hidden" name="image" />
	<button type="submit" class="btn btn-primary">Lagre endringer</button>
</form>
</div>