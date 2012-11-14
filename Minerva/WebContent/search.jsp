<%@page import="Connection.TopicCon"%>
<%@page import="Connection.ProfileCon,tables.*,java.util.*"%>
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
	List<Profile> searchProfiles = ProfileCon.searchProfiles(search);
	List<Topic> searchTopics = TopicCon.%>
	<h2>Profiler</h2>
	<div class="span12">
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Navn</th>
					<th>Sted</th>
				</tr>
			</thead>
			<tbody>
			<% for (int i = 0; i < searchProfiles.size(); i++) {%>
				<tr>
					<td>
						<a href="?page=viewprofile&profileId=<%=searchProfiles.get(i).getUserId() %>">
						<%=searchProfiles.get(i).getFirstName() %>&nbsp;<%=searchProfiles.get(i).getLastName() %></a>
					</td>
					<td><%=searchProfiles.get(i).getLocation() %></td>
				</tr>
			<% } %>		
			</tbody>
		</table>
	</div>
	<br />
	<h2>Tr&aring;der</h2>
	
<%	} %>