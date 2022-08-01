package lecture0726;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet", value = "/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.입력
        //2.로직
        //3.출력
        //결과를 client에게 돌려주기 위해서는 content type을 설정
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = new PrintWriter(response.getOutputStream());
        //out.println("<html><head><title>Test</title></head><body><h1>Test Servlet!</h1></body></html>");
        out.println("소리없는 아우성");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
