package com.dia.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dia.helper.CommonUtil;

/**
 * Servlet implementation class Gugu
 */
@WebServlet("/Gugu")
public class Gugu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Gugu() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
		int nDan = Integer.parseInt(CommonUtil.nullToValue(req.getParameter("dan"),"1"));
		
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<meta charset='utf-8'>");
		out.print("<body>");
		out.print("<h1>구구단 "+nDan+"단</h1>");
		for(int i =1;i<=9;i++) {
			out.print("<h1> " + nDan + " X " + i + " = " + nDan*i + " </h1>");
		}
		out.print("</body>");
		out.print("</html>");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
