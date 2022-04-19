package gms.SE.view;

import gms.SE.App;
import gms.SE.controller.gym;
import gms.SE.controller.member;
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
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class HireTrainerPayment implements Initializable {

    @FXML
    private TextField fee;

    @FXML
    private TextField tid;

    @FXML
    private ComboBox t;

    private Stage stage;

    @FXML
            private Text hire;


    gms.SE.controller.gym gym = new gym();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<String> list = new ArrayList<String>();

        list.add("5:30-6:00 PM");
        list.add("4:00-4:30 PM");
        list.add("1:00-1:30 PM");
        ObservableList obList = FXCollections.observableList(list);
        t.setValue("5:30-6:00 PM");
        t.getItems().clear();
        t.setItems(obList);
        fee.setText("500");


    }

    public void feeConfirm(ActionEvent event) {

        Node node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        member user = (member) stage.getUserData();

        trainer t = new trainer();
        t.setID(tid.getText());
        boolean status = gym.setMemberTrainer(t, user);
        if (status) {
            hire.setText("Your trainer is hired successfully");


        }

        else{
            hire.setText("Some Error occured");
        }



    }

    public void BackPressed1(ActionEvent e) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("HireTrainer.fxml"));
        Parent root=fxmlLoader.load();
        Scene scene=new Scene(root);
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }








}
