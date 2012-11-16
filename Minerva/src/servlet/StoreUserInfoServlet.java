package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.ProfileCon;

/**
 * Servlet implementation class StoreUserInfoServlet
 */
@WebServlet("/StoreUserInfoServlet")
public class StoreUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String firstname, lastname, location, interests, sex, age, information, deleteImage;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreUserInfoServlet() {
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

		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		age = request.getParameter("age");
		location = request.getParameter("location");
		interests = request.getParameter("interests");
		sex = request.getParameter("sex");
		information = request.getParameter("information");
		deleteImage = request.getParameter("deleteImage");
		
		
		
		ProfileCon.changeProfile((long) request.getSession().getAttribute("id"), firstname, lastname, location, information,
				interests, sex, age, deleteImage);
		
		response.sendRedirect("?page=viewprofile&profileId=" + request.getSession().getAttribute("id"));
		
	}

}
