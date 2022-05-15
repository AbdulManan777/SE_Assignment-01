package gms.SE.view;

import gms.SE.App;
import gms.SE.controller.gym;
import gms.SE.controller.member;
import gms.SE.controller.trainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Trainer_Schedule_Controller {



    public Stage stage;

    @FXML
    public TextField t1;

    @FXML
    private TextField t2;

    @FXML
    private TextField t3;

    @FXML
    private Text t;


    @FXML
    public void MID(MouseEvent event){
        Node node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        trainer user = (trainer) stage.getUserData();

        t1.setText(user.getID());
    }

    public void createSchedule(ActionEvent event) throws IOException {

        String s1=t2.getText();
        String s2=t3.getText();

        Node node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        trainer user = (trainer) stage.getUserData();

        gym g=new gym();
        g.setTrainerSchedule(user,s1,s2);
        t.setText("Schedule Created Successfully");

    }

    public void BackPressed(ActionEvent e) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("TrainerMenu2.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


}
