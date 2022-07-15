package lecture220715;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//notepad를 만들어 보아요
//JavaFX를 이용할거에요!!

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MyNotepad extends Application{

	TextArea textarea;
	Button openBtn,saveBtn;
	File file;
	
	private void printMsg(String msg) {
		Platform.runLater(()->{
			textarea.appendText(msg+"\n");
		});
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane(); //5layout이 이미 잡혀있음

		root.setPrefSize(700, 500); // borderpane의 가로세로 길이로 창크기 조절
		
		textarea = new TextArea();
		root.setCenter(textarea);
		
		openBtn = new Button("파일 열기");
		openBtn.setPrefSize(150,40);
		openBtn.setOnAction(e ->{
			textarea.clear();
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("오픈할 파일을 선택해 주세요!");
			file = fileChooser.showOpenDialog(primaryStage);
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line ="";
				while((line = br.readLine())!=null) {
					printMsg(line);
				}
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		saveBtn = new Button("파일 저장");
		saveBtn.setPrefSize(150,40);
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10,10,10,10));
		flowPane.setColumnHalignment(HPos.CENTER);
		flowPane.setPrefSize(700,40);
		flowPane.setHgap(10);
		
		flowPane.getChildren().add(openBtn);
		flowPane.getChildren().add(saveBtn);
		
		root.setBottom(flowPane);
		
		//Scene 객체를 생성
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch();//내부적으로 thread 생성하고 start method 호출
	}

}
