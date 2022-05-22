package gms.SE.view;

import gms.SE.App;
import gms.SE.controller.customer;
import gms.SE.controller.gym;
import gms.SE.exceptions.*;
import gms.SE.model.DBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class memberRegisterFormController {

	private Stage stage;

	@FXML
	private Text warning;

	@FXML
	private TextField usernameTextField;

	@FXML
	private TextField passwordTextField;

	@FXML
	private TextField cnicTextField;

	@FXML
	private TextField genderTextField;

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField numberTextField;

	gym gym = new gym();

	public void BackPressed(ActionEvent e) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("member_menu_1.fxml"));
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void memberRegisterSubmit(ActionEvent event) throws  IOException, incomplete_entry {
		try {
			DBHandler d = new DBHandler();
			boolean st = d.userName(usernameTextField.getText());
			if (st) {
				if (usernameTextField.getText().equals("") || passwordTextField.getText().equals("")
						|| cnicTextField.getText().equals("") || nameTextField.getText().equals("")
						|| genderTextField.getText().equals("") || numberTextField.getText().equals("")) {
					throw new incomplete_entry("Error");

				} else if (usernameTextField.getText().length() < 6 || usernameTextField.getText().length() > 15) {
					throw new usernameException("Username must be atleast 6 characters or max 15 characters");
				} else if (passwordTextField.getText().length() < 7 || passwordTextField.getText().length() > 20) {
					throw new passwordException("Error");
				} else if (!(genderTextField.getText().equals("Male")) && !(genderTextField.getText().equals("Female"))) {
					throw new genderException("Error");
				} else if (cnicTextField.getText().length() != 8) {
					throw new cnicException("Error");
				} else {
					customer c1 = new customer();
					c1.setUsername(usernameTextField.getText());
					c1.setPassword(passwordTextField.getText());
					c1.setName(nameTextField.getText());
					c1.setCnic(cnicTextField.getText());
					c1.setGender(genderTextField.getText());
					c1.setNumber(numberTextField.getText());
					//c1.setStatus("active");


					boolean status = gym.registerMember(c1);

					if (!status) {
						warning.setText("Some Error Occurred! Try Again");
					} else {
						FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("member_login.fxml"));
						Parent root = fxmlLoader.load();
						Scene scene = new Scene(root);
						stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						stage.setScene(scene);
						stage.show();
					}
				}
			}
			else{
				warning.setText("That username is already taken");
			}
		}
		catch(incomplete_entry e1){

				warning.setText("Credentials Incomplete!");

			} catch(SQLException e){
				e.printStackTrace();
			}
		catch(usernameException e){
				warning.setText("Username must be atleast 6 characters or max 15 characters");
			} catch(passwordException e){
				warning.setText("Password must be atleast 7 characters long or max 20 characters");
			} catch(genderException e){
				warning.setText("Please write appropriate gender as Male or Female");
			} catch(cnicException e){
				warning.setText("Cnic must be 8 characters");
			}


	}

}