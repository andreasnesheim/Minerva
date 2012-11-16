<div class="well span2 pull-right">
		<p>Velkommen, <%=session.getAttribute("firstname")%> <%=session.getAttribute("lastname")%>! </p>
		<i class="icon-user"></i>&nbsp;<a href="?page=viewprofile&profileId=<%=request.getSession().getAttribute("id")%>">Min profil</a><br> 
		<i class="icon-off"></i>&nbsp;<a href="logout">Logg ut</a>
</div>