package com.example.cosmoform;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HelloController {


    @FXML
    private Pane homePage;

    @FXML
    private Pane consentPage;

    @FXML
    private Label welcomeText;



    @FXML
    private Button checkIn;

    @FXML
    private Button checkOut;



    public void nextPage() {
       welcomeText.setVisible(false);

    }


}

