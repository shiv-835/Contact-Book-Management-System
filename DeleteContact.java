import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
public class DeleteContact extends JFrame{
    DeleteContact(AddressBook manager){

        Color text = new Color(251, 248, 190);
        Color bg = new Color(35, 78, 112);

        JPanel background = new JPanel();{
            JLabel heads = new JLabel("Delete Contact");
            heads.setBounds(110,10,350,30);
            heads.setForeground(text);
            heads.setFont(new Font("Montserrat",Font.BOLD,24));
            this.add(heads);

            JLabel Head = new JLabel("Enter Phone Number to delete contact : ");
            Head.setBounds(60,40,300,30);
            Head.setFont(new Font("Montserrat",Font.PLAIN,13));
            Head.setForeground(text);
            background.add(Head);

            JTextField searchElement = new JTextField();
            searchElement.setBounds(50,70,290,30);
            searchElement.setHorizontalAlignment(SwingConstants.CENTER);
            background.add(searchElement);

            JButton delete = new JButton("Delete Contact");
            delete.setBounds(65,110,140,50);
            delete.setFont(new Font("Montserrat",Font.BOLD,14));
            delete.setForeground(bg);
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        manager.DeleteContact(Long.parseLong(searchElement.getText()));
                    } catch (SQLException delsql) {
                        delsql.printStackTrace();
                    }
                }
            });

            JButton reset = new JButton("Reset");
            reset.setBounds(220,110,120,50);
            reset.setFont(new Font("Montserrat",Font.BOLD,14));
            reset.setForeground(bg);
            reset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    searchElement.setText("");
                }
            });
            background.add(reset);
            background.add(delete);
        }
        background.setBounds(0,0,400,200);
        background.setBackground(bg);
        background.setLayout(null);

        this.add(background);
        this.setLayout(null);
        this.setSize(400,200);
        this.setVisible(true);
        this.setResizable(false);
    }
    public static void main(String[] args) {
        new DeleteContact(null);
    }
}
