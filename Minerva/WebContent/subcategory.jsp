<%@ page import="Connection.*"%>
<%@ page import="tables.*"%>
<%@ page import="java.util.List"%>

<%
String categoryId = request.getParameter("categoryId");
String subcategoryId = request.getParameter("subcategoryId");
List<SubCategory> subCategories = CategoryCon.getSubCategories();
List<Topic> topics = TopicCon.getTopics(Long.parseLong(subcategoryId));


//	UNDERKATEGORI FINNES
if (Integer.parseInt(subcategoryId) <= subCategories.size()) { %>
<div class="row">
	<div id="breadcrumb" class="span6">
		<ul class="breadcrumb">
			<li>
				<a href="?page=categories">Emner</a>
				<span class="divider">/</span>
			</li>
			<li>
				<a href="?page=categories&categoryId=<%= CategoryCon.getSubCategory(Long.parseLong(subcategoryId)).getMainCategory().getId() %>">
					<%= CategoryCon.getSubCategory(Long.parseLong(subcategoryId)).getMainCategory().getName() %></a>
				<span class="divider">/</span>
			</li>
			<li class="active">
				<%= CategoryCon.getSubCategory(Long.parseLong(subcategoryId)).getName() %>
			</li>
		</ul>
	</div>
</div>
<%
	//	INGEN TRÅDER
	if (topics.isEmpty()) { %>
<div class="row">
	<div class="span12">
		<h1>
			<%= subCategories.get(Integer.parseInt(subcategoryId) - 1).getName() %>
		</h1>
		<br />
		<p class="text-info">
			Ingen tr&aring;der opprettet.
			<% if (request.getParameter("email") != null || session.getAttribute("email") != null) { %>
			<br />
			<a href="?page=addtopic&subcategoryId=<%=subcategoryId%>">Opprett en ny tr&aring;d&nbsp;&#187;</a>
			<% } %>
		</p>
	</div>
</div>
<%	}
	//	FINNES TRÅDER
	else { %>
<div class="row">
	<div id="table" class="span12">
		<h1>
			<%= subCategories.get(Integer.parseInt(subcategoryId) - 1).getName() %>
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
						<%= topics.get(i).getName() %></a>
					</td>
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
</div>
<%	if (request.getParameter("email") != null || session.getAttribute("email") != null) { %>
	<div class="row"><div class="span4">
		<div class="well">
			<p>
				Kan du ikke finne tr&aring;den du leter etter?
			</p>
			<button class="btn btn-small" type="button"
				onclick="window.location='?page=addtopic&subcategoryId=<%=subcategoryId%>'">
				Legg til ny tr&aring;d
			</button>
		</div>
	</div></div>
	<% }
	}
}


//	UNDERKATEGORI FINNES IKKE
else { %>
<div class="row">
	<div class="span12">
		<p class="text-error">
			Underkategorien du pr&oslash;ver &aring; finne, eksisterer ikke.<br />
			<a href="?page=categories">&#171;&nbsp;G&aring; tilbake til emner</a>
		</p>
	</div>
</div>
<% } %>