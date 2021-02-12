package eg.gov.iti.jets.data.dao;

import domains.Contact;
import eg.gov.iti.jets.data.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactDaoImpl implements ContactDao {
    DataBaseConnection dataBaseConnection = DataBaseConnection.getInstance();
    Connection connection = dataBaseConnection.getConnection();
    @Override
    public int insertContact(Contact contact) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into contact values (?,?)");
            preparedStatement.setString(1,contact.getContactPhoneNumber());
            preparedStatement.setString(2,contact.getUserPhoneNumber());
            preparedStatement.executeUpdate();
            preparedStatement.close();

            for(int i=0;i<contact.getExtraNumbers().size();i++){
                preparedStatement = connection.prepareStatement("insert into contact_extra_numbers values (?,?,?)");
                preparedStatement.setString(1,contact.getContactPhoneNumber());
                preparedStatement.setString(2,contact.getUserPhoneNumber());
                preparedStatement.setString(3,contact.getExtraNumbers().get(i));
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Contact getContact(String userPhone, String contactPhone) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from contact where contactPhone = ? and userPhone = ?");
            preparedStatement.setString(1,contactPhone);
            preparedStatement.setString(2,userPhone);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String contactPhoneNumber = resultSet.getString(1);
                String userPhoneNumber = resultSet.getString(2);
                preparedStatement.close();
                return new Contact(contactPhoneNumber,userPhoneNumber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
