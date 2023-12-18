import java.sql.*;
import javax.swing.*;
public class AddressBook {
    public Connection con;
    AddressBook(Connection con){
        this.con = con;
    }
    public void AddContact(Contact c){
        String query = "INSERT INTO AddressBook VALUES(?,?,?,?,?)";
        try {
            PreparedStatement insert = con.prepareStatement(query);
            insert.setString(1,c.name);
            insert.setLong(2,c.phone_number);
            insert.setString(3,c.email);
            insert.setString(4,c.city);
            insert.setString(5,c.number_type);
            insert.executeUpdate();
        }
        catch (Exception insertException){
            insertException.printStackTrace();
        }
    }
    public void UpdateContact(Long target,Contact c) throws SQLException {
        String query = "UPDATE AddressBook SET name=?,phone_number=?,email=?,city=?,number_type=? WHERE phone_number=?";
        PreparedStatement update = con.prepareStatement(query);
        update.setString(1,c.name);
        update.setLong(2,c.phone_number);
        update.setString(3,c.email);
        update.setString(4,c.city);
        update.setString(5,c.number_type);
        update.setLong(6,target);
        int rowCount = update.executeUpdate();
        if (rowCount!=0)
            JOptionPane.showMessageDialog(null,"Contact Updated Successfully");
        else
            JOptionPane.showMessageDialog(null,"Contact Doesn't Exists");
    }
    public void DeleteContact(long target) throws SQLException {
        String query = "DELETE FROM AddressBook WHERE phone_number=?";
        PreparedStatement delete = con.prepareStatement(query);
        delete.setLong(1,target);
        int result = delete.executeUpdate();
        if(result == 0)
            JOptionPane.showMessageDialog(null,"Contact does not exists!");
        else
            JOptionPane.showMessageDialog(null, "Contact deleted successfully!");
    }
    public Output SearchContact(long target) throws SQLException {
        String query = "SELECT * FROM AddressBook where phone_number=?";
        PreparedStatement search = con.prepareStatement(query);
        search.setLong(1,target);
        ResultSet out = search.executeQuery();
        query = "SELECT COUNT(*) AS enable FROM AddressBook where phone_number=?";
        int enable = 0;
        search = con.prepareStatement(query);
        search.setLong(1,target);
        ResultSet Enable = search.executeQuery();
        while(Enable.next()){
            enable = Enable.getInt("enable");
        }
        return new Output(enable,out);
    }
    public Output DisplayContact() throws SQLException {
        int contact_count = 0;
        String query = "SELECT * FROM AddressBook ORDER BY name";
        PreparedStatement display = con.prepareStatement(query);
        ResultSet contacts = display.executeQuery();
        query = "SELECT COUNT(*) AS record_count FROM AddressBook";
        display = con.prepareStatement(query);
        ResultSet item_count = display.executeQuery();
        while (item_count.next()) {
            contact_count = item_count.getInt("record_count");
        }
        return new Output(contact_count, contacts);
    }
}
