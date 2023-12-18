import java.sql.*;
class Contact {
    public String name;
    public Long phone_number;
    public String email;
    public String city;
    public String number_type;
    Contact(String name,Long phone_number,String email,String city,String number_type){
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.city = city;
        this.number_type = number_type;
    }
}
class Output {
    int count;
    ResultSet rs;
    Output(int count,ResultSet rs){
        this.count = count;
        this.rs = rs;
    }
}
public class Management{
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact_book", "root", "Shiv1209$");
            AddressBook manager = new AddressBook(con);
            ContactBookUI mains = new ContactBookUI(manager);
            mains.mainWindow.setTitle("Contact Book");
        } catch (Exception e) {
            
        }
    }
}