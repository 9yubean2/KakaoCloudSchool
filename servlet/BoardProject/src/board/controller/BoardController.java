package board.controller;

import board.service.BoardService;
import board.vo.Board;
import member.service.MemberService;
import member.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BoardController", value = "/board")
public class BoardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        ArrayList<Board> boardList = (ArrayList<Board>) request.getAttribute("boardList");
//
//        HttpSession session = request.getSession();

        request.setCharacterEncoding("UTF-8");

        ArrayList<Board> boardList = new ArrayList<Board>();

        //서비스객체
        BoardService service = new BoardService();

        try {

            boardList = service.load();

        } catch (Exception e) {
            System.out.println(e);
        }

        //출력
        if (boardList!=null){


            RequestDispatcher rd = request.getRequestDispatcher("/board/boardList.jsp");

            request.setAttribute("boardList",boardList);

            rd.forward(request, response);

        }else{
            response.sendRedirect("/board/login/loginFail.html");
        }
    }
}
