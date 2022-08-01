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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1. 입력받고
        String id = request.getParameter("userID");
        String pw = request.getParameter("userPW");

        //2.로직처리
        Member member = new Member();
        member.setId(id);
        member.setPw(pw);
        //로직 처리하기 위해서 service 객체가 필요
        MemberService service = new MemberService();
        member = service.login(member);

        //3.출력
        //로그인에 성공하면 vo 객체 안에 로그인한 사람의 이름이 들어가 있어요
        if (member!=null){
            //로그인에 성공하면 JSP를 이용해서 출력해야해요
            //member VO 객체를 JSP에 전달해야 해요
            //즉 controller servlet이 request를 전달해서 다른 Servlet(JSP)을 호출
            RequestDispatcher rd = request.getRequestDispatcher("/member/loginSuccess.jsp");
            request.setAttribute("member",member);

            rd.forward(request, response);

        }else{
            response.sendRedirect("/book/member/loginFail.html");
        }

    }
}
