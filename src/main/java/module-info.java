module com.example.cosmoform {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.cosmoform to javafx.fxml;
    exports com.example.cosmoform;
}