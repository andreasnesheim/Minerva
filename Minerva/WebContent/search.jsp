<%@page import="Connection.ProfileCon"%>
<%
String search = request.getParameter("search");
%>
<form class="form-search">
	<div class="input-append">
		<input type="text" class="span2 search-query" />
		<button type="submit" class="btn">S&oslash;k</button>
	</div>
</form>

<%	if (search != null) {
	List<Profile> searchProfiles = ProfileCon.search%>
	<h2>Profiler</h2>
	<div class="span12">
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Fornavn</th>
					<th>Etternavn</th>
					<th>Sted</th>
				</tr>
			</thead>
			<tbody>
				<% for () %>
				<tr>
					
			</tbody>
		</table>
	</div>
<%	} %>