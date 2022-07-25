package lecture0722.step2;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //service없이  main에서 로직 처리
        UserDAO ndao = new NUserDAO();

        User user = new User();
        user.setId("2");
        user.setName("김길동");
        user.setPassword("test1234");

        ndao.insert(user);

        User result = ndao.select("2");
        System.out.println(result.getName() +" : "+result.getPassword());
    }
}
