module lecture0718.exam01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens lecture0718.exam01 to javafx.fxml;
    exports lecture0718.exam01;
    exports lecture0718.exam02;
}