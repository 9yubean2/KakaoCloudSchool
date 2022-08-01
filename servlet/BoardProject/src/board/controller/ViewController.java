package board.controller;

import board.service.BoardService;
import board.service.CommentService;
import board.vo.Board;
import board.vo.Comment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ViewController", value = "/view")
public class ViewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");

        //입력
        int boardId = Integer.parseInt(request.getParameter("boardId"));
        int hits = Integer.parseInt(request.getParameter("hits"));
        //로직
        //서비스 객체
        BoardService service = new BoardService();
        Board board = new Board();
        board.setBoardId(boardId);
        board.setHits(hits);

        board = service.view(board);
        board = service.view(service.hit(board));

        CommentService commentService = new CommentService();
        Comment comment = new Comment();
        comment.setBoardId(boardId);

        ArrayList<Comment> commentList = commentService.load(boardId);

        //출력
        RequestDispatcher rd = request.getRequestDispatcher("/board/boardView.jsp");
        request.setAttribute("boardView",board);
        request.setAttribute("commentList",commentList);

        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
