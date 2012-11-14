package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.ProfileCon;

import mail.GoogleMail;

/**
 * Servlet implementation class MailServlet
 */
@WebServlet("/MailServlet")
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String signature, to, from, subject, message, password, sender;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		from ="no.reply.minerva";
		sender = (String)request.getSession().getAttribute("email");
		to = ProfileCon.getEmail(Long.parseLong(request.getParameter("recieverId")));
		signature = "This is a mail sent from us by the user " + sender;
		password = "minerva1234";
		subject = request.getParameter("subject");
		message = request.getParameter("message");
		GoogleMail.Send(from, password, to, subject, message);
		response.sendRedirect("?page=viewprofile&profileId=" + request.getParameter("recieverId"));
	}

}
