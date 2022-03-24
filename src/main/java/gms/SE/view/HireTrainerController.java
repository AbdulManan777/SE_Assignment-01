package gms.SE.view;

import gms.SE.App;
import gms.SE.controller.gym;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HireTrainerController implements Initializable {

    @FXML
    private TableColumn<trainer, String> idCol;

    @FXML
    private TableColumn<trainer, String> spec;

    @FXML
    private TableColumn<trainer, String> tName;

    @FXML
    private TextField tid;

    @FXML
    private Text warning;

    @FXML
    private TableView<trainer> trainerTable;
    private Stage stage;

    gms.SE.controller.gym gym = new gym();

    @Override
    public void initialize(URL u, ResourceBundle r) {

        idCol.setCellValueFactory(new PropertyValueFactory<trainer, String>("ID"));
        tName.setCellValueFactory(new PropertyValueFactory<trainer, String>("name"));
        spec.setCellValueFactory(new PropertyValueFactory<trainer, String>("speciality"));

        List<ArrayList<String>> list = gym.getTrainerList();

        ObservableList<trainer> data = FXCollections.observableArrayList();
        int iteration = 0;
        int temp = 1;
        while (iteration < list.size()) {
            data.add(new trainer(String.valueOf(temp), list.get(iteration).get(0), list.get(iteration).get(1)));
            iteration++;
        }
        trainerTable.setItems(data);


    }

    public void BackPressed1(ActionEvent e) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("member_menu_2.fxml"));
        Parent root=fxmlLoader.load();
        Scene scene=new Scene(root);
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void SubmitTrainer(ActionEvent e){

        /*
        Node node = (Node) e.getSource();
        stage = (Stage) node.getScene().getWindow();
        member user = (member) stage.getUserData();

        trainer t = new trainer();
        t.setID(tid.getText());
        boolean status = gym.setMemberTrainer(t, user);
        if(status)
        {
            FXMLLoader fxmlLoader = new FXMLLoader(gms.sda_ap.App.class.getResource("member_menu_2.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setUserData(user);
            stage.setScene(scene);
            stage.show();
        }
        else{
            warning.setText("Some Error Occurred!");
        }*/

    }
}
