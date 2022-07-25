package lecture0722.step5;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ConnectionMaker connectionMaker = new NUserDAO();
        UserDAO ndao = new UserDAO(connectionMaker);

        User user = new User();
        user.setId("1");
        user.setName("홍길동");
        user.setPassword("test1234");

        ndao.insert(user);

        User result = ndao.select("1");

        System.out.println(result.getName() +" : "+result.getPassword());

    }
}
