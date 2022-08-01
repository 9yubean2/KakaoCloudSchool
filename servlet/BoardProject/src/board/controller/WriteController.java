package board.controller;

import board.service.BoardService;
import board.vo.Board;
import member.service.MemberService;
import member.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

@WebServlet(name = "WriteController", value = "/write")
public class WriteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Member result = (Member) request.getAttribute("loginUser");
//        String id = result.getMemberId();
        String id = request.getParameter("id");
        System.out.println(id);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");

        String title = request.getParameter("title");
        String contents = request.getParameter("contents");

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);

        Board board = new Board();
        board.setMemberId(id);
        board.setBoardTitle(title);
        board.setBoardDate(strDate);
        board.setBoardContents(contents);

        BoardService service = new BoardService();

        ArrayList<Board> boardList = new ArrayList<Board>();

        int result = 0;
        try {
            result = service.write(board);
            boardList = service.load();
        } catch (Exception e) {
            System.out.println(e);
        }

        //출력
        RequestDispatcher rd = request.getRequestDispatcher("/board/boardList.jsp");
        request.setAttribute("boardList",boardList);

        rd.forward(request, response);


    }
}
