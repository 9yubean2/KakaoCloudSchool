package com.dia.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:9090/servletExample/Hello
/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello") //tomcat v6,7~부터 지
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();//부모 생성
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //GET방식으로 전달될 때 doGet호출
    //request = 클라이언트(브라우저)의 요청을 받아오는 객체(WAS가 생성)
    //response = 서버쪽에서 클라이언트(브라우저)에 응답을 보낼때 사용하는 객체
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//utf-8 변환시 필요1
		response.setCharacterEncoding("utf-8");//utf-8 변환시 필요2
		System.out.println("doGet 콘솔");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<meta charset='utf-8'>");//utf-8 변환시 필요3
		out.print("<body>");
		out.print("<h1>Hello</h1>");
		out.print("<h1>안녕하세요</h1>");
		out.print("</body>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    //POST방식으로 전달될 때 doPost호출
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost 콘솔");
		doGet(request, response);//doGet을 호출해서 특별한 사항이 아니면 GET으로 오던 POST로 오던 처리하겠다.
	}

}
