package como.bankatm;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {


    int int_random;
    JTextField nameTF,fnameTF,mailTF,addTF,cityTF,stateTF,pinTF;
    JButton next;
    JRadioButton male,female,married,unmarried,gother,m_other;

    JDateChooser dateChooser;

    SignupOne(){

        setLayout(null);

        Random ran = new Random();
        int upperbound = 9999;
         int_random =  ran.nextInt(upperbound);

        setTitle("SIGN IN PAGE");

        JLabel Formno = new JLabel("APPLICATION FORM NO :"+int_random);
        Formno.setFont(new Font("Raleway",Font.BOLD,38));
        Formno.setBounds(130,20,600,40);
        add(Formno);

        JLabel personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,300,30);
        add(personalDetails);

        JLabel name = new JLabel("NAME : ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTF = new JTextField();
        nameTF.setFont(new Font("Raleway",Font.BOLD,14));
        nameTF.setBounds(300,140,400,30);
        add(nameTF);

        JLabel fname = new JLabel("FATHER'S NAME : ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTF = new JTextField();
        fnameTF.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTF.setBounds(300,190,400,30);
        add(fnameTF);

        JLabel dbirth = new JLabel("DATE OF BIRTH : ");
        dbirth.setFont(new Font("Raleway",Font.BOLD,20));
        dbirth.setBounds(100,240,200,30);
        add(dbirth);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(Color.green);
        add(dateChooser);

        JLabel gender = new JLabel("GENDRE : ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("MALE");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("FEMALE");
        female.setBounds(450,290,80,30);
        female.setBackground(Color.white);
        add(female);

        gother = new JRadioButton("OTHER");
        gother.setBounds(600,290,80,30);
        gother.setBackground(Color.white);
        add(gother);

        ButtonGroup genderbutton = new ButtonGroup();
        genderbutton.add(male);
        genderbutton.add(female);
        genderbutton.add(gother);

        JLabel mail = new JLabel("MAIL ADD : ");
        mail.setFont(new Font("Raleway",Font.BOLD,20));
        mail.setBounds(100,340,200,30);
        add(mail);

        mailTF = new JTextField();
        mailTF.setFont(new Font("Raleway",Font.BOLD,14));
        mailTF.setBounds(300,340,400,30);
        add(mailTF);

        JLabel mstatus = new JLabel("MARITAL STATUS : ");
        mstatus.setFont(new Font("Raleway",Font.BOLD,20));
        mstatus.setBounds(100,390,200,30);
        add(mstatus);

        married = new JRadioButton("MARRIED");
        married.setBounds(300,390,90,30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("UNMARRIED");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        m_other = new JRadioButton("OTHER");
        m_other.setBounds(600,390,80,30);
        m_other.setBackground(Color.white);
        add(m_other);


        ButtonGroup marriagestatus = new ButtonGroup();
        marriagestatus.add(married);
        marriagestatus.add(unmarried);
        marriagestatus.add(m_other);

        JLabel adrs = new JLabel("ADDRESS : ");
        adrs.setFont(new Font("Raleway",Font.BOLD,20));
        adrs.setBounds(100,440,200,30);
        add(adrs);

        addTF = new JTextField();
        addTF.setFont(new Font("Raleway",Font.BOLD,14));
        addTF.setBounds(300,440,400,30);
        add(addTF);


        JLabel city = new JLabel("CITY : ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        cityTF = new JTextField();
        cityTF.setFont(new Font("Raleway",Font.BOLD,14));
        cityTF.setBounds(300,490,400,30);
        add(cityTF);

        JLabel state = new JLabel("STATE : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        stateTF = new JTextField();
        stateTF.setFont(new Font("Raleway",Font.BOLD,14));
        stateTF.setBounds(300,540,400,30);
        add(stateTF);

        JLabel pincode = new JLabel("PIN CODE : ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pinTF = new JTextField();
        pinTF.setFont(new Font("Raleway",Font.BOLD,14));
        pinTF.setBounds(300,590,400,30);
        add(pinTF);

         next = new JButton("NEXT");
        next.setBounds(610,640,70,30);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(800,720);
        setVisible(true);
        setLocation(300,20);

    }


    public void actionPerformed(ActionEvent ae){
           String formno ="" + int_random;

        String name = nameTF.getText();
        String fname = fnameTF.getText();
        String dob =((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();/* getUiCompnent returns a text field so we have to concat with Jtextfield*/
        String gender = null;
        if(male.isSelected()){
            gender="MALE";
        } else if (female.isSelected()) {
            gender = "FEMALE";
        }
        else {
            gender="OTHER";
        }
        String mail = mailTF.getText();
        String mstatus = null;
        if(married.isSelected()){
            mstatus="MARRIED";
        } else if (unmarried.isSelected()) {
            mstatus="UNMARRIED";
        }
        else {
            mstatus="OTHER";
        }
        String address = addTF.getText();
        String city = cityTF.getText();
        String state = stateTF.getText();
        String pin =pinTF.getText();

        try{
         if (name.equals("")){
             JOptionPane.showMessageDialog(null,"Please Enter Name.");
         }
           else if (fname.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter Father's Name.");
            }


           else {
               Conn c = new Conn();
               /*insert into signup values.... is a DML command*/
               String query = "insert into signup values ('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+mail+"', '"+mstatus+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
               c.s.executeUpdate(query);
               setVisible(false);
               new SignupTwo(formno).setVisible(true);
         }
        }
        catch (Exception e){
            System.out.println(e);
        }
       }


    public static void main(String[] args) {
        new SignupOne();
    }
}
