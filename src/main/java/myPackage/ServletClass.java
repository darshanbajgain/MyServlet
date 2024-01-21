package myPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class ServletClass
 */
@SuppressWarnings("serial")
@WebServlet("/ServletClass")
public class ServletClass extends HttpServlet {
	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
        // Read form data using getParameter()
		String username = request.getParameter("userName");
		
		Cookie c = new Cookie("name", username); //creating cookie object
		
		response.addCookie(c); // add cookie to response       
		
		// Cookie[] getCookie(); - return all the cookies
		
		out.println("<html> <head> <title> Form </title> </head>");
		out.println("<body><h1>Username: "+ username + "<br> ");
		out.println("<form action='Servlet2' method='POST'>");
	    out.println("<button type='submit'>Submit to Servlet2</button>");
	    out.println("</form>");
		out.println("</body> </html>");
		out.close();
		
	}

}
