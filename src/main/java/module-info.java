module gms.sda_ap {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
   // requires javax.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires mysql.connector.java;
    requires org.testng;
    requires junit;

    opens gms.SE.model to javax.persistence;
    opens gms.SE.view to javafx.fxml;
    exports gms.SE.controller;
    exports gms.SE.model;
    exports gms.SE.test;
    exports gms.SE;
    exports gms.SE.exceptions;
    opens gms.SE.exceptions to javafx.fxml;
}