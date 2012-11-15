<%@page import="Connection.TopicCon"%>
<%@page import="Connection.ProfileCon,tables.*,java.util.*"%>
<%
String search = request.getParameter("search");
%>
<form action="search" class="form-search" method="post">
	<div class="input-append">
		<input type="text" name="searchQuery" class="input-xlarge search-query"
			value="<% if (search != null) out.print(search); %>" />
		<button type="submit" class="btn"><i class="icon-search"></i></button>
	</div>
</form>

<%	if (search != null) {
	List<Profile> searchProfiles = ProfileCon.searchProfiles(search);
	List<Topic> searchTopics = TopicCon.searchTopics(search);%>
	<h2>Profiler</h2>
	<div class="row"><div class="span12">
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
					<td>
						<%=searchProfiles.get(i).getLocation() %>
					</td>
				</tr>
			<% } %>		
			</tbody>
		</table>
	</div></div>
	<br />
	<h2>Tr&aring;der</h2>
	<div class="row"><div class="span12">
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Tr&aring;d</th>
					<th>Beskrivelse</th>
				</tr>
			</thead>
			<tbody>
			<% for (int i = 0; i < searchTopics.size(); i++) { %>
				<tr>
					<td>
						<a href="?page=topic&topicId=<%= searchTopics.get(i).getId() %>">
						<%= searchTopics.get(i).getName() %></a>
					</td>
					<td>
						<%= searchTopics.get(i).getDescription() %>
					</td>
				</tr>
			<% } %>
			</tbody>
		</table>
	</div></div>
<%	} %>