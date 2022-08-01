package board.service;

import board.dao.BoardDAO;
import board.vo.Board;

import java.util.ArrayList;

public class BoardService {
    public ArrayList<Board> load(){


        //로그인이 되는지 확인하는 로직(DB 처리)
        //DB 처리를 위한 DAO 객체 필요
        BoardDAO dao = null;
        ArrayList<Board> boardList = new ArrayList<Board>();
        try {

            dao = new BoardDAO();
            boardList = dao.select();

        } catch (Exception e) {
            System.out.println(e);
        }

        return boardList;
    }

    public int write(Board board){

        BoardDAO dao = null;
        int result = 0;
        try {

            dao = new BoardDAO();
            result = dao.insert(board);

        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }


    public Board view(Board board){

        BoardDAO dao = null;

        try {

            dao = new BoardDAO();
            board = dao.search(board);

        } catch (Exception e) {
            System.out.println(e);
        }

        return board;
    }


    public Board hit(Board board){

        BoardDAO dao = null;

        try {

            dao = new BoardDAO();
            board = dao.update(board);

        } catch (Exception e) {
            System.out.println(e);
        }

        return board;
    }
}
