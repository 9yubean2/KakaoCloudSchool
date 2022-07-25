package refactoring.service;
import refactoring.connector.Connector;
import refactoring.dao.BookDAO;
import refactoring.vo.BookVO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookService {

    public BookDAO dao;
    public BookService(Connector connector) {
        //constructors
        this.dao = new BookDAO(connector);
    }

    public ArrayList<BookVO> bookSearchByKeyword(String keyword) throws SQLException, IOException, ClassNotFoundException {

        ArrayList<BookVO> result = dao.select(keyword);

        return result;
    }

    public String bookDeleteByISBN(String bisbn) throws SQLException, IOException, ClassNotFoundException {

        String result = dao.delete(bisbn);

        return  result;
    }
}
