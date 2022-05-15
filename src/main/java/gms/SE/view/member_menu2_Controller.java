package gms.SE.view;

import gms.SE.App;
import gms.SE.controller.gym;
import gms.SE.controller.member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class member_menu2_Controller {

    private Stage stage;

    @FXML
    private Text t;

    private ComboBox<String> c;

    public void BackPressed(ActionEvent e) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("member_menu_1.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void SelectPlan(ActionEvent e) throws IOException {



        Node node = (Node) e.getSource();
        stage = (Stage) node.getScene().getWindow();
        member user = (member) stage.getUserData();

        boolean s=user.paymentverify(user);
        boolean s2=user.statusVerify(user);

        if(s==true && s2==false) {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("member_select_plan.fxml"));

            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setUserData(user);
            stage.setScene(scene);
            stage.show();
        }
        else if(s==false){
            t.setText("Sorry you are a fee defaulter, so cannot access this tool");
        }
        else{

            t.setText("Sorry your membership is paused so all features are locked for you");

        }




    }

    public void makePayment(ActionEvent e) throws IOException {

        Node node = (Node) e.getSource();
        stage = (Stage) node.getScene().getWindow();
        member user = (member) stage.getUserData();



        //boolean s=user.paymentverify(user);
        boolean s2=user.statusVerify(user);
        if(s2==false) {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("member_payment.fxml"));

            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setUserData(user);
            stage.setScene(scene);
            stage.show();
        }

        else{

            t.setText("Sorry your membership is paused so all features are locked for you");

        }

    }


    public void HireTrainer(ActionEvent e) throws IOException {
        Node node = (Node) e.getSource();
        stage = (Stage) node.getScene().getWindow();
        member user = (member) stage.getUserData();

        boolean s=user.paymentverify(user);
        boolean s2=user.statusVerify(user);
        if(s==true && s2==false) {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("HireTrainer.fxml"));

            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setUserData(user);
            stage.setScene(scene);
            stage.show();
        }
        else if(s==false){
            t.setText("Sorry you are a fee defaulter, so cannot access this tool");
        }
        else{

            t.setText("Sorry your membership is paused so all features are locked for you");

        }

    }


    public void SelectSchedule(ActionEvent e) throws IOException {
        Node node = (Node) e.getSource();
        stage = (Stage) node.getScene().getWindow();
        member user = (member) stage.getUserData();

        boolean s=user.paymentverify(user);
        boolean s2=user.statusVerify(user);
        if(s==true && s2==false) {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("member_select_schedule.fxml"));

            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setUserData(user);
            stage.setScene(scene);
            stage.show();
        }
        else if(s==false){
            t.setText("Sorry you are a fee defaulter, so cannot access this tool");
        }
        else{

            t.setText("Sorry your membership is paused so all features are locked for you");

        }

    }

    public void viewEquipment(ActionEvent e) throws IOException{

        Node node = (Node) e.getSource();
        stage = (Stage) node.getScene().getWindow();
        member user = (member) stage.getUserData();

        boolean s=user.paymentverify(user);
        boolean s2=user.statusVerify(user);
        if(s==true &&s2 ==false) {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("viewEquipment.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        else if(s==false){

            t.setText("Sorry you are a fee defaulter, so cannot access this tool");

        }
        else{
            t.setText("Sorry your membership is paused so all features are locked for you");
        }
    }


    public void UpdateProfile(ActionEvent e) throws IOException{

        Node node = (Node) e.getSource();
        stage = (Stage) node.getScene().getWindow();
        member user = (member) stage.getUserData();

        boolean s=user.paymentverify(user);
        if(s==true) {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("UpdateMember.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

        }
        else{

            t.setText("Sorry you are a fee defaulter, so cannot access this tool");

        }







    }


    public void PauseMembership(ActionEvent event) throws IOException {

        Node node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        member user = (member) stage.getUserData();
        boolean s=user.paymentverify(user);
        if(s==true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to pause membership?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {

                user.setStatusFLag("pause");


            }

        }
        else{
            t.setText("Sorry, you are a fee defaulter so, can't access this tool");
        }

    }



    public void CancelMembership(ActionEvent event) throws IOException {

        Node node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        member user = (member) stage.getUserData();
        boolean s=user.paymentverify(user);
        if(s){

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to cancel your membership? After that you will no longer remain a member", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {

                gym g=new gym();
                g.cancelMember(user);


                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("member_login.fxml"));
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();


            }




        }

        else{
            t.setText("Sorry, you are a fee defaulter so, clear your dues first");
        }



    }

    public void ResumeMembership(ActionEvent event) throws IOException {


        Node node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        member user = (member) stage.getUserData();

        if(user.getStatusFLag2(user).equals("active")){
            t.setText("Your membership is already active");


        }

        else{

            gym g=new gym();
            g.ResumeMembership(user);
            t.setText("Your membership is resumed again, you can now access all features again");
        }




    }





}
