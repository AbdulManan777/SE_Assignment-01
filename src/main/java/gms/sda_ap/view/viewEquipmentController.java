package gms.sda_ap.view;

import gms.sda_ap.equipment;
import gms.sda_ap.gym;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class viewEquipmentController implements Initializable {

    private Stage stage;

    @FXML
    private TableColumn<equipment, String> equipmentNameCol;

    @FXML
    private TableView<equipment> equipmentTable;

    @FXML
    private TableColumn<equipment, String> idCol;

    @FXML
    private TableColumn<equipment, String> manuCol;

    gms.sda_ap.gym gym = new gym();
    @Override
    public void initialize(URL u, ResourceBundle r) {

        idCol.setCellValueFactory(new PropertyValueFactory<equipment, String>("id"));
        equipmentNameCol.setCellValueFactory(new PropertyValueFactory<equipment, String>("name"));
        manuCol.setCellValueFactory(new PropertyValueFactory<equipment, String>("manufacture_date"));

        List<ArrayList<String>> list = gym.getEquipmentList();

        ObservableList<equipment> data = FXCollections.observableArrayList();
        int iteration = 0;
        while (iteration < list.size()) {
            data.add(new equipment(list.get(iteration).get(0), list.get(iteration).get(1), list.get(iteration).get(2)));
            iteration++;
        }
        equipmentTable.setItems(data);


    }

    @FXML
    void BackPressed1(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(gms.sda_ap.App.class.getResource("member_menu_2.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
