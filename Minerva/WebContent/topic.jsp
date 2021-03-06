<%@ page import="Connection.*"%>
<%@ page import="tables.*"%>
<%@ page import="java.util.List"%>

<%
Long topicId = Long.parseLong(request.getParameter("topicId"));
List<Profile> mentors = TopicCon.getListOfMentorsInTopic(topicId);
Topic currentTopic = TopicCon.getTopic(topicId);
%>

<div id="mainpage" class="row">
	<div id="breadcrumb" class="span5">
		<ul class="breadcrumb">
			<li>
				<a href="?page=categories">Emner</a>
				<span class="divider">/</span>
			</li>
			<li>
				<a href="?page=categories&categoryId=<%= TopicCon.getTopic(topicId).getSubCategory().getMainCategory().getId() %>">
				<%=TopicCon.getTopic(topicId).getSubCategory().getMainCategory().getName()%></a>
				<span class="divider">/</span>
			</li>
			<li>
				<a href="?page=subcategory&subcategoryId=<%=TopicCon.getTopic(topicId).getSubCategory().getId() %>">
				<%=TopicCon.getTopic(topicId).getSubCategory().getName()%></a>
				<span class="divider">/</span>
			</li>
			<li class="active">
				<%=TopicCon.getTopic(topicId).getName()%>
			</li>
		</ul>
	</div>
</div>
<div class="row">
	<div class="span12">
		<h1><%= TopicCon.getTopic(topicId).getName() %></h1>
	</div>
	<div class="span12">
		<dl>
			<dt>Beskrivelse:</dt>
			<dd><em>
			<%= TopicCon.getTopic(topicId).getDescription() %>
			</em></dd>
		</dl>
	</div>
</div>
<div class="row">
	<div id="table" class="span12">
		<h3>Mentorer</h3>
		<br />
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Mentor</th>
					<th>Lokasjon</th>
					<th>Vurdering</th>
				</tr>
			</thead>
			<tbody>
			<% for (int i = 0; i < mentors.size(); i++) { 
				if (session.getAttribute("id") != null) {	%>
			
				<tr>
					<td><a href="?page=viewprofile&profileId=<%=mentors.get(i).getUserId()%>"><%=mentors.get(i).getFirstName()%> <%=mentors.get(i).getLastName()%></a></td>
					<td><%=mentors.get(i).getLocation()%></td>
					<td>Rating</td>
				</tr>

			<% } else { %>
					<tr>
					<td><a href="?page=error"><%=mentors.get(i).getFirstName()%> <%=mentors.get(i).getLastName()%></a></td>
					<td><%=mentors.get(i).getLocation()%></td>
					<td>Rating</td>
				</tr>
				<% } } %>
			</tbody>
		</table>
	</div>


<% if (request.getParameter("email") != null || session.getAttribute("email") != null) { %>

	<div class="span2">
	<form action="AddAsMentorServlet" method="post">
		<button class="btn btn-small" type="submit">Legg meg til som mentor</button>
		<input type="hidden" name="topicId" value="<%=currentTopic.getId() %>"/>
		<input type="hidden" name="userId" value="<%=request.getSession().getAttribute("id") %>"/>
		</form>
	</div>
	
	<div class="span2">
	<form action="AddAsTraineeServlet" method="post">
		<button class="btn btn-small" type="submit">Legg meg til som elev</button>
		<input type="hidden" name="topicId" value="<%=currentTopic.getId() %>"/>
		<input type="hidden" name="userId" value="<%=request.getSession().getAttribute("id") %>"/>
		</form>
	</div>
	<%} %>

</div>
