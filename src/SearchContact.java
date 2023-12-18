import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
public class SearchContact extends JFrame{
    SearchContact(AddressBook manager){
        Color text = new Color(251, 248, 190);
        Color bg = new Color(35, 78, 112);

        JPanel background = new JPanel();{
            JLabel heads = new JLabel("Search Contact");
            heads.setBounds(110,10,350,30);
            heads.setForeground(text);
            heads.setFont(new Font("Montserrat",Font.BOLD,24));
            this.add(heads);

            JLabel Head = new JLabel("Enter Phone Number to search contact : ");
            Head.setBounds(60,40,300,30);
            Head.setFont(new Font("Montserrat",Font.PLAIN,13));
            Head.setForeground(text);
            background.add(Head);

            JTextField searchElement = new JTextField();
            searchElement.setBounds(50,70,290,30);
            searchElement.setHorizontalAlignment(SwingConstants.CENTER);
            background.add(searchElement);

            JButton search = new JButton("Search Contact");
            search.setBounds(65,110,140,50);
            search.setFont(new Font("Montserrat",Font.BOLD,14));
            search.setForeground(bg);
            search.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Output tempOut = manager.SearchContact(Long.valueOf(searchElement.getText()));
                        if (tempOut.count==0){
                            JOptionPane.showMessageDialog(null,"No such contact found","Error!",JOptionPane.ERROR_MESSAGE);
                        }else {
                            String[] info = new String[5];
                            while(tempOut.rs.next()){
                                info[0] = tempOut.rs.getString("name");
                                info[1] = String.valueOf(tempOut.rs.getLong("phone_number"));
                                info[2] = tempOut.rs.getString("email");
                                info[3] = tempOut.rs.getString("city");
                                info[4] = tempOut.rs.getString("number_type");
                            }
                            JOptionPane.showMessageDialog(null,"Name: "+info[0]+"\nPhone number: "+info[1]+"\n"+"Email: "+info[2]+"\nCity: "+info[3]+"\n"+"Contact Type: "+info[4],info[0],1);
                        }
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
            background.add(search);
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
        new SearchContact(null);
    }
}
