package book.controller;

import book.service.BookService;
import book.vo.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DeleteConroller", value = "/bDelete")
public class DeleteConroller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1입력
        String isbn = request.getParameter("bisbn");
        //System.out.println(isbn);
        ServletContext context = getServletContext();
        String keyword = (String)context.getAttribute("keyword");
        System.out.println(keyword);

        //2. 로직
        BookService service = new BookService();
        int status = service.deleteByIsbn(isbn);

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
        String isbn = request.getParameter("bisbn");
        System.out.println(isbn);
    }
}
