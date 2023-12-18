import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
public class UpdateContact extends JFrame{
    UpdateContact(AddressBook manager){
        Color text = new Color(251, 248, 190);
        Color bg = new Color(35, 78, 112);
        Font head = new Font("Montserrat",Font.BOLD,19);

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBounds(0,0,400,500);
        backgroundPanel.setBackground(bg);
        {
            backgroundPanel.setLayout(null);
            JLabel title = new JLabel("Update Contact");
            title.setBounds(90,10,350,30);
            title.setForeground(text);
            title.setFont(new Font("Montserrat",Font.BOLD,24));
            backgroundPanel.add(title);

            JLabel Head = new JLabel("Enter Phone Number to update contact : ");
            Head.setBounds(60,40,300,30);
            Head.setFont(new Font("Montserrat",Font.PLAIN,13));
            Head.setForeground(text);
            backgroundPanel.add(Head);

            JTextField searchElement = new JTextField();
            searchElement.setBounds(50,70,290,30);
            searchElement.setHorizontalAlignment(SwingConstants.CENTER);
            backgroundPanel.add(searchElement);

            JLabel [] headings = new JLabel[5];
            String [] heading_text= {"Name :","Phone Number :","Email :","City :","Contact Type :"};

            JTextField nameInput = new JTextField();
            nameInput.setBounds(95,120,290,30);
            JTextField phoneInput = new JTextField();
            phoneInput.setBounds(185,160,200,30);
            JTextField emailInput = new JTextField();
            emailInput.setBounds(95,200,290,30);
            JTextField cityInput = new JTextField();
            cityInput.setBounds(75,240,310,30);

            String [] types = {"Home","Work","Personal","Other"};
            JComboBox <String> typeInput = new JComboBox<>(types);
            typeInput.setBounds(175,280,120,30);
            typeInput.setFont(new Font("Montserrat",Font.PLAIN,14));

            backgroundPanel.add(nameInput);
            backgroundPanel.add(phoneInput);
            backgroundPanel.add(emailInput);
            backgroundPanel.add(cityInput);
            backgroundPanel.add(typeInput);
            int y = 120;
            for (int i=0;i<5;i++){
                headings[i] = new JLabel(heading_text[i]);
                headings[i].setBounds(15,y,200,30);
                headings[i].setFont(head);
                headings[i].setForeground(text);
                backgroundPanel.add(headings[i]);
                y += 40;
            }
            JButton submit = new JButton("Update Contact");
            submit.setBounds(45,320,140,50);
            submit.setFont(new Font("Montserrat",Font.BOLD,14));
            submit.setForeground(bg);
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){ 
                    if (!phoneInput.getText().matches("\\d{10}")){
                        JOptionPane.showMessageDialog(null,"Only Numbers should be present");
                        return;
                    }
                    else if (!emailInput.getText().contains(".com")||!emailInput.getText().contains("@")){
                        JOptionPane.showMessageDialog(null,"Invalid Email Format");
                        return;
                    }
                    Contact c = new Contact(nameInput.getText(), Long.parseLong(phoneInput.getText()),emailInput.getText(),cityInput.getText(),(String)typeInput.getSelectedItem());
                    try {
                        manager.UpdateContact(Long.parseLong(searchElement.getText()),c);
                    } catch (SQLException sql){
                        sql.printStackTrace();
                    }
                }
            });

            JButton reset = new JButton("Reset");
            reset.setBounds(200,320,120,50);
            reset.setFont(new Font("Montserrat",Font.BOLD,14));
            reset.setForeground(bg);
            reset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    nameInput.setText("");
                    phoneInput.setText("");
                    emailInput.setText("");
                    cityInput.setText("");
                    typeInput.setSelectedIndex(0);
                }
            });
            backgroundPanel.add(submit);
            backgroundPanel.add(reset);
        }
        this.add(backgroundPanel);
        this.setSize(400,400);
        this.setLayout(null);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new UpdateContact(null);
    }
}
