package lecture0718.exam01;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

//Client
public class Exam01_DateClient extends Application {

    public static void main(String[] args) {
        launch();
    }

    TextArea textarea;
    Button btnConn;

    @Override
    public void start(Stage primaryStage) throws IOException {
        //화면 구성
        BorderPane root = new BorderPane();
        root.setPrefSize(700,500);

        textarea = new TextArea();
        root.setCenter(textarea);

        btnConn = new Button("Date 서버 접속!!");
        btnConn.setPrefSize(150,40);
        btnConn.setOnAction(e->{
            textarea.clear();
            //server process에 접속을 시도
            try {

                Socket socket = new Socket("localhost",5678);
                //connection success!!!
                //stream 열기
                InputStreamReader isr = new InputStreamReader( socket.getInputStream() );
                BufferedReader br = new BufferedReader(isr);

                String msg = br.readLine(); //blocking method :  읽을게 있을 때 까지 계속 대기

                textarea.appendText(msg+"\n"); //나중에 문제가 생길 수 있어요

                //사용한 자원을 반납 - 안하면 leak 생김
                br.close();
                isr.close();
                socket.close();

                textarea.appendText("서버와의 연결이 종료되었어요.."); //나중에 문제가 생길 수 있어요

            } catch (Exception ex) {
                //TODO: handle Exception
            }
        });

        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(10,10,10,10));
        flowPane.setColumnHalignment(HPos.CENTER);
        flowPane.setPrefSize(700,40);
        flowPane.setHgap(10);
        root.setBottom(flowPane);//set flow pane to border pane

        flowPane.getChildren().add(btnConn); //set btn to flow pane

        //create scene object
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
