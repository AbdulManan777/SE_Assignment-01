package gms.sda_ap.view;

import gms.sda_ap.gym;
import gms.sda_ap.member;
import gms.sda_ap.plan;
import javafx.beans.property.SimpleStringProperty;
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
import java.lang.reflect.Member;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class memberSelectPlanController implements Initializable {

    @FXML
    private TableView<plan> planTable;

    @FXML
    private TableColumn<plan, String> idCol;

    @FXML
    private TableColumn<plan, String> planNameCol;

    @FXML
    private TableColumn<plan, String> descriptionCol;

    @FXML
    private TextField planID;

    @FXML
    private Text warning;

    static int i = 1;
    private Stage stage;


    gym gym = new gym();

    @Override
    public void initialize(URL u, ResourceBundle r) {

        idCol.setCellValueFactory(new PropertyValueFactory<plan, String>("ID"));
        planNameCol.setCellValueFactory(new PropertyValueFactory<plan, String>("planName"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<plan, String>("description"));

        List<ArrayList<String>> list = gym.getPlanList();

        ObservableList<plan> data = FXCollections.observableArrayList();
        int iteration = 0;
        while (iteration < list.size()) {
            data.add(new plan(list.get(iteration).get(0), list.get(iteration).get(1), list.get(iteration).get(2)));
            iteration++;
        }
        planTable.setItems(data);


    }

    public void BackPressed1(ActionEvent e) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(gms.sda_ap.App.class.getResource("member_menu_2.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void SubmitPlan(ActionEvent e) throws IOException {
        Node node = (Node) e.getSource();
        stage = (Stage) node.getScene().getWindow();
        member user = (member) stage.getUserData();

        plan p = new plan();
        p.setID(planID.getText());
        boolean status = gym.setMemberPlan(p, user);
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
        }


    }

}
