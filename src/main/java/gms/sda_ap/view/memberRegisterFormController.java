package gms.sda_ap.view;

import gms.sda_ap.App;
import gms.sda_ap.controller.customer;
import gms.sda_ap.controller.gym;
import gms.sda_ap.exceptions.incomplete_entry;
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
			if (usernameTextField.getText().equals("") || passwordTextField.getText().equals("")
					|| cnicTextField.getText().equals("") || nameTextField.getText().equals("")
					|| genderTextField.getText().equals("") || numberTextField.getText().equals("")) {
				throw new incomplete_entry("Error");

			}


			else{
				customer c1 = new customer();
				c1.setUsername(usernameTextField.getText());
				c1.setPassword(passwordTextField.getText());
				c1.setName(nameTextField.getText());
				c1.setCnic(cnicTextField.getText());
				c1.setGender(genderTextField.getText());
				c1.setNumber(numberTextField.getText());

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
		catch(incomplete_entry e1) {

			warning.setText("Credentials Incomplete!");

		}

	}

}