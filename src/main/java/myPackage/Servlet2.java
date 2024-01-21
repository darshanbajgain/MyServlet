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
 * Servlet implementation class Servlet2
 */
@SuppressWarnings("serial")
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Read form data using getParameter()
		String username = request.getParameter("userName");
		
		Cookie[] c= request.getCookies(); //add getCookies to request
			
		out.println("<html> <head> <title> Form </title> </head>");
		out.println("<body><h1>Username: "+ c[0].getValue()+ "<br>");
		out.close();
	}

}
