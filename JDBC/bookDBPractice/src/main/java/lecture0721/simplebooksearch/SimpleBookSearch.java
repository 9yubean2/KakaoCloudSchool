package lecture0721.simplebooksearch;

import lecture0721.simplebooksearch.dao.*;
import lecture0721.simplebooksearch.vo.*;

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
import lecture0721.simplebooksearch.service.BookService;

import java.util.ArrayList;


//View
public class SimpleBookSearch extends Application {
    TextArea textarea;
    TextField textfield;
    Button btnSearch, btnDelete;



    @Override
    public void start(Stage primaryStage) throws Exception {

        //service 객체
        BookService service = new BookService();

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

            ArrayList<BookVO> rlist = service.bookSearchByKeyword(keyword);

            if(rlist.size()>0){

                for(int i=0; i<rlist.size() ; i++){

                    BookVO vo = rlist.get(i);
                    textarea.appendText(vo.getBtitle()+" : "+vo.getBauthor()+" : "+ vo.getBisbn() + "\n");
                }
            }else{
                textarea.appendText("NO DATA");
            }
        });


        textfield = new TextField();
        textfield.setPrefSize(400, 40);


        btnDelete = new Button("ISBN 삭제");
        btnDelete.setPrefSize(150, 40);


        btnDelete.setOnAction(e->{
            String delete_isbn = textfield.getText();

            textarea.appendText(service.bookDeleteByISBN(delete_isbn)+"\n");
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
        primaryStage.setTitle("도서 검색 Layered Architecture ");

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
