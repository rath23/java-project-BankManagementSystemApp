package como.bankatm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JLabel heading , accounttype , cardnum ;

    JRadioButton saccount,fdaccount,caccount,rdaccount;

    JCheckBox c1,c2,c3,c4,c5,c6,c7;

    JButton next,cancel;

    String formnum0;
    SignupThree(String formno){
        this.formnum0 = formno;
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setTitle("Something");

        heading = new JLabel("PAGE 3 : ACCOUNT DETAILS");
        heading.setFont(new Font("Raleway",Font.BOLD,21));
        heading.setBounds(190,20,300,25);
        add(heading);

        accounttype = new JLabel("ACCOUNT TYPE :");
        accounttype.setFont(new Font("Raleway", Font.BOLD,16));
        accounttype.setBounds(80,90,200,20);
        add(accounttype);

        saccount = new JRadioButton("SAVING ACCOUNT");
        saccount.setFont(new Font("Raleway",Font.BOLD,12));
        saccount.setBounds(90,120,150,18);
        saccount.setBackground(Color.white);
        add(saccount);

        caccount = new JRadioButton("CURRENT ACCOUNT");
        caccount.setFont(new Font("Raleway",Font.BOLD,12));
        caccount.setBounds(90,145,150,18);
        caccount.setBackground(Color.white);
        add(caccount);

        fdaccount = new JRadioButton("FIXED DEPOSIT ACCOUNT");
        fdaccount.setFont(new Font("Raleway",Font.BOLD,12));
        fdaccount.setBounds(300,120,200,18);
        fdaccount.setBackground(Color.white);
        add(fdaccount);

        rdaccount = new JRadioButton("RECURRING DEPOSIT ACCOUNT");
        rdaccount.setFont(new Font("Raleway",Font.BOLD,12));
        rdaccount.setBounds(300,145,250,18);
        rdaccount.setBackground(Color.white);
        add(rdaccount);

        ButtonGroup atypes = new ButtonGroup();
        atypes.add(saccount);
        atypes.add(caccount);
        atypes.add(fdaccount);
        atypes.add(rdaccount);

        cardnum = new JLabel("CARD NUMBER  :");
        cardnum.setFont(new Font("Raleway",Font.BOLD,16));
        cardnum.setBounds(80,200,150,20);
        add(cardnum);

        JLabel cdetail = new JLabel("Your 16 digit card number");
        cdetail.setFont(new Font("Raleway",Font.BOLD,10));
        cdetail.setBounds(80,220,200,15);
        add(cdetail);

        JLabel cnum = new JLabel("XXXX-XXXX-XXXX-6354");
        cnum.setFont(new Font("Raleway",Font.BOLD,16));
        cnum.setBounds(280,200,200,20);
        add(cnum);

        JLabel pin = new JLabel("PIN  :");
        pin.setFont(new Font("Raleway",Font.BOLD,16));
        pin.setBounds(80,260,200,20);
        add(pin);

        JLabel pdetail = new JLabel("Your 4 digit card password");
        pdetail.setFont(new Font("Raleway",Font.BOLD,10));
        pdetail.setBounds(80,280,200,15);
        add(pdetail);

        JLabel pinnum = new JLabel("XXXX");
        pinnum.setFont(new Font("Raleway",Font.BOLD,16));
        pinnum.setBounds(280,260,200,20);
        add(pinnum);

        JLabel services = new JLabel("SERVICES REQUIRED  :");
        services.setFont(new Font("Raleway",Font.BOLD,16));
        services.setBounds(80,320,200,20);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,12));
        c1.setBounds(90,360,150,15);
        c1.setBackground(Color.white);
        add(c1);

        c2 = new JCheckBox("INTERNET BANKING");
        c2.setFont(new Font("Raleway",Font.BOLD,12));
        c2.setBounds(300,360,150,15);
        c2.setBackground(Color.white);
        add(c2);

        c3 = new JCheckBox("MOBILE BANKING");
        c3.setFont(new Font("Raleway",Font.BOLD,12));
        c3.setBounds(90,385,150,15);
        c3.setBackground(Color.white);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS ALERT");
        c4.setFont(new Font("Raleway",Font.BOLD,12));
        c4.setBounds(300,385,150,15);
        c4.setBackground(Color.white);
        add(c4);

        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setFont(new Font("Raleway",Font.BOLD,12));
        c5.setBounds(90,410,150,15);
        c5.setBackground(Color.white);
        add(c5);

        c6 = new JCheckBox("E-STATEMENT");
        c6.setFont(new Font("Raleway",Font.BOLD,12));
        c6.setBounds(300,410,150,15);
        c6.setBackground(Color.white);
        add(c6);

        c7 = new JCheckBox("I HEREBY DECLARES THAT THE ABOVE ENTERED DETAILS ARE CORRECT TO THE BEST OF MY KNOWLEDGE ");
        c7.setFont(new Font("Raleway",Font.BOLD,9));
        c7.setBounds(60,510,550,15);
        c7.setBackground(Color.white);
        add(c7);

        next = new JButton("SUBMIT");
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(350,560,100,25);
        next.addActionListener(this);
        add(next);

        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Raleway",Font.BOLD,15));
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(100,560,100,25);
        cancel.addActionListener(this);
        add(cancel);

        setSize(650,700);
        setVisible(true);
        setLocation(400,30);
    }

    public void actionPerformed(ActionEvent ae){
        String formnum = ""+formnum0;
        String acc_type = null;
        if(saccount.isSelected() ){
            acc_type="SAVING ACCOUNT";
        } else if (caccount.isSelected()) {
            acc_type = "CURRENT ACCOUNT";

        }
        else if (fdaccount.isSelected()) {
            acc_type = "FIXED DEPOSIT ACCOUNT";

        }else  {
            acc_type = "RECURRING DEPOSIT ACCOUNT";

        }

        Random random = new Random();
        long cardnumber = Math.abs(random.nextLong()%90000000)+5479320100000000L;
        long pinnumber = Math.abs(random.nextLong()%9000)+1000L;

        String scardnumber = ""+cardnumber;
        String spinnumber = ""+pinnumber;

        String services = "";
        if(c1.isSelected()){
            services = services+" ATM CARD,";
        }  if (c2.isSelected()) {
            services = services + " INTERNET BANKING,";
        }
        if (c3.isSelected()) {
            services = services + " MOBILE BANKING,";
        }
        if (c4.isSelected()) {
            services = services + " EMAIL & SMS ALERT,";
        }
        if (c5.isSelected()) {
            services = services + " CHEQUE BOOK,";
        }
        if (c6.isSelected()) {
            services = services + " E-STATEMENT,";
        }


        if(ae.getSource() == next){

            try{
             if (!(c7.isSelected())){
                 JOptionPane.showMessageDialog(null,"PLEASE CHECK BOX OUR TERM");
             }

          Conn c = new Conn();
          String query1 = "insert into signupthree values('"+formnum+"', '"+acc_type+"', '"+scardnumber+"', '"+spinnumber+"', '"+services+"')";
                String query2 = "insert into login values('"+formnum+"', '"+scardnumber+"', '"+spinnumber+"')";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"CARD NUMBER : "+cardnumber+"\n PIN NUMBER : "+pinnumber);

                setVisible(false);
                new Deposit(spinnumber).setVisible(true);
        }
        catch (Exception e){
            System.out.println(e);
        }}
        else if(ae.getSource()== cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
new SignupThree("");
    }
}
