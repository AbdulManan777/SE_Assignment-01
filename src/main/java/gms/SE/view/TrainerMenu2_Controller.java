package gms.SE.view;

import gms.SE.App;
import gms.SE.controller.gym;
import gms.SE.controller.trainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class TrainerMenu2_Controller {


    private Stage stage;


    public void createPlan(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("trainer_create_plan.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }




    public void BackPressed(ActionEvent e) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("trainer_login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    public void createSchedule(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Trainer_Schedule.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();


    }

    public void quitJob(ActionEvent event) throws IOException {

        Node node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        trainer user = (trainer) stage.getUserData();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to quit your Job? After that you will no longer remain a trainer in this Gym", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {

            gym g = new gym();
            g.quitJob(user);

            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("trainer_login.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        }



    }




}
