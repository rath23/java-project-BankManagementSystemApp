package como.bankatm;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    String pinnumber1;

    MiniStatement(String pinnumber){
        this.pinnumber1 = pinnumber;

        setLayout(null);

        getContentPane().setBackground(Color.white);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank = new JLabel("Bank Of Vatican");
        bank.setFont(new Font("Raleway",Font.BOLD,20));
        bank.setBounds(110,20,160,25);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            Conn c = new Conn() ;
            ResultSet rs = c.s.executeQuery("select * from login where pinNumber = '"+pinnumber1+"'");
            while (rs.next()){
                card.setText("Card Number : "+rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardNumber").substring(12));
            }

        }
        catch (Exception e ){
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            int bal=0;
            ResultSet rs = c.s.executeQuery("select * from bank where pinNumber = '"+pinnumber+"'");
            while (rs.next()){
                mini.setText(mini.getText() + "<html>" +rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("accountType") + "&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;" +rs.getString("amount") +"<br><br><html>");

                if(rs.getString("accountType").equals("DEPOSIT"))
                {
                    bal += Integer.parseInt(rs.getString("amount"));
                }

                else {
                    bal -=  Integer.parseInt(rs.getString("amount"));
                }
            }
           balance.setText("Your current account balance is Rs : " +bal);
        }
        catch (Exception e){

        }

        setTitle("MiniStatement");
        setSize(400,600);
        setLocation(20,20);
        setVisible(true);
    }

    public static void main(String[] args) {
     new MiniStatement("");
    }
}
