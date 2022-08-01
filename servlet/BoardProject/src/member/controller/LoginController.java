package member.controller;

import member.service.MemberService;
import member.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        //입력
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        System.out.println(id+","+password);
        //로직
        Member member = new Member();
        member.setMemberId(id);
        member.setMemberPw(password);

        //서비스객체
        MemberService service = new MemberService();

        try {
            member = service.login(member);
        } catch (Exception e) {
            System.out.println(e);
        }


        //출력
        if (member!=null){

            RequestDispatcher rd = request.getRequestDispatcher("/board");
            //request.setAttribute("loginUser",member);

            HttpSession session = request.getSession();
            session.setAttribute("member", member);
            session.setAttribute("id", member.getMemberId());

            rd.forward(request, response);

        }else{
            response.sendRedirect("/board/login/loginFail.html");
        }
    }
}
