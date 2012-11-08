<%@ page import="Connection.CategoryCon"%>
	<%@ page import="tables.MainCategory"%>
	<%@ page import="tables.SubCategory"%>
	<%@ page import="java.util.List"%>



		<%
			List<MainCategory> maincat = CategoryCon.getMainCategories();
			List<SubCategory> subcat = CategoryCon.getSubCategories();
		%>
	
	
	<br>
	<br>
	<div class ="span3"  id="MainMenu" >
		<div class="accordion-group">
			
			<%for (int i=0; i<maincat.size(); i++){%>
			
			<!-- Web Development-->
			
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#MainMenu" href="#<%=maincat.get(i).getName()%>"> <%=maincat.get(i).getName() %>
				</a>
			</div>
				<div id="<%=maincat.get(i).getName() %>" class="accordion-body collapse">
				<div class="accordion-inner">
					
					<%for (int j=0; j<subcat.size(); j++){ %>
						<% if ( subcat.get(j).getMainCategory().getId() == maincat.get(i).getId() ){%>
							<a href=?page=chosen_webdevelopment_subtopic_html> <%=subcat.get(j).getName()%></a><br> 
						<% }%>
				<%	}%>
				</div>
			
			</div>
			<% }%>
		</div>
		
	
	
	