package gms.SE.view;

import java.io.IOException;

import gms.SE.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class index {

	private Stage stage;

	public void MemberPanel(ActionEvent e) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("member_menu_1.fxml"));
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root);
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}



	public void trainerPanel(ActionEvent e) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("TrainerMenu.fxml"));
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

}
