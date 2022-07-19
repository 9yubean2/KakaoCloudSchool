module com.dia.chat.chatproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dia.chat.chatproject to javafx.fxml;
    exports com.dia.chat.chatproject;
}