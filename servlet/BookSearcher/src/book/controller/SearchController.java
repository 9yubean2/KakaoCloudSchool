package book.controller;

import book.service.BookService;
import book.vo.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SearchController", value = "/bSearch")
public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.입력
        request.setCharacterEncoding("UTF-8");
        String keyword = "%"+request.getParameter("keyword")+"%";
        ServletContext context = getServletContext();
        //ServletContext에 특정 정보를 저장
        context.setAttribute("keyword", keyword);
        //2.로직
        //서비스객체
        BookService service = new BookService();

        ArrayList<Book> bookList = service.searchByKeyword(keyword);

        //3.출력
        if (bookList != null){

            RequestDispatcher rd = request.getRequestDispatcher("/book/searchList.jsp");
            request.setAttribute("bookList",bookList);

            rd.forward(request, response);

        }else{
            response.sendRedirect("/bookSearch/book/noData.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.입력
        request.setCharacterEncoding("UTF-8");
        String keyword = "%"+request.getParameter("keyword")+"%";

        //2.로직
        Book book = new Book();

        book.setBtitle(keyword);
        //System.out.println(book.getBtitle());

        //서비스객체
        ArrayList<Book> bookList = null;

        BookService service = new BookService();
        bookList = service.searchByKeyword(book);
        //3.출력
        if (bookList.size()>0){
            //로그인에 성공하면 JSP를 이용해서 출력해야해요
            //member VO 객체를 JSP에 전달해야 해요
            //즉 controller servlet이 request를 전달해서 다른 Servlet(JSP)을 호출
            RequestDispatcher rd = request.getRequestDispatcher("/book/searchList.jsp");
            request.setAttribute("bookList",bookList);

            rd.forward(request, response);

        }else{
            System.out.println(bookList);
            response.sendRedirect("/bookSearch/book/noData.html");
        }
    }
}
