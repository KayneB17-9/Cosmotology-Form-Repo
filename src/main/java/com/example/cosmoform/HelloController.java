package com.example.cosmoform;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class HelloController {






    //   PAGES
    @FXML
    private Pane consentPage;

    @FXML
    private VBox homePage;

    @FXML
    private VBox waxingWaiver;

    @FXML
    private VBox feedbackPage;


    @FXML
    public void goToConsent() {
        // Hide home page
        homePage.setVisible(false);
        homePage.setManaged(false);

        // Show consent page
        consentPage.setVisible(true);
        consentPage.setManaged(true);
    }

    @FXML
    public void goToServices(){
        consentPage.setVisible(false);
        consentPage.setManaged(false);

        waxingWaiver.setVisible(true);
        waxingWaiver.setManaged(true);
    }

    @FXML
    public void goToFeedback(){
        homePage.setVisible(false);
        homePage.setManaged(false);

        feedbackPage.setVisible(true);
        feedbackPage.setVisible(true);
    }

    @FXML
    public void goHome() {
        // Hide consent page
        consentPage.setVisible(false);
        consentPage.setManaged(false);

        // Show home page
        homePage.setVisible(true);
        homePage.setManaged(true);
    }


    // ================= OPTIONAL INITIAL SETUP =================

    @FXML
    public void initialize() {
        // Ensure correct starting state
        consentPage.setVisible(false);
        consentPage.setManaged(false);

        homePage.setVisible(true);
        homePage.setManaged(true);
    }
}

