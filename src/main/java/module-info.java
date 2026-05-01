module com.example.cosmoform {
    requires javafx.controls;
    requires javafx.fxml;
<<<<<<< HEAD
    requires java.sql;
=======
    requires javafx.graphics;
>>>>>>> origin/main


    opens com.example.cosmoform to javafx.fxml;
    exports com.example.cosmoform;
}