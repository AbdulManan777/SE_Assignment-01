package gms.sda_ap.view;

import gms.sda_ap.App;
import gms.sda_ap.controller.gym;
import gms.sda_ap.exceptions.age;
import gms.sda_ap.exceptions.incomplete_entry;
import gms.sda_ap.controller.trainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TrainerRegisterFormController implements Initializable {

    private Stage stage;

    @FXML
    private Text warning;

    @FXML
    private TextField cnicTextField;

    @FXML
    private TextField ageTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField numberTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private ComboBox<String> specialityComboBox;

    @FXML
    private TextField usernameTextField;

    gms.sda_ap.controller.gym gym = new gym();

    @Override
    public void initialize(URL u, ResourceBundle r) {

        specialityComboBox.getItems().clear();
        ArrayList<String> list = gym.getSpecialityList();
        ObservableList<String> s = FXCollections.observableArrayList(list);
        specialityComboBox.setItems(s);
    }

    @FXML
    void BackPressed1(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("TrainerMenu.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void SubmitTrainer(ActionEvent event) throws IOException, incomplete_entry, age {
        try {
            if (usernameTextField.getText().equals("") || passwordTextField.getText().equals("")
                    || cnicTextField.getText().equals("") || nameTextField.getText().equals("")
                    || specialityComboBox.getValue().equals("") || numberTextField.getText().equals("")
                    || ageTextField.getText().equals("")) {
                throw new incomplete_entry("Error");


            } else if (Integer.valueOf(ageTextField.getText()) <= 25) {
                throw new age("Error");
            } else {
                trainer t = new trainer();
                t.setUsername(usernameTextField.getText());
                t.setPassword(passwordTextField.getText());
                t.setName(nameTextField.getText());
                t.setCnic(cnicTextField.getText());
                t.setSpeciality(specialityComboBox.getValue());
                t.setNumber(numberTextField.getText());
                t.setAge(ageTextField.getText());

                boolean status = gym.registerTrainer(t);

                if (!status) {
                    warning.setText("Some Error Occurred! Try Again");
                } else {
                    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("trainer_login.fxml"));
                    Parent root = fxmlLoader.load();
                    Scene scene = new Scene(root);
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                }
            }
        } catch (incomplete_entry e1) {
            warning.setText("Credentials Incomplete!");
        } catch (age e2) {
            warning.setText("Age less than 25");
        }
    }

}
