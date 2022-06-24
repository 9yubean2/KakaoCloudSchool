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
 * Servlet implementation class Calc
 */
@WebServlet("/Calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Calc() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		int x = Integer.parseInt(req.getParameter("x"));
//		int y = Integer.parseInt(req.getParameter("y"));
//		int oper = Integer.parseInt(req.getParameter("oper"));
//		
//		int result = 0;
//		
//		if (oper == 1)
//			result = x+y;
//		else if (oper == 2)
//			result = x-y;
//		else if (oper == 3)
//			result = x*y;
//		else
//			result = x/y;
		
		String sX = CommonUtil.nullToValue(req.getParameter("x"));
		String sY = CommonUtil.nullToValue(req.getParameter("y"));
		String oper = CommonUtil.nullToValue(req.getParameter("oper"),"1");
		
		int nX = Integer.parseInt(sX);
		int nY = Integer.parseInt(sY);
		String result = "";
		
		if(oper.equals("1"))
			result = String.format("%d + %d = %d",nX,nY,nX+nY);
		else if (oper.equals("2"))
			result = String.format("%d + %d = %d",nX,nY,nX-nY);
		else if (oper.equals("3"))
			result = String.format("%d + %d = %d",nX,nY,nX*nY);
		else
			result = String.format("%d + %d = %d",nX,nY,nX/nY);
		
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<meta charset='utf-8'>");
		out.print("<body>");
		out.print("<h1>x: "+nX+"</h1>");
		out.print("<h1>y: "+nY+"</h1>");
		out.print("<h1>result: "+result+"</h1>");
		out.print("</body>");
		out.print("</html>");
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
