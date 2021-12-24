package gms.sda_ap.view;

import gms.sda_ap.Payment;
import gms.sda_ap.gym;
import gms.sda_ap.incomplete_entry;
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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {


    private  Stage stage;
    @FXML
    private TextField t1;

    @FXML
    private TextField t2;



    @FXML
    private Text t;



    @FXML
    private ComboBox<String> c;

    gym gym = new gym();

    @Override
    public void initialize(URL u, ResourceBundle r) {

        ObservableList<String> s = FXCollections.observableArrayList("MasterCard","Visa Card","Cash");
        c.setItems(s);
        c.setValue("Cash");
    }


    public void PaymentSubmit(ActionEvent e){

        try {
            if (t1.getText().toString().equals("") || t2.getText().toString().equals("") ) {

                throw new incomplete_entry("Error");
            } else {

                String rec=gym.makePayment(Integer.valueOf(t2.getText()),t1.getText());
                t.setText("Payment made Succesfully on "+rec);

                gym.StorePayment(rec);
            }
        }
        catch(incomplete_entry e1) {

            t.setText("Incompletely filled");
        }

    }

   /* public void getPayment(String re){

        String rec=re;

    }*/

    public void BackPressed(ActionEvent e) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(gms.sda_ap.App.class.getResource("member_menu_2.fxml"));
        Parent root=fxmlLoader.load();
        Scene scene=new Scene(root);
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }



}
