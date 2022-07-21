package lecture220721.bookdbpractice;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class BookSearch extends Application {
    TextArea textarea;
    TextField textfield;
    Button btnSearch, btnDelete;

    private static BasicDataSource basicDS;
    Connection conn = null;
    DataSource ds = getDataSource();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();
        root.setPrefSize(700, 500);

        textarea = new TextArea();
        textarea.setEditable(false);
        root.setCenter(textarea);

        btnSearch = new Button("Keyword 검색");
        btnSearch.setPrefSize(150, 40);
        btnSearch.setOnAction(e->{
            textarea.clear();

            String keyword = "%"+textfield.getText()+"%";

            try {
                conn = ds.getConnection();

                String sql = "SELECT btitle,bauthor,bisbn FROM book WHERE btitle LIKE ?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,keyword);

                rs = pstmt.executeQuery();

                while (rs.next()){
                    String title = rs.getString(1);
                    String author = rs.getString(2);
                    String isbn = rs.getString(3);

                    textarea.appendText(title+" : "+author+" : "+isbn + "\n");
                }

            } catch (Exception e2){
                System.out.println(e2);
            } finally {
                try {
                    //6. 사용한 자원 해제
                    if(rs!=null) rs.close();
                    if(pstmt!=null) pstmt.close();
                    if(conn!=null) conn.close();

                } catch (SQLException e3) {
                    System.out.println(e3);
                }
            }
        });


        textfield = new TextField();
        textfield.setPrefSize(400, 40);


        btnDelete = new Button("ISBN 삭제");
        btnDelete.setPrefSize(150, 40);


        btnDelete.setOnAction(e->{
            String delete_isbn = textfield.getText();

            try {
                conn = ds.getConnection();
                conn.setAutoCommit(false);

                String sql = "DELETE FROM book WHERE bisbn = ?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,delete_isbn);

                int result = pstmt.executeUpdate();
                textarea.appendText("[삭제 성공]"+"\n");

                conn.commit();

            } catch (Exception e2){
                //TODO: handle exception
            } finally {
                try {
                    //6. 사용한 자원 해제
                    if(pstmt!=null) pstmt.close();
                    if(conn!=null) conn.close();

                } catch (SQLException e3) {
                    System.out.println(e3);
                }
            }
        });

        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(10, 10, 10, 10));
        flowPane.setColumnHalignment(HPos.CENTER);
        flowPane.setPrefSize(700, 40);
        flowPane.setHgap(10);
        flowPane.getChildren().add(btnSearch);
        flowPane.getChildren().add(textfield);
        flowPane.getChildren().add(btnDelete);

        root.setBottom(flowPane);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("도서 검색");

        primaryStage.show();
    }

    static  {
        //main method 이전에 불러올 data들
        try {

            basicDS = new BasicDataSource();
            Properties properties = new Properties();

            InputStream is = new FileInputStream("properties/db.properties");
            properties.load(is);

            basicDS.setDriverClassName(properties.getProperty("DRIVER_CLASS"));
            basicDS.setUrl(properties.getProperty("JDBC_URL"));
            basicDS.setUsername(properties.getProperty("DB_USER"));
            basicDS.setPassword(properties.getProperty("DB_PASSWORD"));

            basicDS.setInitialSize(10);
            basicDS.setMaxTotal(10);

        } catch (Exception e){
            //TODO: handle exception
        }
    }

    public static DataSource getDataSource(){
        return basicDS;
    }

    public static void main(String[] args) {
        launch();
    }
}
