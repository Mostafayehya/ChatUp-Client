package eg.gov.iti.jets.ui.controllers;

import eg.gov.iti.jets.ui.models.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContactItemController implements Initializable {
    @FXML
    Circle imageCircle;
    @FXML
    Label contactNameLabel;
    @FXML
    Label bioLabel;
    @FXML
    FontIcon messageIcon;
    Contact contact;

    public ContactItemController(Contact contact){
        this.contact = contact;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File imageFile = new File(contact.getImage());
        Image image = null;
        try {
            image = new Image(new FileInputStream(imageFile.getAbsoluteFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        imageCircle.setFill(new ImagePattern(image));
        //imageCircle.setRadius(20);
        contactNameLabel.setText(contact.getName());
        bioLabel.setText(contact.getBio());

        messageIcon.addEventHandler(ActionEvent.ACTION,(e)->{

        });
    }


}
