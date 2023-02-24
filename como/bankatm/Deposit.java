package como.bankatm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JButton deposit,back;

    JTextField amount ;

    String pinnumd;
    Deposit(String pinnumd){

        this.pinnumd = pinnumd;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("como/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,750,750);
        add(image);

        JLabel heading = new JLabel("ENTER THE AMOUNT YOU WANNA DEPOSIT");
        heading.setFont(new Font("Raleway",Font.BOLD,13));
        heading.setForeground(Color.white);
        heading.setBounds(135,250,550,25);
        image.add(heading);

        amount = new JTextField();
        amount.setBounds(130,300,300,30);
        image.add(amount);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(280,403,150,28);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(280,434,150,27);
        back.addActionListener(this);
        image.add(back);


        setSize(750,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
       if (ae.getSource() == deposit){
           String samount = amount.getText();
           Date date = new Date();
           if(samount.equals("")){
               JOptionPane.showMessageDialog(null,"PLEASE ENTER A AMOUNT YOU WANT TO DEPOSIT");
           }
           else {
               try {
                   Conn c = new Conn();
                   String query = "insert into bank values('"+pinnumd+"', '"+date+"', 'DEPOSIT', '"+samount+"')";
                   c.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null,"Rs "+samount+ " HAS BEEN DEPOSIT");
                   setVisible(false);
                   new Transaction(pinnumd).setVisible(true);
               }

               catch (Exception e){
                   System.out.println(e);
               }
           }
       }
       else if (ae.getSource() == back) {
           setVisible(false);
           new Transaction(pinnumd).setVisible(true);
       }

    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
