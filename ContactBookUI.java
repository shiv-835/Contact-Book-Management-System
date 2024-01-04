import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ContactBookUI extends JFrame{
    public JFrame mainWindow;
    ContactBookUI(AddressBook manager){
        mainWindow = new JFrame();
        Color text = new Color(251, 248, 190);
        Color bg = new Color(35, 78, 112);
        Font buttonFont = new Font("Montserrat",Font.BOLD,24);
        JPanel background = new JPanel();{
            JLabel heading = new JLabel("CONTACT BOOK");
            heading.setFont(new Font("Montserrat", Font.BOLD, 36));
            heading.setBounds(250,10,700,50);
            heading.setForeground(text);
            mainWindow.add(heading);

            JButton addContact = new JButton("<html>Add New<br>Contact</html>");
            addContact.setBounds(50,100,200,200);
            addContact.setFont(buttonFont);
            addContact.setForeground(bg);
            addContact.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddContact addcontact = new AddContact(manager);
                    addcontact.setTitle("Add New Contact");
                }
            });
            background.add(addContact);

            JButton updateContact = new JButton("<html>Update<br>Contact</html>");
            updateContact.setBounds(300,100,200,200);
            updateContact.setFont(buttonFont);
            updateContact.setForeground(bg);;
            updateContact.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    UpdateContact updatecontact = new UpdateContact(manager);
                    updatecontact.setTitle("Update Contact");
                }
            });
            background.add(updateContact);

            JButton searchContact = new JButton("<html>Search<br>Contact</html>");
            searchContact.setBounds(550,100,200,200);
            searchContact.setFont(buttonFont);
            searchContact.setForeground(bg);
            searchContact.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SearchContact searchcontact = new SearchContact(manager);
                    searchcontact.setTitle("Search Contact");
                }
            });
            background.add(searchContact);

            JButton deleteContact = new JButton("<html>Delete<br>Contact</html>");
            deleteContact.setBounds(50,350,200,200);
            deleteContact.setFont(buttonFont);
            deleteContact.setForeground(bg);
            deleteContact.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DeleteContact deletecontact = new DeleteContact(manager);
                    deletecontact.setTitle("Delete Contact");
                }
            });
            background.add(deleteContact);

            JButton DisplayContact = new JButton("<html>Display<br>Contacts</html>");
            DisplayContact.setBounds(300,350,200,200);
            DisplayContact.setFont(buttonFont);
            DisplayContact.setForeground(bg);
            DisplayContact.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DisplayContact displaycontacts = new DisplayContact(manager);
                    displaycontacts.setTitle("Contact List");
                }
            });
            background.add(DisplayContact);

            JButton quit = new JButton("Quit");
            quit.setBounds(550,350,200,200);
            quit.setFont(buttonFont);
            quit.setForeground(bg);
            quit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainWindow.dispose();
                }
            });
            background.add(quit);
        }
        background.setSize(800,600);
        background.setBackground(bg);
        background.setLayout(null);

        mainWindow.setResizable(false);
        mainWindow.add(background);
        mainWindow.setLayout(null);
        mainWindow.setSize(800,600);
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new ContactBookUI(null);
    }
}
