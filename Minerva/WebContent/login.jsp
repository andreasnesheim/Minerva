<div class="span3">
	<form class="well">
		<p>Velkommen, <%=session.getAttribute("firstname")%> <%=session.getAttribute("lastname")%>! 
		Land: <%=session.getAttribute("country")%> Språk: <%=session.getAttribute("language")%> </p>
		<a href="viewprofile.jsp?myprofile=true">Min profil</a><br> 
		<a href="">Mine meldinger</a><br> 
		<a href="">Logg ut</a>
	</form>
</div>