package gms.SE.view;

import gms.SE.App;
import gms.SE.controller.gym;
import gms.SE.exceptions.*;
import gms.SE.controller.trainer;
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

    gms.SE.controller.gym gym = new gym();

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


            } else if (Integer.valueOf(ageTextField.getText()) <= 25 ||Integer.valueOf(ageTextField.getText())>40) {
                throw new age("Error");
            }

            else if(usernameTextField.getText().length()<6 || usernameTextField.getText().length()>15){
                throw  new usernameException("Username must be atleast 6 characters or max 15 characters");
            }

            else if(passwordTextField.getText().length()<7||passwordTextField.getText().length()>20){
                throw new passwordException("Error");
            }



            else if(cnicTextField.getText().length()!=8){
                throw new cnicException("Error");
            }

            else {
                trainer t = new trainer();
                t.setUsername(usernameTextField.getText());
                t.setPassword(passwordTextField.getText());
                t.setName(nameTextField.getText());
                t.setID(cnicTextField.getText());
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
            warning.setText("Age should be in the range 25-40");
        } catch (passwordException e) {
            warning.setText("password should be in the range 7 to 20 characters");
        }  catch (usernameException e) {
            warning.setText("username should be in the range 6 to 15 characters");
        } catch (cnicException e) {
            warning.setText("cnic must be 8 characters");
        }
    }

}
