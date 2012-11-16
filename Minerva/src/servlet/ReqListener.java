package servlet;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ReqListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent s) {
	}

	@Override
	public void requestInitialized(ServletRequestEvent s) {
		try {
		s.getServletRequest().setCharacterEncoding("UTF-8");
		} catch (Exception e) { System.out.println("uh oh servlet request listener done goofed");}
	}

}
