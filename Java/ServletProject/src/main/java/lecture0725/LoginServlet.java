package lecture0725;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        //1. JDBC Driver Loading
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1. 입력받고
		//한 가지 주의해야 할 점은 입력을 받을 때 사용되는 stream의 encoding이 ISO-8859-1
		//그래서 한글 데이터 처리를 위해 encoding 설정 해줘야함
		//만약 GET 방식인 경우 Tomcat의 입력 스트림의 encoding을 변경
		String email = req.getParameter("userEmail");
		String pw = req.getParameter("userPassword");
		//2. 로직처리
		//입력된 email과 password가 database table에 존재하는지 확인
		Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        boolean loginStatus = false;
        
        //2. DBMS와 연결(실제로 데이터베이스 연결)
        String jdbcURL = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
        String userName = "root";
        String password = "mi59659398@";
        try {
			conn = DriverManager.getConnection(jdbcURL, userName, password);
			//3. Statement 생성
	        //prepared statement는 in parameter 사용 가능
	        String sql = "SELECT * FROM tmpuser WHERE email = ? and password = ?";

	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1,email);
	        pstmt.setString(2,pw);
	        
	        rs = pstmt.executeQuery();
	        
	        if(rs.next()) {
	        	loginStatus = true;
	        }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        //6. 사용한 자원 해제
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//3. 출력
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = new PrintWriter(res.getOutputStream());
		if(loginStatus) {
			out.println("HELLO"+email);
		} else {
			out.println("Fail to Login");
		}

		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
	}

}
