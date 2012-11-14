package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.FeedbackCon;

/**
 * Servlet implementation class AddFeedbackServlet
 */
@WebServlet("/AddFeedbackServlet")
public class AddFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFeedbackServlet() {
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
		String header = (String) request.getParameter("header");
		String info = (String) request.getParameter("info");
		Long recieverId = Long.parseLong(request.getParameter("recieverId"));
		Long senderId = Long.parseLong(request.getParameter("senderId"));
		
//		String header1 ="Kjempeflink!";
//		String info1 = "han var kjempeflink ogs dkfsdfk sdfk ds";
		
		FeedbackCon.createFeedback(header, info, recieverId, senderId);
		response.sendRedirect("?page=viewprofile&profileId=" + recieverId);
	}

}
