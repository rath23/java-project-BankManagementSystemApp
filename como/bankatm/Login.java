package como.bankatm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton signin,clear,signup;
    JTextField cardTextField;

    JPasswordField pinTextField;
    Login(){
        setTitle("Automated Teller Machine(by Muneer)");

        setLayout(null);

/* image icon is a class which is used to get image icon in the frame so we created an object of imageicon */
        /* in parantesis we use a class called classloder in it there is a static metond that is getsystemrescouce */
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("como/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel label = new JLabel(i3);
        label.setBounds(130,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD,38) );
        text.setBounds(250,40,400,40);
        add(text);

        JLabel card = new JLabel("CARD NUMBER : ");
        card.setFont(new Font("Raleway" , Font.BOLD,28));
        card.setBounds(145,120,250,30);
        add(card);

        cardTextField = new JTextField();
        cardTextField.setBounds(410 , 120, 250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,18));
        add(cardTextField);

        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(150,170,150,30);
        add(pin);

         pinTextField = new JPasswordField();
        pinTextField.setBounds(410,170,150,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,18));
        add(pinTextField);

         signin = new JButton("SIGN IN");
        signin.setBounds(230,230,100,30);
        signin.setBackground(Color.black);
        signin.setForeground(Color.white);
        signin.addActionListener(this);
        add(signin);

         clear = new JButton("CLEAR");
        clear.setBounds(370,230,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

         signup = new JButton("SIGN UP");
        signup.setBounds(230,280,240,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);

        setSize(800,480);
        setVisible(true);
        setLocation(300,150);
    }
/*abstract methods abstract classes and interface are important  */

    @Override
    public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == clear) {
         cardTextField.setText("");
         pinTextField.setText("");
      }
      else if (ae.getSource()==signin) {
         String cardnumber = cardTextField.getText();
         String pinnumber = pinTextField.getText();
         String query = "select *from login where cardNumber = '"+cardnumber+"' and piNNumber = '"+pinnumber+ "' ";
          try{
            Conn c = new Conn();
 //  c.s.executeQuery(query);   return data type is Resultset so we have to store it in a result set and resultset class is in sql package we have to import sql package

          ResultSet rs = c.s.executeQuery(query);
          if (rs.next()){
              setVisible(false);
              new Transaction(pinnumber).setVisible(true);
          }
          else {
              JOptionPane.showMessageDialog(null,"INCORRECT CARD NUMBER OR PIN");
          }

          }
          catch (Exception e){
              System.out.println(e);
          }

      }
      else if (ae.getSource()==signup) {
         setVisible(false);
         new SignupOne().setVisible(true);
      }
    }


    public static void main(String[] args) {
    new Login();
    }
}
