module lecture0722.step1.lecture0722 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens lecture0722.step1 to javafx.fxml;
    exports lecture0722.step1;
}