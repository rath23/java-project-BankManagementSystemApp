
        package como.bankatm;

import como.bankatm.Deposit;
import como.bankatm.Withdraw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

        public class FastCash extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7;

    String pinnumber1 ;
    FastCash(String pinnumber){
        this.pinnumber1=pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("como/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,750,750);
        add(image);



        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT ");
        text.setBounds(110,240,550,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Ralway",Font.BOLD,16));
        image.add(text);

        b1 = new JButton("RS 50");
        b1.setBounds(90,340,150,30);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Rs 100");
        b2.setBounds(290,340,150,30);
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("Rs 500");
        b3.setBounds(90,375,150,30);
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("Rs 1000");
        b4.setBounds(290,375,150,30);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("Rs 5000");
        b5.setBounds(90,410,150,30);
        b5.addActionListener(this);
        image.add(b5);


        b6 = new JButton("Rs 10000");
        b6.setBounds(290,410,150,30);
        b6.addActionListener(this);
        image.add(b6);


        b7 = new JButton("Back");
        b7.setBounds(290,445,150,30);
        b7.addActionListener(this);
        image.add(b7);

        setSize(750,750);
        setLocation(300,00);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == b7){
            setVisible(false);
            new Transaction(pinnumber1).setVisible(true);
        }
        else{
         String samount =( (JButton)ae.getSource()).getText().substring(3);
         try{
             Conn c = new Conn();
             ResultSet rs = c.s.executeQuery("select * from bank where pinNumber = '"+pinnumber1+"' ");
             int balance = 0;
             while (rs.next()){
              if(rs.getString("accountType").equals("DEPOSIT")){
               balance += Integer.parseInt(rs.getString("amount"));
              }
              else {
                  balance -=  Integer.parseInt(rs.getString("amount"));
              }
              if (ae.getSource()!= b7 && balance<Integer.parseInt(samount)){
                  JOptionPane.showMessageDialog(null,"Insufficient Balance");
                  return;
              }
              Date date = new Date();
              String query = "insert into bank values ('"+pinnumber1+"', '"+date+"', 'WITHDRAW', '"+samount+"')";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "RS "+samount+" Debited successfully");
              setVisible(false);
              new Transaction(pinnumber1).setVisible(true);
             }
         }
         catch (Exception e){
             System.out.println(e);
         }
        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
