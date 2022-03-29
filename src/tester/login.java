package tester;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		main checking = new main();
		try {
			if(checking.check(uname, password))
			{
				HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				response.sendRedirect("first.jsp");
			}
			else {
				response.sendRedirect("login_page.jsp");
				out.println("Incorrect Username/Password");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
