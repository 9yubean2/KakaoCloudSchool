module lecture220718.exam01.networkexample {
    requires javafx.controls;
    requires javafx.fxml;


    opens lecture220718.exam01.networkexample to javafx.fxml;
    exports lecture220718.exam01.networkexample;
}