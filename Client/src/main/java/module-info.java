module Client{
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome5;
    requires org.kordamp.ikonli.materialdesign2;
    requires com.jfoenix;

    exports eg.gov.iti.jets;
    opens eg.gov.iti.jets.ui.controllers;

    requires java.rmi;
    requires MiddleWare;
    requires java.desktop;


}