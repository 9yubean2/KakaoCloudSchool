module com.javafx.mynotepad {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javafx.mynotepad to javafx.fxml;
    exports com.javafx.mynotepad;
}