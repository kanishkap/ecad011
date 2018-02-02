package FeedbackServlet;
import dao.DBMan;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FeedbackServlet
 */
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String roll,stuname,branch,cat,message;
		roll=request.getParameter("roll");
		stuname=request.getParameter("stuname");
		branch=request.getParameter("branch");
		cat=request.getParameter("cat");
		message=request.getParameter("message");
		String page="";
		
		String sql="insert into feedback(roll,stuname,branch,category,message) values('"+roll+"','"+stuname+"','"+branch+"','"+cat+"','"+message+"')";
		//int i=DBMan.InsertRecord(roll,stuname,branch,cat,message);
		/*String page="feedback.jsp?msg=";
		
		if(i==1)
		{
			page+="insertion successfull";
		}
		else
		{
			page+="insertion failed";
		}
		response.sendRedirect(page);
		//getServletContext().getRequestDispatcher(page).forward(request, response);
		
		
		*/

		int i;
		try {
			i = DBMan.insert(sql);
			if(i!=0)
			{
				page="feedback.jsp?msg=insert successfully";
			}
			else
			{
				page="feedback.jsp?msg=failed";
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}		response.sendRedirect(page);	
		
	}
	
		
	}

