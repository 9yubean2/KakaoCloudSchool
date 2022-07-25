package lecture0722.step4;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //service없이  main에서 로직 처리
        UserDAO ndao = new UserDAO();

        User user = new User();
        user.setId("1");
        user.setName("홍길동");
        user.setPassword("test1234");

        ndao.insert(user);

        User result = ndao.select("1");
        System.out.println(result.getName() +" : "+result.getPassword());
    }
}
