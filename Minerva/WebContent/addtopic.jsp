<div class="container">
	<div class="span6">
		<h1>Edit Profile</h1>
	</div>
	<br>
	<form action="addtopic?subcategoryId=<%=request.getParameter("subcategoryId") %>" method="post" class="well span6">
			<label>Navn <input type="text" name="name" class="span3 pull-right" /></label><br> 
			<label>Beskrivelse <input type="text" name="description" class="span3 pull-right" /></label><br> 
			<br>
			<button type="submit" class="btn btn-primary">Lagre</button>
	</form>
</div>