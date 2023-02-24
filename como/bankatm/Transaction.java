package como.bankatm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {

    JButton exit,balance,pinchange,deposit,withdrawl,fastcash,ministatement;

    String pinnumber1 ;
    Transaction(String pinnumber){
        this.pinnumber1=pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("como/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,750,750);
        add(image);



        JLabel text = new JLabel("PLEASE SELECT YOUR TRANSACTION ");
        text.setBounds(110,240,550,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Ralway",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(90,340,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("CASH WITHDRAWL");
        withdrawl.setBounds(290,340,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("FAST CASH");
        fastcash.setBounds(90,375,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("MINI STATEMENT");
        ministatement.setBounds(290,375,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("CHANGE PIN");
        pinchange.setBounds(90,410,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);


        balance = new JButton("BALANCE");
        balance.setBounds(290,410,150,30);
        balance.addActionListener(this);
        image.add(balance);


        exit = new JButton("EXIT");
        exit.setBounds(290,445,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(750,750);
        setLocation(300,00);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber1).setVisible(true);
        }
        else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdraw(pinnumber1).setVisible(true);
        }
        else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber1).setVisible(true);
        }

        else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber1).setVisible(true);
        }

        else if (ae.getSource() == balance) {
            setVisible(false);
            new BalanceEnquiry(pinnumber1).setVisible(true);
        }

        else if (ae.getSource() == ministatement) {
            new MiniStatement(pinnumber1).setVisible(true);
        }
    }

    public static void main(String[] args) {
new Transaction("");
    }
}
