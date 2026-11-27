module com.example.examen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.rmi;
    opens com.example.examen.Controler to javafx.fxml;
    opens com.example.examen to javafx.fxml;
    exports com.example.examen;
}