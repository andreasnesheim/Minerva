<%@ page import="Connection.*"%>
<%@ page import="tables.*"%>
<%@ page import="java.util.List"%>

<%
List<MainCategory> maincat = CategoryCon.getMainCategories();
List<SubCategory> subcat = CategoryCon.getSubCategories();
%>
<h1>Emner</h1>
<br />
<br />
<div class="row">
	<div class="accordion span3" id="accordion1">

		<% for (int i = 0; i < maincat.size(); i++) { %>
		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#accordion1" href="#<%=maincat.get(i).getName()%>"> <%=maincat.get(i).getName() %>
				</a>
			</div>
		
			<div id="<%= maincat.get(i).getName() %>" class="accordion-body collapse">
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