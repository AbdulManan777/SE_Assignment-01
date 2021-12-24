package gms.sda_ap.view;

import gms.sda_ap.gym;
import gms.sda_ap.member;
import gms.sda_ap.trainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TrainerLoginController {

	public PasswordField t2;
	public TextField t1;
	public Text t;

	private Stage stage;

	gym gym = new gym();

	@FXML

	void BackPressed(ActionEvent e) throws Exception{

		FXMLLoader fxmlLoader = new FXMLLoader(gms.sda_ap.App.class.getResource("trainerMenu.fxml"));
		Parent root=fxmlLoader.load();
		Scene scene=new Scene(root);
		stage=(Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}

	public void LoginPressed(ActionEvent e) throws Exception {

		if (t1.getText().equals("") || t2.getText().equals("")) {

			t.setText("Error in Login");

		} else {

			trainer tr = new trainer();
			tr.setUsername(t1.getText());
			tr.setPassword(t2.getText());

			boolean verification = gym.authenticateTrainer(tr);

			if(!verification){
				t.setText("Incorrect Username or Password!");
			}
			else{
				FXMLLoader fxmlLoader = new FXMLLoader(gms.sda_ap.App.class.getResource("trainer_create_plan.fxml"));
				Parent root = fxmlLoader.load();
				Scene scene = new Scene(root);
				stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
				stage.setScene(scene);
				stage.show();
			}

		}

	}



}
