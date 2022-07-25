module lecture220721.bookdbpractice {

    requires javafx.controls;
    requires javafx.fxml;
    requires commons.dbcp2;
    requires org.apache.commons.pool2;
    requires java.management;
    requires commons.logging;
    requires java.sql;

    opens lecture220721.bookdbpractice to javafx.fxml;
    opens lecture0721.simplebooksearch to javafx.fxml;
    opens refactoring to javafx.fxml;
    exports lecture220721.bookdbpractice;
    exports lecture0721.simplebooksearch;
    exports refactoring;
    exports refactoring.connector;
    opens refactoring.connector to javafx.fxml;
}