package gms.sda_ap.view;

import gms.sda_ap.App;
import gms.sda_ap.controller.gym;
import gms.sda_ap.controller.member;
import gms.sda_ap.controller.schedule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ScheduleController implements Initializable {

    @FXML
    private TableView<schedule> scheduleTable;

    @FXML
    private TableColumn<schedule, String> idCol;

    @FXML
    private TableColumn<schedule, String> schTime;

    @FXML
    private TextField scID;

    @FXML
    private Text warning;

    private Stage stage;


    gym gym = new gym();

    @Override
    public void initialize(URL u, ResourceBundle r) {

        idCol.setCellValueFactory(new PropertyValueFactory<schedule, String>("ID"));
        schTime.setCellValueFactory(new PropertyValueFactory<schedule, String>("schedule"));

        ArrayList<String> list = gym.getScheduleList();

        ObservableList<schedule> data = FXCollections.observableArrayList();
        int iteration = 0;
        int temp = 1;
        while (iteration < list.size()) {
            data.add(new schedule(String.valueOf(temp), list.get(iteration)));
            iteration++;
            temp++;
        }
        scheduleTable.setItems(data);


    }

    public void BackPressed1(ActionEvent e) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("member_menu_2.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void SubmitSchedule(ActionEvent e) throws IOException {
        Node node = (Node) e.getSource();
        stage = (Stage) node.getScene().getWindow();
        member user = (member) stage.getUserData();

        schedule s = new schedule();
        s.setID(scID.getText());
        boolean status = gym.setMemberSchedule(s, user);
        if(status)
        {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("member_menu_2.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setUserData(user);
            stage.setScene(scene);
            stage.show();
        }
        else{
            warning.setText("Some Error Occurred!");
        }


    }

}
