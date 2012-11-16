<%@ page import="Connection.*"%>
<%@ page import="tables.*"%>
<%@ page import="java.util.List"%>

<%	
	int profileId = Integer.parseInt(request.getParameter("profileId"));
	Long sessionId = (Long) request.getSession().getAttribute("id");
	Profile profile = null;
	
	if (sessionId == profileId) 
		profile = ProfileCon.getProfile(sessionId);
	else
		profile = ProfileCon.getProfile(profileId);
	
	
	String image = profile.getImage();
	List<Topic> topicsPersonIsMentorIn = TopicCon.getTopicsMentorIn(profileId);
	List<Topic> topicsPersonIsTraineeIn = TopicCon.getTopicsTraineeIn(profileId);
	List<Feedback> personsFeedback = FeedbackCon.getUsersFeedback(profileId);
	
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
				<img src="<%=image%>" />
				<% } else { %>
				<img src="img/imagenull.png" />
				<% } %>
				
			</div>

			<div id="brukernavn" class="well span4">
				<h1><%=profile.getFirstName() %> <%=profile.getLastName() %></h1>
			</div>
			
			<% if (sessionId == profileId) { %>
			
			<div id="editProfile_button" class="well span2 pull-right">
				<a href="?page=editprofile" class="btn btn-primary">Endre profil</a>
			</div>
			
			<% } else { %>
			
			<div id="sendMessage_button" class="well span2 pull-right">
				<a href="#myModal" class="btn btn-success" data-toggle="modal"><i
					class="icon-envelope icon-white"></i>&nbsp;Send melding</a>
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
						<input type="hidden" name="recieverId" value="<%=profile.getUser().getId()%>"/>
						<button type="submit" class="btn btn-success">Send</button>
						<button type="reset" class="btn">Fjern alt</button>
					</form>

				</div>

				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">Lukk</button>

				</div>
			</div>
			
			<% } %>
			
			
			<br>
			<div class="row-fluid">
				<div class="well span12">
					<b>Alder:</b> <%=profile.getAge() %> <br>
					<strong>Sted:</strong> <%=profile.getLocation() %><br>
					<strong>Interesser:</strong> <%=profile.getInterests() %><br>
					<strong>Kj&oslash;nn:</strong> <%=profile.getSex() %><br>

				</div>
				<div class="span12">
					<strong>Biografi:</strong> <%=profile.getInformation() %><br>
				</div>
			</div>

			<div class="row-fluid">
				<table class="table table-bordered table-striped">

					<thead>
						<tr>
							<th>Mentor i:</th>
							<th>Elev i:</th>

						</tr>
					</thead>
					<tbody>
					
					<% for (int i=0; i<tableSize; i++) { %>
						<tr>
						<% if (topicsPersonIsMentorIn.size() > i) {  %>
						
							<td>
								<a href="?page=subcategory&subcategoryId=<%=TopicCon.getTopic(topicsPersonIsMentorIn.get(i).getId()).getSubCategory().getId()%>">
									<%= TopicCon.getTopic(topicsPersonIsMentorIn.get(i).getId()).getSubCategory().getName() %></a>
								&#187;
								<a href="?page=topic&topicId=<%=topicsPersonIsMentorIn.get(i).getId()%>">
									<%= topicsPersonIsMentorIn.get(i).getName() %></a>
							</td>
							
						<% } else { %>
							<td></td>
						<% } if (topicsPersonIsTraineeIn.size() > i) { %>		
							
							<td>
								<a href="?page=subcategory&subcategoryId=<%=TopicCon.getTopic(topicsPersonIsTraineeIn.get(i).getId()).getSubCategory().getId()%>">
									<%= TopicCon.getTopic(topicsPersonIsTraineeIn.get(i).getId()).getSubCategory().getName() %>
								</a>
								&#187;
								<a href="?page=topic&topicId=<%=topicsPersonIsTraineeIn.get(i).getId()%>">
									<%= topicsPersonIsTraineeIn.get(i).getName() %>
								</a>
							</td>
							
						<% } else { %>
							<td></td>
						<% } %>
						</tr>
					<% } %>
						
					</tbody>
				</table>
			</div>
		</div>
		<% for (int j = 0; j<personsFeedback.size(); j++) { %>
		<div class="well">
			<p class="lead"><%=personsFeedback.get(j).getHeader() %></p>
			<%=personsFeedback.get(j).getFeedback() %><br><br>
			<i>Skrevet av <%=ProfileCon.getProfile(personsFeedback.get(j).getSenderId()).getFirstName()%> 
			<%=ProfileCon.getProfile(personsFeedback.get(j).getSenderId()).getLastName()%></i>
		</div>
		<% } %>
		<% if (sessionId != profileId) { %>
		<div class="well">
		<h3>Legg til kommentar</h3>
				<form action="addfeedback" method="post">
					Overskrift: <input type="text" name="header"><br>
					<textarea class="field span8" name="info" id="textarea" rows="6"
					placeholder="Skriv din kommentar her..."></textarea>
					<input type="hidden" name="senderId" value="<%=sessionId%>"/>
					<input type="hidden" name="recieverId" value="<%=profileId%>"/>
					<br><button type="submit" class="btn btn-success">Legg til kommentar</button>
				</form>
		</div>
		<% } %>
	</div>
