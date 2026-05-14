package com.example.cosmoform;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.w3c.dom.Text;

public class HelloController {
    private JdbcDao jdbcDao = new JdbcDao();


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
    private VBox servicesPage;


    @FXML
    private TextField clientSignature;

    @FXML
    private TextField date;

    @FXML
    private TextField clientName;

    @FXML
    private Label validation;

    @FXML
    private TextField feedbackInput;

    @FXML
    public void submitFeedback() {
        String name = clientName.getText();
        String feedback = feedbackInput.getText();

        if (name.isEmpty() || feedback.isEmpty()) {
            validation.setText("Please fill out feedback form.");
            return;
        }

        try {
            jdbcDao.feedback(name, feedback);
            validation.setText("Feedback submitted!");
        } catch (Exception e) {
            validation.setText("Error saving feedback.");
            e.printStackTrace();
        }
    }


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
        String name = clientName.getText();
        String signature = clientSignature.getText();
        String dateValue = date.getText();



        if(name.isEmpty() || signature.isEmpty() || dateValue.isEmpty()){
            validation.setText("Please enter all necessary information.");
            return;
        }

        try {
            jdbcDao.clientRecord(name, dateValue);
        } catch (Exception e) {
            validation.setText("Database error occurred.");
            e.printStackTrace();
            return;
        }


        consentPage.setVisible(false);
        consentPage.setManaged(false);

        servicesPage.setVisible(true);
        servicesPage.setManaged(true);

    }

    @FXML
    public void goToFeedback(){
        homePage.setVisible(false);
        homePage.setManaged(false);

        feedbackPage.setVisible(true);
        feedbackPage.setManaged(true);
    }

    @FXML
    private void goToWaxing(){
        servicesPage.setVisible(false);
        servicesPage.setManaged(false);

        waxingWaiver.setVisible(true);
        waxingWaiver.setManaged(true);
    }


    @FXML
    public void goHome() {
        // Hide consent page
        //and show it
        consentPage.setVisible(false);
        consentPage.setManaged(false);

        servicesPage.setVisible(false);
        servicesPage.setManaged(false);

        waxingWaiver.setVisible(false);
        waxingWaiver.setManaged(false);

        feedbackPage.setVisible(false);
        feedbackPage.setManaged(false);

        // Show home page
        homePage.setVisible(true);
        homePage.setManaged(true);
    }




    @FXML
    public void initialize() {
        // Ensure correct starting state
        homePage.setVisible(true);
        homePage.setManaged(true);

        consentPage.setVisible(false);
        consentPage.setManaged(false);

        servicesPage.setVisible(false);
        servicesPage.setManaged(false);

        waxingWaiver.setVisible(false);
        waxingWaiver.setManaged(false);

        feedbackPage.setVisible(false);
        feedbackPage.setManaged(false);
    }
}
