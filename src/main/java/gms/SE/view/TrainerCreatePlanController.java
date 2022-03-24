package gms.SE.view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import gms.SE.App;
import gms.SE.controller.gym;
import gms.SE.controller.plan;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TrainerCreatePlanController implements Initializable {

	@FXML
	private Text t;

	@FXML
	private TextField idTextField;

	@FXML
	private TextField t1;

	@FXML
	private TextArea t2;

	@FXML
	private ComboBox<String> c;

	private Stage stage;

	gms.SE.controller.gym gym = new gym();
	@Override
	public void initialize(URL u, ResourceBundle r) {

		c.getItems().clear();
		ArrayList<String> list = gym.getScheduleList();
		ObservableList<String> s = FXCollections.observableArrayList(list);
		c.setValue(list.get(0));
		c.setItems(s);
	}

	public void PlanCreate(ActionEvent e) {

		if ((t1.getText().equals("")) || (t2.getText().equals("")))
			t.setText("Invalid!");


		else {
			plan p = new plan();
			p.setID(idTextField.getText());
			p.setPlanName(t1.getText());
			p.setDescription(t2.getText());
			p.setSchedule(c.getValue());

			boolean status = gym.createPlan(p);
			if(status)
				t.setText("Plan entered Successfully");
			else
				t.setText("Some error Occurred!");

		}

	}

	public void BackPressed(ActionEvent e) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("trainer_login.fxml"));
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}




}
