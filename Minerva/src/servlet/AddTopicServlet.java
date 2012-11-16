package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tables.Topic;

import Connection.TopicCon;

/**
 * Servlet implementation class AddTopicServlet
 */
@WebServlet("/AddTopicServlet")
public class AddTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTopicServlet() {
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
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String subcategoryId = request.getParameter("subcategoryId");
		TopicCon.createTopic(name, description, Long.parseLong(subcategoryId));
		List<Topic> topics = TopicCon.getTopics(Long.parseLong(subcategoryId));
		Topic topic = null;
		for (int i=0; i<topics.size(); i++)
			if (name.equals(topics.get(i).getName()))
				topic = topics.get(i);
		if (topic == null) {
			response.sendRedirect("?page=subcategory&subcategoryId=" + Long.parseLong(subcategoryId));
			return;
		}
		response.sendRedirect("?page=topic&topicId=" + topic.getId());
	}

}
