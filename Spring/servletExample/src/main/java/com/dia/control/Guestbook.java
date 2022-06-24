package com.dia.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dia.helper.CommonUtil;


@WebServlet("/Guestbook")
public class Guestbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Guestbook() {
        super();
    }

    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String cmd = CommonUtil.nullToValue(req.getParameter("cmd"),"list");
		if(cmd.equals("info")) {
			getInfo(req,res);
		} else if (cmd.equals("list")) {
			getList(req,res);
		}
		
	}

	void getInfo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//각 페이지에서 요청을 받으면 그 페이지가 바뀌면 받았던 요청은 전달이 안되는데
		//RequestDispatcher를 이용하면 요청이 다른 페이지로 이전된다.
		//원하는 jsp페이지를 매개변수로 전달하면 그 페이지로 이동
		//request 객체에 부가적인 정보를 저장하려면 setAttribute 함수를 사용
		//키와 값 형태로 정보 저장이 가능
		req.setAttribute("username", "Name");
		req.setAttribute("userage", 25);
		req.setAttribute("userphone", "010-0000-0000");
		//parameter는 무조건 form 태그로만 가능 (프로그램으로 추가할 방법 X)
		
		RequestDispatcher rd = req.getRequestDispatcher("/guest.jsp");
		rd.forward(req, res);//jsp호출
		
	}
	
	void getList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<String> list = new ArrayList<String>();
		//List-추상클래스
		//ArrayList - 구현클래
		list.add("작약");
		list.add("모란");
		list.add("수국");
		list.add("국화");
		
		req.setAttribute("flowerList", list);
		RequestDispatcher rd = req.getRequestDispatcher("/list.jsp");
		rd.forward(req, res);//jsp호출
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
