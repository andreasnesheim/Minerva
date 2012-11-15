<div class="well span2 pull-right">
		<p>Velkommen, <%=session.getAttribute("firstname")%> <%=session.getAttribute("lastname")%>! </p>
		<a href="?page=viewprofile&profileId=<%=request.getSession().getAttribute("id")%>">Min profil</a><br> 
		<a href="logout">Logg ut</a>
</div>