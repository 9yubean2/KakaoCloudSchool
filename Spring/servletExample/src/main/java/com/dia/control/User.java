package com.dia.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		
		String userId = req.getParameter("userid");
		String userName = req.getParameter("username");
		
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<meta charset='utf-8'>");
		out.print("<body>");
		out.print("<h1>ID: "+userId+"</h1>");
		out.print("<h1>Name: "+userName+"</h1>");
		out.print("</body>");
		out.print("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
