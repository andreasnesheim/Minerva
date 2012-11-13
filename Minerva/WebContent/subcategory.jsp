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
			<li><a href="#">Topic</a> <span class="divider">/</span></li>
			<li><a href="#">Web development</a> <span class="divider">/</span></li>
			<li class="active">HTML</li>
		</ul>
	</div>

	<div id="table" class="span12">
		<h1>
			<%= subCategories.get(Integer.parseInt(request.getParameter("subcategoryId")) - 1).getName() %>
		</h1>
		<br />
		<table class="table table-hover">
			<tr>
				<th>Tr&aring;d</th>
				<th>Antall mentorer</th>
				<th>Antall elever</th>
			</tr>
			<% for (int i = 0; i < topics.size(); i++) { %>
			<tr>
				<td><a href="?page=">
					<%= topics.get(i).getName() %></a></td>
				<td>
					<%= TopicCon.getNumberOfMentorInTopic(topics.get(i).getId()) %>
				</td>
				<td>
					<%= TopicCon.getNumberOfTraineesInTopic(topics.get(i).getId()) %>
				</td>
			</tr>
			<%} %>
		</table>
	</div>

	<div class="span4">
		<div class="well">
			<p>Can't find the subject you're looking for?</p>
			<button class="btn btn-small" type="button">Add a topic</button>
		</div>
	</div>
</div>