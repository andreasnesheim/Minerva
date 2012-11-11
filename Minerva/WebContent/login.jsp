<div class="span3">
	<form class="well">
		<p>Velkommen, <%=session.getAttribute("firstname")%> <%=session.getAttribute("lastname")%>! </p>
		<a href="viewprofile.jsp?myprofile=true">Min profil</a><br> 
		<a href="">Mine meldinger</a><br> 
		<a href="">Logg ut</a>
	</form>
</div>