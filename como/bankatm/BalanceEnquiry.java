package como.bankatm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pinnumber1;

    int balance;
     JButton back;
    BalanceEnquiry(String pinnumber)
    {
        this.pinnumber1 = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("como/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,750,750);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pinNumber = '"+pinnumber1+"' ");
            balance = 0;
            while (rs.next()){
                if(rs.getString("accountType").equals("DEPOSIT")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else {
                    balance -=  Integer.parseInt(rs.getString("amount"));
                }}
        }
            catch (Exception e){
                System.out.println(e);
            }

        JLabel text = new JLabel("YOU CURRENT ACCOUNT BALANCE IS ");
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,14));
        text.setBounds(143,270,500,25);
        image.add(text);

        JLabel textbalance = new JLabel("Rs : "+balance);
        textbalance.setForeground(Color.white);
        textbalance.setFont(new Font("Raleway",Font.BOLD,14));
        textbalance.setBounds(235,305,500,25);
        image.add(textbalance);

        back = new JButton("Back");
        back.setBounds(280,434,150,27);
        back.addActionListener(this);
        image.add(back);


        setSize(750,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinnumber1).setVisible(true);
    }

    public static void main(String[] args) {
      new BalanceEnquiry("");
    }
}
