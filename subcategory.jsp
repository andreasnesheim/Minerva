<%@ page import="Connection.*"%>
<%@ page import="tables.*"%>
<%@ page import="java.util.List"%>

<%
List<SubCategory> subCategories = CategoryCon.getSubCategories();
List<Topic> topics = TopicCon.getTopics(Integer.parseInt(request.getParameter("subcategoryId")));

%>

<div id="mainpage" class="row">
	<div id="breadcrumb" class="span5">
		<ul class="breadcrumb">
			<li><a href="?page=categories">Emner</a> <span class="divider">/</span></li>
			<li><a href="?page=categories"><%=CategoryCon.getSubCategory(Integer.parseInt(request.getParameter("subcategoryId"))).getMainCategory().getName() %></a> <span class="divider">/</span></li>
			<li class="active"><%=CategoryCon.getSubCategory(Integer.parseInt(request.getParameter("subcategoryId"))).getName() %></li>
		</ul>
	</div>

	<div id="table" class="span12">
		<h1>
			<%= subCategories.get(Integer.parseInt(request.getParameter("subcategoryId")) - 1).getName() %>
		</h1>
		<br />
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Tr&aring;d</th>
					<th>Antall mentorer</th>
					<th>Antall elever</th>
				</tr>
			</thead>
			<tbody>
			<% for (int i = 0; i < topics.size(); i++) { %>
			<tr>
				<td><a href="?page=topic&topicId=<%=topics.get(i).getId()%>">
					<%= topics.get(i).getName() %></a></td>
				<td>
					<%= TopicCon.getNumberOfMentorInTopic(topics.get(i).getId()) %>
				</td>
				<td>
					<%= TopicCon.getNumberOfTraineesInTopic(topics.get(i).getId()) %>
				</td>
			</tr>
			<%} %>
			</tbody>
		</table>
	</div>
	
	<div class="span4">
		<div class="well">
			<p>Kan du ikke finne tr&aring;den du leter etter?</p>
			<a href="?page=addtopic&subcategoryId=<%=request.getParameter("subcategoryId")%>">
			<button class="btn btn-small" type="button">Legg til ny tr&aring;d</button></a>
		</div>
	</div>
</div>