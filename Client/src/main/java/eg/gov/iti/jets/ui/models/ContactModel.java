package eg.gov.iti.jets.ui.models;

import domains.Mode;
import domains.Status;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class ContactModel {
    //StringProperty userPhoneNumber = new SimpleStringProperty();
    StringProperty contactPhoneNumber = new SimpleStringProperty();
    StringProperty name = new SimpleStringProperty();
    StringProperty bio = new SimpleStringProperty();
    StringProperty email = new SimpleStringProperty();
    StringProperty image = new SimpleStringProperty();
    ObjectProperty<Status> status = new SimpleObjectProperty<>();
    ObjectProperty<Mode> mode = new SimpleObjectProperty<>();
    ObjectProperty<Image> contactImage = new SimpleObjectProperty<>();



    public ContactModel(String contactPhoneNumber, String name, String bio, String email, Status status, Mode mode, Image image){
        this.contactPhoneNumber.setValue(contactPhoneNumber);
        this.name.setValue(name);
        this.bio.setValue(bio);
        this.email.setValue(email);
        this.contactImage.setValue(image);
        this.status.setValue(status);
        this.mode.setValue(mode);
        this.image.setValue("");
    }



    public ContactModel(String contactPhoneNumber, String name, String image) {
        this.contactPhoneNumber.setValue( contactPhoneNumber);
        this.name.set(name);
        this.image.setValue(image);
    }

    public ContactModel() {
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber.get();
    }

    public StringProperty contactPhoneNumberProperty() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber.set(contactPhoneNumber);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }



    public void setName(String name) {
        this.name.set(name);
    }

    public String getBio() {
        return bio.get();
    }

    public StringProperty bioProperty() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio.set(bio);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getImage() {
        return image.get();
    }

    public StringProperty imageProperty() {
        return image;
    }

    public void setImage(String image) {
        this.image.set(image);
    }

    public Status getStatus() {
        return status.get();
    }

    public ObjectProperty<Status> statusProperty() {
        return status;
    }

    public void setStatus(Status status) {
        this.status.set(status);
    }

    public Mode getMode() {
        return mode.get();
    }

    public ObjectProperty<Mode> modeProperty() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode.set(mode);
    }

    public void setContactModel(ContactModel cm){
        this.name.set(cm.getName());
        this.bio.set(cm.getBio());
        this.email.set(cm.getEmail());
        this.image.set(cm.getImage());
        this.status.set(cm.getStatus());
        this.mode.set(cm.getMode());
        this.contactPhoneNumber.set(cm.getContactPhoneNumber());
        this.contactImage.set(cm.getContactImage());
    }


    public Image getContactImage() {
        return contactImage.get();
    }

    public ObjectProperty<Image> contactImageProperty() {
        return contactImage;
    }

    public void setContactImage(Image contactImage) {
        this.contactImage.set(contactImage);
    }
}
