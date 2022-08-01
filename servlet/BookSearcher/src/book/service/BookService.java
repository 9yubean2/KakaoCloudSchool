package book.service;

import book.dao.BookDAO;
import book.vo.Book;

import java.util.ArrayList;

public class BookService {
    public ArrayList<Book> searchByKeyword(String keyword)  {

        ArrayList<Book> result = null;

        try {
            BookDAO dao = new BookDAO();
            result = dao.select(keyword);

        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }

    public int deleteByIsbn(String isbn)  {

        int state = 0;

        try {
            BookDAO dao = new BookDAO();
            state = dao.delete(isbn);

        } catch (Exception e) {
            System.out.println(e);
        }
        return state;
    }
    public ArrayList<Book> searchByKeyword(Book book){

        //DB 처리를 위한 DAO 객체 필요
        BookDAO dao = null;
        ArrayList<Book> result = null;

        try {

            dao = new BookDAO();
            result = dao.select(book.getBtitle());

        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }

}
