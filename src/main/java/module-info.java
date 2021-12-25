module gms.sda_ap {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires javax.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires mysql.connector.java;
    requires org.testng;
    requires junit;

    opens gms.sda_ap.model to javax.persistence;
    opens gms.sda_ap.view to javafx.fxml;
    exports gms.sda_ap.controller;
    exports gms.sda_ap.model;
    exports gms.sda_ap.test;
    exports gms.sda_ap;
    exports gms.sda_ap.exceptions;
    opens gms.sda_ap.exceptions to javafx.fxml;
}