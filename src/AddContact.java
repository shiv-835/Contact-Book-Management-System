import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddContact extends JFrame{
    AddContact(AddressBook manager){
        Color text = new Color(251, 248, 190);
        Color bg = new Color(35, 78, 112);
        JPanel background = new JPanel(); {
            Font head = new Font("Montserrat",Font.BOLD,19);
            JLabel heads = new JLabel("Add a Contact");
            heads.setBounds(120,10,350,30);
            heads.setForeground(text);
            heads.setFont(new Font("Montserrat",Font.BOLD,24));
            this.add(heads);

            JLabel [] headings = new JLabel[5];
            String [] heading_text= {"Name :","Phone Number :","Email :","City :","Contact Type :"};

            JTextField nameInput = new JTextField();
            nameInput.setBounds(95,80,290,30);
            JTextField phoneInput = new JTextField();
            phoneInput.setBounds(185,120,200,30);
            JTextField emailInput = new JTextField();
            emailInput.setBounds(95,160,290,30);
            JTextField cityInput = new JTextField();
            cityInput.setBounds(75,200,310,30);

            String [] types = {"Home","Work","Personal","Other"};
            JComboBox <String> typeInput = new JComboBox<>(types);
            typeInput.setBounds(175,240,120,30);
            typeInput.setFont(new Font("Montserrat",Font.PLAIN,14));

            this.add(nameInput);
            this.add(phoneInput);
            this.add(emailInput);
            this.add(cityInput);
            this.add(typeInput);
            int y = 80;
            for (int i=0;i<5;i++){
                headings[i] = new JLabel(heading_text[i]);
                headings[i].setBounds(15,y,200,30);
                headings[i].setFont(head);
                headings[i].setForeground(text);
                this.add(headings[i]);
                y += 40;
            }

            JButton submit = new JButton("Add Contact");
            submit.setBounds(65,280,120,50);
            submit.setFont(new Font("Montserrat",Font.BOLD,14));
            submit.setForeground(bg);
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!phoneInput.getText().matches("\\d{10}")){
                        JOptionPane.showMessageDialog(null,"Only Numbers should be present");
                        return;
                    }
                    else if (!emailInput.getText().contains(".com")||!emailInput.getText().contains("@")){
                        JOptionPane.showMessageDialog(null,"Invalid Email Format");
                        return;
                    }
                    Contact c = new Contact(nameInput.getText(), Long.parseLong(phoneInput.getText()),emailInput.getText(),cityInput.getText(),(String)typeInput.getSelectedItem());
                    manager.AddContact(c);
                }
            });

            JButton reset = new JButton("Reset");
            reset.setBounds(200,280,120,50);
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
                    JOptionPane.showMessageDialog(null,"Details restored to default");
                }
            });
            this.add(reset);
            this.add(submit);
            this.setLayout(null);
        }
        background.setBounds(0,0,400,500);
        background.setBackground(new Color(35, 78, 112));
        this.add(background);
        this.setLayout(null);
        this.setSize(400,400);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new AddContact(null);
    }
}
