package board.service;

import board.dao.BoardDAO;
import board.dao.CommentDAO;
import board.vo.Board;
import board.vo.Comment;

import java.util.ArrayList;

public class CommentService {
    public ArrayList<Comment> load(int boardId){

        CommentDAO dao = null;
        ArrayList<Comment> commentList = new ArrayList<Comment>();
        try {

            dao = new CommentDAO();
            commentList = dao.select(boardId);

        } catch (Exception e) {
            System.out.println(e);
        }

        return commentList;
    }

    public int comment(Comment comment){
        CommentDAO dao = null;
        int result = 0;
        try {

            dao = new CommentDAO();
            result = dao.insert(comment);

        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }
}
