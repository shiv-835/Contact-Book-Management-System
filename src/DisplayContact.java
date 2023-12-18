import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class DisplayContact extends JFrame{
    DisplayContact(AddressBook manager){
        try {
            Color text = new Color(251, 248, 190);
            Color bg = new Color(35, 78, 112);
            Output compData = manager.DisplayContact();
            if (compData.count == 0){
                JOptionPane.showMessageDialog(null,"No contacts exist in contact book");
                return;
            }else if (compData.count!=0) {
                JFrame DisplayWindow = new JFrame();
                JPanel DisplayPanel = new JPanel();
                DisplayPanel.setBackground(bg);
                int height = 150;
                Font head_font = new Font("Montserrat",Font.BOLD,14);
                Font head_font1 = new Font("Montserrat",Font.PLAIN,14);
                JLabel name = new JLabel("Name");
                JLabel roll = new JLabel("Phone Number");
                JLabel grade = new JLabel("Email");
                JLabel gender = new JLabel("City");
                JLabel phone = new JLabel("Contact Type");
                
                name.setBounds(20,20,300,25);
                roll.setBounds(150,20,350,25);
                grade.setBounds(340,20,250,25);
                gender.setBounds(600,20,250,25);
                phone.setBounds(750,20,300,25);

                name.setFont(head_font);
                roll.setFont(head_font);
                grade.setFont(head_font);
                gender.setFont(head_font);
                phone.setFont(head_font);

                name.setForeground(text);
                roll.setForeground(text);
                grade.setForeground(text);
                gender.setForeground(text);
                phone.setForeground(text);

                int label_height = 40;
                int row_counter = 0;
                JLabel [][] outLabels = new JLabel[compData.count][5];
                while (compData.rs.next()){
                    outLabels[row_counter][0] = new JLabel(compData.rs.getString("name"));
                    outLabels[row_counter][1] = new JLabel(String.valueOf(compData.rs.getLong("phone_number")));
                    outLabels[row_counter][2] = new JLabel(compData.rs.getString("email"));
                    outLabels[row_counter][3] = new JLabel(compData.rs.getString("city"));
                    outLabels[row_counter][4] = new JLabel(compData.rs.getString("number_type"));
                    outLabels[row_counter][0].setBounds(20,label_height,300,25);
                    outLabels[row_counter][1].setBounds(150,label_height,350,25);
                    outLabels[row_counter][2].setBounds(340,label_height,250,25);
                    outLabels[row_counter][3].setBounds(600,label_height,250,25);
                    outLabels[row_counter][4].setBounds(750,label_height,300,25);
                    label_height += 20;
                    row_counter++;
                    height += 20;
                }
                for (int i=0;i<compData.count;i++){
                    for (int j=0;j<5;j++){
                        DisplayPanel.add(outLabels[i][j]);
                        outLabels[i][j].setFont(head_font1);
                        outLabels[i][j].setForeground(text);
                    }
                }
                DisplayPanel.add(name);
                DisplayPanel.add(roll);
                DisplayPanel.add(grade);
                DisplayPanel.add(gender);
                DisplayPanel.add(phone);
                DisplayPanel.setLayout(null);
                DisplayPanel.setSize(900,height);
                DisplayPanel.setVisible(true);

                DisplayWindow.setTitle("Contact List");
                DisplayWindow.add(DisplayPanel);
                DisplayWindow.setLayout(null);
                DisplayWindow.setSize(900,height);
                DisplayWindow.setVisible(true);
            }
        } catch (SQLException e) {
            // TODO: handle exception
        }
        
    }
}
