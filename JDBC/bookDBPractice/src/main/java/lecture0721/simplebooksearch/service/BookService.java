package lecture0721.simplebooksearch.service;
import lecture0721.simplebooksearch.dao.*;
import lecture0721.simplebooksearch.vo.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


//Service
//조회, 삭제
//하나의 transaction
public class BookService {

    public BookDAO dao;
    public BookService() {
        //constructors
        this.dao = new BookDAO();
    }

    public ArrayList<BookVO> bookSearchByKeyword(String keyword){

        ArrayList<BookVO> result = dao.select(keyword);

        return result;
    }

    public String bookDeleteByISBN(String bisbn){

        String result = dao.delete(bisbn);

        return  result;
    }
}
