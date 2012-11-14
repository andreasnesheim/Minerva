<%@ page import="Connection.*"%>
<%@ page import="tables.*"%>
<%@ page import="java.util.List"%>

<%
	List<Profile> mentors = TopicCon.getListOfMentorsInTopic(Long.parseLong(request.getParameter("topicId")));
%>

<div id="mainpage" class="row">
	<div id=breadcrumb class="span5">
		<ul class="breadcrumb">
			<li><a href="?page=categories">Emner</a> <span class="divider">/</span></li>
			<li><a href="?page=categories"><%=TopicCon.getTopic(Long.parseLong(request.getParameter("topicId"))).getSubCategory().getMainCategory().getName()%></a> <span class="divider">/</span></li>
			<li><a href="?page=categories&subcategoryId=<%=TopicCon.getTopic(Long.parseLong(request.getParameter("topicId"))).getSubCategory().getName() %>">
			<%=TopicCon.getTopic(Long.parseLong(request.getParameter("topicId"))).getSubCategory().getName()%></a> <span class="divider">/</span></li>
			<li class="active"><%=TopicCon.getTopic(Long.parseLong(request.getParameter("topicId"))).getName()%></li>
		</ul>
	</div>



	<div id="table" class="span12">

		<h1>Mentorer i valgt tråd</h1>
		
		<% 
		
		%>

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
		<button class="btn btn-small" type="button">Legg meg til som mentor</button>
	</div>
	<div class="span2">
		<button class="btn btn-small" type="button">Legg meg til som trainee</button>
	</div>

</div>

