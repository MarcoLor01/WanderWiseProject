module com.example.wanderwisep {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;
    requires java.desktop;
    requires com.opencsv;


    opens com.example.wanderwisep to javafx.fxml;
    exports com.example.wanderwisep;
    exports com.example.wanderwisep.graphic_controller;
    opens com.example.wanderwisep.graphic_controller to javafx.fxml;
}