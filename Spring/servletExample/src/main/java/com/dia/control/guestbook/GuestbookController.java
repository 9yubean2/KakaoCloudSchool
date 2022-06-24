package com.dia.control.guestbook;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dia.helper.CommonUtil;


@WebServlet("/gbc")
public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GuestbookDAO dao = new GuestbookDAO();
    public GuestbookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String cmd = CommonUtil.nullToValue(request.getParameter("cmd"),"list");
		if(cmd.equals("list"))
			doList(request, response);
		else if(cmd.equals("view"))
			doView(request, response);
		else if(cmd.equals("write"))
			doWrite(request, response);
		else if(cmd.equals("save"))
			doSave(request, response);
	}
	
	void doList (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setAttribute("datalist", dao.getList());
		RequestDispatcher rd = request.getRequestDispatcher("/guestbook/guest_list.jsp");
		rd.forward(request,response);
	}
	
	void doView (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		System.out.println(id);
		request.setAttribute("data", dao.getView(Integer.parseInt(id)-1));
		RequestDispatcher rd = request.getRequestDispatcher("/guestbook/guest_view.jsp");
		rd.forward(request,response);
	}
	void doWrite (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/guestbook/guest_write.jsp");
		rd.forward(request,response);
	}
	
	void doSave (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GuestbookDTO dto = new GuestbookDTO();
		dto.setTitle(request.getParameter("title"));
		dto.setWriter(request.getParameter("writer"));
		dto.setContents(request.getParameter("contents"));
		dto.setWdate("2022-06-24");
		dto.setHit(0);
		
		
		dao.insert(dto);
		
		response.sendRedirect(request.getContextPath()+"/gbc?cmd=list");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
