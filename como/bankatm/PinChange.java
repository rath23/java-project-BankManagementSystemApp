package como.bankatm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PinChange extends JFrame implements ActionListener {

    JPasswordField t1 ,t2;

    JButton b1,b2;

    String pinnumber;
    PinChange(String pinnum) {

        this.pinnumber = pinnum;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("como/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,750,750);
        add(image);

        JLabel heading = new JLabel("CHANGE YOUR PIN");
        heading.setForeground(Color.white);
        heading.setFont(new Font("Raleway",Font.BOLD,16));
        heading.setBounds(200,250,500,30);
        image.add(heading);

        JLabel pintext1 = new JLabel("NEW PIN : ");
        pintext1.setForeground(Color.white);
        pintext1.setFont(new Font("Raleway",Font.BOLD,13));
        pintext1.setBounds(135,290,180,25);
        image.add(pintext1);

        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway",Font.BOLD,12));
        t1.setBounds(270,290,150,25);
        image.add(t1);

        JLabel pintext2 = new JLabel("RE-ENTER NEW PIN : ");
        pintext2.setForeground(Color.white);
        pintext2.setFont(new Font("Raleway",Font.BOLD,13));
        pintext2.setBounds(135,325,180,25);
        image.add(pintext2);

        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway",Font.BOLD,12));
        t2.setBounds(270,325,150,25);
        image.add(t2);

        b1 = new JButton("CONTINUE");
        b1.setBounds(280,403,150,28);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(280,434,150,27);
        b2.addActionListener(this);
        image.add(b2);



        setSize(750,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b2){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        else {
           try{
               String npin = t1.getText();
            String rpin = t2.getText();
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"PASSWORD DIDN'T MATCH");
                return;
            }
            if (npin.equals("")) {
                JOptionPane.showMessageDialog(null,"PLEASE ENTER NEW PIN");
                return;
            }

               if (rpin.equals("")) {
                   JOptionPane.showMessageDialog(null,"PLEASE RE-ENTER NEW PIN");
                   return;
               }

               Conn c = new Conn();
               String query1 = "update bank set pinNumber = '"+rpin+"' where pinNumber = '"+pinnumber+"' ";
               String query2 = "update login set pinNumber = '"+rpin+"' where pinNumber = '"+pinnumber+"' ";
               String query3 = "update signupthree set pinNumber = '"+rpin+"' where pinNumber = '"+pinnumber+"' ";

               c.s.executeUpdate(query1);
               c.s.executeUpdate(query2);
               c.s.executeUpdate(query3);

               JOptionPane.showMessageDialog(null,"PIN CHANGED SUCCESSFULLY");

               setVisible(false);
               new Transaction(rpin).setVisible(true);

           }
            catch (Exception e){
                System.out.println(e);
               }
            }


        }


    public static void main(String[] args) {
        new PinChange("");
    }
}
