package lecture0718.exam02;

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Exam02_EchoClient extends Application {
    TextArea textarea;
    Button btnConn;
    TextField textfield, idfield;

    Socket socket;
    BufferedReader br;
    PrintWriter pr;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //화면 구성
        BorderPane root = new BorderPane();
        root.setPrefSize(700,500);

        textarea = new TextArea();
        root.setCenter(textarea);

        btnConn = new Button("Echo Server 접속");
        btnConn.setPrefSize(150,40);
        btnConn.setOnAction(e->{
            textarea.clear();
            //server process에 접속을 시도
            try {

                socket = new Socket("localhost", 6789);
                //connection success!!!

                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                pr = new PrintWriter(socket.getOutputStream());
                textarea.appendText("Connection Success!!"+"\n"); //나중에 문제가 생길 수 있어요

            }catch (Exception e2){

            }
        });

        idfield = new TextField();
        textfield = new TextField();

        idfield.setPrefSize(100,40);
        textfield.setPrefSize(200,40);

        textfield.setOnAction(e->{
            //TODO: 입력상자에 글 입력 후 enter 입력하면 이벤트 처리

            String cmsg = idfield.getText()+" : "+textfield.getText();
            pr.println(cmsg);
            pr.flush();

            if(textfield.getText().equals("/exit")){

                textarea.appendText("--EXIT--"+"\n"); //나중에 문제가 생길 수 있어요
                textfield.setDisable(true);//더이상 입력하지 못하게

            } else {

                String serverMsg = null;

                try {

                    serverMsg = br.readLine();

                } catch (Exception ex) {

                    ex.printStackTrace();

                }

                textarea.appendText(serverMsg+"\n");

            }

            textfield.clear();
        });

        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(10,10,10,10));
        flowPane.setColumnHalignment(HPos.CENTER);
        flowPane.setPrefSize(700,40);
        flowPane.setHgap(10);

        flowPane.getChildren().add(btnConn); //set btn to flow pane
        flowPane.getChildren().add(idfield); //set id field to flow pane
        flowPane.getChildren().add(textfield); //set text field to flow pane

        root.setBottom(flowPane);//set flow pane to border pane

        //create scene object
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
