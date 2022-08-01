package member.controller;

import member.service.MemberService;
import member.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignupController", value = "/signup")
public class SignupController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        if ((id == null) ||(password == null)||(name == null)){
            response.sendRedirect("/board/login/signup.html");
        }

        //로직
        Member member = new Member();
        member.setMemberId(id);
        member.setMemberPw(password);
        member.setMemberName(name);

        //서비스객체
        MemberService service = new MemberService();

        int result = 0;

        try {

            result = service.signup(member);

        } catch (Exception e) {

            System.out.println(e);

        }

        //출력
        if (result == 1){

            response.sendRedirect("/board/login/login.html");

        }else{

            response.sendRedirect("/board/login/loginFail.html");

        }
    }
}
