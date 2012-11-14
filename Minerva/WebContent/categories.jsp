<%@ page import="Connection.*"%>
<%@ page import="tables.*"%>
<%@ page import="java.util.List"%>

<%
List<MainCategory> maincat = CategoryCon.getMainCategories();
List<SubCategory> subcat = CategoryCon.getSubCategories();
String categoryId = request.getParameter("categoryId");
%>

<h1>Emner</h1>
<br />
<div class="row">
	<div class="accordion span3" id="accordion1">

		<% for (int i = 0; i < maincat.size(); i++) { %>
		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#accordion1" href="#<%=maincat.get(i).getName().replace(' ', '_')%>"><%=maincat.get(i).getName() %>
				</a>
			</div>
		
			<%	if (categoryId != null && maincat.get(i).getId() == Long.parseLong(categoryId)) { %>
				<div id="<%= maincat.get(i).getName().replace(' ', '_') %>" class="accordion-body collapse in">
			<%}
				else {
				out.println("<div id=\""+ maincat.get(i).getName().replace(' ', '_') +"\" class=\"accordion-body collapse\">");
			} %>
				<div class="accordion-inner">
			
					<% for (int j = 0; j < subcat.size(); j++) { %>
						<% if (subcat.get(j).getMainCategory().getId() == maincat.get(i).getId()){%>
							&#187;&nbsp;<a href="?page=subcategory&subcategoryId=<%= subcat.get(j).getId() %>"><%=subcat.get(j).getName()%></a><br>
						<%}
					   }%>
				
				</div>
			</div>
		</div>
		<% }%>
	</div>
</div>
