package servlet;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

import Connection.ProfileCon;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImageServlet() {
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
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		 
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
 
            try {
                List items = upload.parseRequest(request);
                Iterator iterator = items.iterator();
                HttpSession session = request.getSession();
                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();
 
                    if (!item.isFormField()) {
                        String fileName = item.getName();
                        if (fileName.isEmpty()) {
                        	response.sendRedirect("?page=editprofile");
                        }
                     
                        //String workspacePath = "C:/Users/Andy/Desktop/MinervaWorkspace/Minerva/Minerva/WebContent/img";
                        //String pathname = workspacePath;
                        
                        //Denne funker i dette tilfellet, men hvis dette skulle ha ligget på en server hadde det fungert
                        //ved å legge inn en eksplisitt path utenfor prosjektet.
                        String pathname = session.getServletContext().getRealPath("/img");
                        
                        
                        System.out.println(pathname);
                        File path = new File(pathname + "/profile");
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }
 
                        File uploadedFile = new File(path + "/" + fileName);
                        
                        item.write(uploadedFile);
                		
                		String imagePathInProject = "img\\profile\\";
                        
                		ProfileCon.changeProfile ((long) request.getSession().getAttribute("id"), null, null, null, null, null, null, null, imagePathInProject + fileName); 
                        response.sendRedirect("?page=viewprofile&profileId=" + request.getSession().getAttribute("id"));
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        response.sendRedirect("viewprofile.jsp?myprofile=true");
	}

}
