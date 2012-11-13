<%@ page import="Connection.*"%>
<%@ page import="tables.*"%>
<%@ page import="java.util.List"%>

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
		<h1>
			<%= TopicCon.getTopic(Long.parseLong(request.getParameter("topicId"))).getName() %>
		</h1>
		<br />
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Mentor</th>
					<th>Lokasjon</th>
					<th>Rating</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><a href="?page=viewprofile_daniel">Daniel Jajevski</a></td>
					<td>Stavanger</td>
					<td>4,5/5</td>
				</tr>
				<tr>
					<td><a href="#">Bård Helland Bø</a></td>
					<td>Sola</td>
					<td>4,5/5</td>
				</tr>
				<tr>
					<td><a href="#">Rikard Finnesand</a></td>
					<td>Mosterøy</td>
					<td>4,5/5</td>
				</tr>
				<tr>
					<td><a href="#">Joacim Jacobsen </a></td>
					<td>Tasta</td>
					<td>4,5/5</td>
				</tr>
				<tr>
					<td><a href="#">Rolf Andreas Boiten </a></td>
					<td>Stavanger</td>
					<td>4,5/5</td>
				</tr>
			</tbody>
		</table>
	</div>


	<div class="span2">
		<button class="btn btn-small" type="button">Legg meg til som mentor</button>
	</div>
	<div class="span2">
		<button class="btn btn-small" type="button">Legg meg til som trainee</button>
	</div>

</div>

