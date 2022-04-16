package gms.SE.view;

import gms.SE.controller.member;
import gms.SE.model.FileHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UpdateMemberController {


    private  Stage stage;

    @FXML
    private TextField t1;

    @FXML
    private TextField t2;

    @FXML
    private TextField t3;

    @FXML
    private Text t;







    @FXML
    void showDetails(ActionEvent event){

        Node node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        member user = (member) stage.getUserData();

        t1.setText(user.getCnic());

        t2.setText(user.getPassword());

        t3.setText(user.getPhone());

    }


    @FXML
    void resetDetails(ActionEvent event){

        t2.setText("");
        t3.setText("");
    }

    @FXML
    void updateMembership(ActionEvent event){

        Node node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        member user = (member) stage.getUserData();

        user.setPhone(t3.getText());
        user.setPassword(t2.getText());
       // System.out.println((t2.getText()));
        FileHandler f=new FileHandler();
        f.updateMember(user);

        t.setText("Updated Member successfully");


    }
}
