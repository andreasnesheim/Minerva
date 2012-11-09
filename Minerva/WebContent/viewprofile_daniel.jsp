<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Profile - Username here</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<body>
	<div class="container">
		<div id="bilde" class="row-fluid">
			<div class="well span2">
				<img src="img/ProfilBilde.jpg">
			</div>

			<div id="overskrift" class="well span4">

				<h1>Daniel Jajevski</h1>
				<!--    session.setAttribute( "EmpList", Connection.ProfileCon.getProfile(1));-->

			</div>
			<div id="sendMessage_button" class="well span2 pull-right">
				<a href="#myModal" class="btn btn-success" data-toggle="modal"><i
					class="icon-envelope icon-white"></i>Send Message</a>
			</div>
			<div class="modal hide" id="myModal" aria-hidden="true">

				<div class="modal-header">
					<h2>
						Send e-mail to person<small>This mail is private</small>
					</h2>
				</div>
				<div class="modal-body">
					<form>
						<label>Subject</label> <input type="email" class="span8"
							placeholder="Enter Subject here..." /><br> <label>Write
							here</label>
						<textarea class="field span8" id="textarea" rows="6"
							placeholder="Write your message here..."></textarea>
						<br> <br>
						<button type="submit" class="btn btn-success">Send</button>
						<button type="reset" class="btn">Clear</button>
					</form>

				</div>

				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>

				</div>
			</div>


			<br>
			<div class="row-fluid">
				<div class="well span12">
					<b>Age:</b> 22 <br> <strong>Location:</strong> Stavanger,
					Hordaland, Norway<br> <strong>Interests:</strong> Science<br>
					<strong>Sex:</strong> Male<br>

				</div>
				<div class="span12">
					<strong>Bio:</strong> This is me and i like computers and science.
					And i don't like turtles, and people who are mean.<br>
				</div>
			</div>

			<div class="row-fluid">
				<table class="table table-striped">

					<thead>
						<tr>
							<th>Mentor in</th>
							<th>mentoree in</th>

						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Java</td>
							<td>HTML5</td>

						</tr>
						<tr>
							<td></td>
							<td>CSS</td>

						</tr>
						<tr>
							<td></td>
							<td>C#</td>

						</tr>
						<tr>
							<td></td>
							<td>php</td>

						</tr>
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

</body>
</html>