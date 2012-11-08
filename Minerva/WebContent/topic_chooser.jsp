<%@ page import="Connection.CategoryCon"%>
	<%@ page import="tables.MainCategory"%>
	<%@ page import="tables.SubCategory"%>
	<%@ page import="java.util.List"%>



		<%
			List<MainCategory> maincat = CategoryCon.getMainCategories();
			for (int i = 0; i < maincat.size(); i++) {
		%>

		
		<%
			List<SubCategory> subcat = CategoryCon.getSubCategories(i + 1);
				for (int j = 0; j < subcat.size(); j++) {
		%>
		<%
			}
		}
			%>
	
	
	<br>
	<br>
	<div class ="span3"  id="MainMenu" >
		<div class="accordion-group">
			
			<!-- Web Development-->
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#MainMenu" href="#WebDevelopment"> <%maincat.get(0).getName(); %>
				</a>
			</div>
			<div id="WebDevelopment" class="accordion-body collapse">
				<div class="accordion-inner">
					<a href=?page=chosen_webdevelopment_subtopic_html><%maincat.get(1).getName(); %></a> <br> 
					<a href=#>Javascript</a> <br> 
					<a href=#>PHP</a> <br>
				</div>

			</div>
		</div>
	
	
		<!-- Computer programming -->
		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#MainMenu" href="#ComputerProgramming"> Computer
					Programming </a>
			</div>
			<div id="ComputerProgramming" class="accordion-body collapse">
				<div class="accordion-inner">
					<a href=#>Java</a><br> 
					<a href=#>C++</a><br> 
					<a href=#>C#</a><br>
				</div>
			</div>
		</div>
		
		
		
		<!-- Network -->
		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#MainMenu" href="#Network">Network </a>
			</div>
			<div id="Network" class="accordion-body collapse">
				<div class="accordion-inner">
					<a href=#>Network Layer</a><br> 
					<a href=#>Application layer</a><br> 
					<a href=#>Physical Layer</a><br>
				</div>
			</div>
		</div>
		
		<!-- Database Management -->
		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#MainMenu" href="#DatabaseManagement">Database Management </a>
			</div>
			<div id="DatabaseManagement" class="accordion-body collapse">
				<div class="accordion-inner">
					<a href=#>mySQL Basics</a><br> 
					<a href=#>ER-schemes</a><br> 
					<a href=#>How to use DIA to make schemes</a><br>
				</div>
			</div>
		</div>
	</div>
	
	
	
			
		
		
	
	
