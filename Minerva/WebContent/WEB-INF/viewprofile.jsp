<%@ page import="Connection.ProfileCon"%>
<%@ page import="Connection.TopicCon"%>
<%@ page import="tables.Profile"%>
<%@ page import="tables.Topic"%>
<%@ page import="java.util.List"%>

<%	
	Long id = (Long) session.getAttribute("id");
	Profile profile = ProfileCon.getProfile(id);
	String image = profile.getImage();
	
	List<Topic> topicsPersonIsMentorIn = TopicCon.getTopicsMentorIn(1);
	List<Topic> topicsPersonIsTraineeIn = TopicCon.getTopicsTraineeIn(1);
	
	int tableSize = 0;
	int table1 = topicsPersonIsMentorIn.size();
	int table2 = topicsPersonIsTraineeIn.size();
	if (table1 > table2)
		tableSize = table1;
	else if (table1 < table2)
		tableSize = table2;
	else if (table1 == table2)
		tableSize = table1;
		
	
%>
	<div class="container">
		<div id="bilde" class="row-fluid">
			<div class="well span2">
			<% if (image != null) { %>
				<img src="<%=image%>">
				<% } else { %>
				<img src="img/imagenull.png">
				<% } %>
				
			</div>

			<div id="brukernavn" class="well span4">
				<h1><%=profile.getFirstName() %> <%=profile.getLastName() %></h1>
			</div>
			
			<div id="sendMessage_button" class="well span2 pull-right">
				<a href="#myModal" class="btn btn-success" data-toggle="modal"><i
					class="icon-envelope icon-white"></i>Send Message</a>
			</div>
			<div class="modal hide" id="myModal" aria-hidden="true">

				<div class="modal-header">
					<h2>
						Send e-mail til person <small>Denne e-mailen er privat</small>
					</h2>
				</div>
				<div class="modal-body">
					<form action="mail" method="post">
						<label>Emne: </label> <input type="text" class="span8" name="subject"
							placeholder="Emnetittel " /><br> 
							<label>Skriv din melding her</label>
						<textarea class="field span8" id="textarea" rows="6" name="message"
							placeholder="Skriv din melding her..."></textarea>
						<br> <br>
						<button type="submit" class="btn btn-success">Send</button>
						<button type="reset" class="btn">Fjern alt</button>
					</form>

				</div>

				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">Lukk</button>

				</div>
			</div>
			
				<a href="?page=editprofile"><button type="submit" class="btn btn-primary">Endre profil</button></a>
			


			<br>
			<div class="row-fluid">
				<div class="well span12">
					<b>Age:</b> <%=profile.getAge() %> <br>
					<strong>Location:</strong> <%=profile.getLocation() %><br>
					<strong>Interests:</strong> <%=profile.getInterests() %><br>
					<strong>Sex:</strong> <%=profile.getSex() %><br>

				</div>
				<div class="span12">
					<strong>Bio:</strong> <%=profile.getInformation() %><br>
				</div>
			</div>

			<div class="row-fluid">
				<table class="table table-striped">

					<thead>
						<tr>
							<th>Mentor i: </th>
							<th>Trainee i: </th>

						</tr>
					</thead>
					<tbody>
					
					<% for (int i=0; i<tableSize; i++) { %>
						<tr>
					<% if (topicsPersonIsMentorIn.size() > i) {  %>
						
							<td><%= topicsPersonIsMentorIn.get(i).getName() %></td>
							
					<% } else { %>
							<td></td>
					<% } if (topicsPersonIsTraineeIn.size() > i) { %>		
							
							<td><%= topicsPersonIsTraineeIn.get(i).getName() %></td>
							
							<% } %>
						</tr>
					<% } %>
						
					</tbody>
				</table>
			</div>
		</div>
		<div class="well">
			<p class="lead">Good Teacher!</p>
			Took a course in Java beginner with mr. Jajevski and Lorem ipsum
			dolor sit amet Consectetur adipiscing elit Integer molestie lorem at
			massa Facilisis in pretium Faucibus porta lacus fringilla vel Aenean
			sit amet erat nunc Eget porttitor loremnisl aliquet Nulla volutpat
			aliquam velit Lorem ipsum dolor sit amet Consectetur adipiscing elit
			Integer molestie lorem at massa Facilisis in pretium nisl aliquet
			Nulla volutpat aliquam velit <br> <br> <i> By Andreas
				Nesheim 01.01.2012</i>

		</div>
		<div class="well">
			<p class="lead">OK!</p>
			Took a course in Java beginner with mr. Jajevski and it was OK! Also
			i would like to add velit Lorem ipsum dolor sit amet Consectetur
			adipiscing elit Integer molestie lorem at massa Facilisis in pretium
			nisl aliquet Nulla volutpat aliquam velit <br> <br>
			<dfn> By Rikard Finnesand 01.11.2012</dfn>

		</div>
		<div class="well">

			<textarea class="field span8" id="textarea" rows="6"
				placeholder="Add your comment here..."></textarea>
			<button type="submit" class="btn btn-success">Send</button>
		</div>
		<!--  		<footer class="modal-footer">
		<CENTER> Copyright Rikard Finnesand
			25.10.2012  </CENTER>

			</footer> 
		-->
	</div>
