<%@ page import="Connection.*"%>
<%@ page import="tables.*"%>
<%@ page import="java.util.List"%>

<%
	List<Profile> mentors = TopicCon.getListOfMentorsInTopic(Long.parseLong(request.getParameter("topicId")));
	Topic currentTopic = TopicCon.getTopic(Long.parseLong(request.getParameter("topicId")));
%>

<div id="mainpage" class="row">
	<div id=breadcrumb class="span5">
		<ul class="breadcrumb">
			<li><a href="?page=categories">Emner</a> <span class="divider">/</span></li>
			<li><a href="?page=categories"><%=TopicCon.getTopic(Long.parseLong(request.getParameter("topicId"))).getSubCategory().getMainCategory().getName()%></a> <span class="divider">/</span></li>
			<li><a href="?page=subcategory&subcategoryId=<%=TopicCon.getTopic(Long.parseLong(request.getParameter("topicId"))).getSubCategory().getId() %>">
			<%=TopicCon.getTopic(Long.parseLong(request.getParameter("topicId"))).getSubCategory().getName()%></a> <span class="divider">/</span></li>
			<li class="active"><%=TopicCon.getTopic(Long.parseLong(request.getParameter("topicId"))).getName()%></li>
		</ul>
	</div>

	<div id="table" class="span12">
		<h1>Mentorer i valgt tråd</h1>
		<br>
		<table class="table table-hover">
			<tr>
				<th>Mentor</th>
				<th>Lokasjon</th>	
			</tr>
			<% for (int i=0; i<mentors.size(); i++) { %>
			<tr>
				<td><a href="?page=viewprofile&profileId=<%=mentors.get(i).getUserId()%>"><%=mentors.get(i).getFirstName()%> <%=mentors.get(i).getLastName()%></a></td>
				<td><%=mentors.get(i).getLocation()%></td>
				<td>Rating</td>
			</tr>
			<% } %>
		</table>
	</div>

	<div class="span2">
	<form action="AddAsMentorServlet" method="post">
		<button class="btn btn-small" type="submit">Legg meg til som mentor</button>
		<input type="hidden" name="topicId" value="<%=currentTopic.getId() %>"/>
		<input type="hidden" name="userId" value="<%=request.getSession().getAttribute("id") %>"/>
		</form>
	</div>
	<div class="span2">
	<form action="AddAsTraineeServlet" method="post">
		<button class="btn btn-small" type="submit">Legg meg til som trainee</button>
		<input type="hidden" name="topicId" value="<%=currentTopic.getId() %>"/>
		<input type="hidden" name="userId" value="<%=request.getSession().getAttribute("id") %>"/>
		</form>
	</div>
</div>
