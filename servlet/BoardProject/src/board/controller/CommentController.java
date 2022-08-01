package board.controller;

import board.service.BoardService;
import board.service.CommentService;
import board.vo.Board;
import board.vo.Comment;
import member.vo.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CommentController", value = "/comment")
public class CommentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String comments = request.getParameter("comment");

        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("member");
        String memberId = member.getMemberId();
        String boardId = request.getParameter("boardId");

        Comment comment = new Comment();
        comment.setCommentContents(comments);
        comment.setBoardId(Integer.parseInt(boardId));
        comment.setMemberId(memberId);
        //System.out.println(boardId+" : "+memberId+" : "+comments);

        CommentService service = new CommentService();
        int result = service.comment(comment);

        ArrayList<Comment> commentArrayList = service.load(Integer.parseInt(boardId));


        BoardService bservice = new BoardService();
        Board board = new Board();
        board.setBoardId(Integer.parseInt(boardId));

        board = bservice.view(board);
        //출력
        RequestDispatcher rd = request.getRequestDispatcher("/board/boardView.jsp");

        request.setAttribute("boardView",board);
        request.setAttribute("commentList",commentArrayList);

        rd.forward(request, response);


    }
}
