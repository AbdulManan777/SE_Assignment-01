package gms.SE.view;

import gms.SE.App;
import gms.SE.controller.gym;
import gms.SE.controller.member;
import gms.SE.exceptions.incomplete_entry;
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
import java.sql.SQLException;

public class memberLoginController {


    @FXML
    private TextField t1;

    @FXML
    private TextField t2;

    @FXML
    private Text t;

    private Stage stage;

    gms.SE.controller.gym gym = new gym();

    public void LoginPressed(ActionEvent e) throws IOException {


        try {
            if (t1.getText().equals("") || t2.getText().equals("")) {
                throw new incomplete_entry("Error");
            } else {

                member m = new member();
                m.setUsername(t1.getText());
                m.setPassword(t2.getText());

                int verification = gym.authenticateMember(m);

                if(verification==0){
                    t.setText("Invalid User");
                }
                else if(verification==2){
                    t.setText("Do you forgot your password or it is changed");
                }
                else {
                    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("member_menu_2.fxml"));
                    Parent root = fxmlLoader.load();
                    Scene scene = new Scene(root);
                    stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    stage.setUserData(m);
                    stage.setScene(scene);
                    stage.show();
                }


            }
        } catch (incomplete_entry e1) {

            t.setText("Username and password cannot be empty");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void BackPressed(ActionEvent e) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("member_menu_1.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }


}
