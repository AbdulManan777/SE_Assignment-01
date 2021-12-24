package gms.sda_ap.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HireTrainerController {


    private Stage stage;

    public void BackPressed1(ActionEvent e) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(gms.sda_ap.App.class.getResource("member_menu_2.fxml"));
        Parent root=fxmlLoader.load();
        Scene scene=new Scene(root);
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void SubmitTrainer(ActionEvent e){

        //Successfully Submitted Plan
    }
}
