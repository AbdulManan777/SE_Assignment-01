package gms.SE.view;

import java.io.IOException;

import gms.SE.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*import javafx.fxml.FXML;
import javafx.scene.control.TextField;*/

public class memberMenu1Controller {
	
	
				
	private Stage stage;

	public void LoginPressed(ActionEvent e) throws IOException {
		
		
		  FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("member_login.fxml"));
		   Parent root=fxmlLoader.load();
			Scene scene=new Scene(root);
			stage=(Stage)((Node)e.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		
	}

	
	
	public void RegisterPressed(ActionEvent e) throws IOException {
		
		
		  FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("member_register_form.fxml"));
		   Parent root=fxmlLoader.load();
			Scene scene=new Scene(root);
			stage=(Stage)((Node)e.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		
	}
	
	public void BackPressed(ActionEvent e) throws IOException {
		
		
		  FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("index.fxml"));
		   Parent root=fxmlLoader.load();
			Scene scene=new Scene(root);
			stage=(Stage)((Node)e.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		
	}
}
