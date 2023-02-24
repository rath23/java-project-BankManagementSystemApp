package como.bankatm;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupTwo extends JFrame implements ActionListener {

    String formnum;
    JTextField pnnum,aadharnum ;

    JComboBox rlgn ,incm, ctgry,qlfctn,occptn ;

    JButton next;

    JRadioButton s_citizen_yes,s_citizen_no,e_account_yes,e_account_no;
   SignupTwo(String formno){
       setLayout(null);

      this.formnum = formno;

       setTitle("NEW ACCOUNT APPLICATION FORM PAGE : 2");

       JLabel Formno = new JLabel("PAGE 2 : ADDITIONAL DETAILS");
       Formno.setFont(new Font("Raleway",Font.BOLD,38));
       Formno.setBounds(130,20,600,40);
       add(Formno);


       JLabel religion = new JLabel("RELIGION : ");
       religion.setFont(new Font("Raleway",Font.BOLD,15));
       religion.setBounds(100,140,100,30);
       add(religion);

       String []val_Religion = new String[]{ "", "Hindu","Muslim","Christian","Sikh","Other" };
        rlgn = new JComboBox(val_Religion);
       rlgn.setFont(new Font("Raleway",Font.BOLD,15));
       rlgn.setBounds(300,140,400,20);
       add(rlgn);

       JLabel category = new JLabel("CATEGORY : ");
       category.setFont(new Font("Raleway",Font.BOLD,15));
       category.setBounds(100,190,200,30);
       add(category);

       String []val_category = new String[]{ "Ganeral","OBC","CS","ST","Other" };
       ctgry = new JComboBox(val_category);
       ctgry.setFont(new Font("Raleway",Font.BOLD,15));
       ctgry.setBounds(300,190,400,20);
       add(ctgry);


       JLabel income = new JLabel("INCOME : ");
       income.setFont(new Font("Raleway",Font.BOLD,15));
       income.setBounds(100,240,200,30);
       add(income);

       String []val_income = new String[]{ "","NULL","<1,50,000","2,50,000","5,50,000","5,50,000+" };
       incm = new JComboBox(val_income);
       incm.setFont(new Font("Raleway",Font.BOLD,15));
       incm.setBounds(300,240,400,20);
       add(incm);

       JLabel qualification = new JLabel("QUALIFICATION : ");
       qualification.setFont(new Font("Raleway",Font.BOLD,15));
       qualification.setBounds(100,290,200,30);
       add(qualification);

       String []val_qualification = new String[]{ "", "Non-Graduate","Graduate","Post-Graduation","Doctrate","Other" };
       qlfctn = new JComboBox(val_qualification);
       qlfctn.setFont(new Font("Raleway",Font.BOLD,15));
       qlfctn.setBounds(300,290,400,20);
       add(qlfctn);

       JLabel occupation = new JLabel("OCCUPATION : ");
       occupation.setFont(new Font("Raleway",Font.BOLD,15));
       occupation.setBounds(100,340,200,30);
       add(occupation);

       String []val_occupation = new String[]{ "Salaried","Self-Employed","Business","Student","Retired","Other" };
       occptn = new JComboBox(val_occupation);
       occptn.setFont(new Font("Raleway",Font.BOLD,15));
       occptn.setBounds(300,340,400,20);
       add(occptn);

       JLabel pannumber = new JLabel("PAN NUMBER :");
       pannumber.setFont(new Font("Raleway",Font.BOLD,15));
       pannumber.setBounds(100,390,200,30);
       add(pannumber);

       pnnum = new JTextField();
       pnnum.setFont(new Font("Raleway",Font.BOLD,15));
       pnnum.setBounds(300,390,400,20);
       add(pnnum);

       JLabel aadhar = new JLabel("AADHAR NUMBER : ");
       aadhar.setFont(new Font("Raleway",Font.BOLD,15));
       aadhar.setBounds(100,440,200,30);
       add(aadhar);

       aadharnum = new JTextField();
       aadharnum.setFont(new Font("Raleway",Font.BOLD,15));
       aadharnum.setBounds(300,440,400,20);
       add(aadharnum);


       JLabel seniorcitizen = new JLabel("SENIOR CITIZEN : ");
       seniorcitizen.setFont(new Font("Raleway",Font.BOLD,15));
       seniorcitizen.setBounds(100,490,200,30);
       add(seniorcitizen);

       s_citizen_yes = new JRadioButton("YES");
       s_citizen_yes.setBounds(340,490,60,30);
       s_citizen_yes.setBackground(Color.white);
       add(s_citizen_yes);

       s_citizen_no = new JRadioButton("NO");
       s_citizen_no.setBounds(490,490,80,30);
       s_citizen_no.setBackground(Color.white);
       add(s_citizen_no);

       ButtonGroup s_citizen = new ButtonGroup();
       s_citizen.add(s_citizen_yes);
       s_citizen.add(s_citizen_no);

       JLabel existingaccount = new JLabel("EXISTING ACCOUNT : ");
       existingaccount.setFont(new Font("Raleway",Font.BOLD,15));
       existingaccount.setBounds(100,540,200,30);
       add(existingaccount);

       e_account_yes = new JRadioButton("YES");
       e_account_yes.setBounds(340,540,60,30);
       e_account_yes.setBackground(Color.white);
       add(e_account_yes);

       e_account_no = new JRadioButton("NO");
       e_account_no.setBounds(490,540,80,30);
       e_account_no.setBackground(Color.white);
       add(e_account_no);

       ButtonGroup exis_account = new ButtonGroup();
       exis_account.add(e_account_yes);
       exis_account.add(e_account_no);



       next = new JButton("NEXT");
       next.setBounds(550,600,70,30);
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
         String formnumber ="" + formnum;
        /* getSelectedItem() helps to get input of JComboBox and getSelectedItem returns am object so we have to typecast it into a string*/
        String religon =(String) rlgn.getSelectedItem();
        String income = (String) incm.getSelectedItem();
        String categary  = (String) ctgry.getSelectedItem();
        String qualification = (String) qlfctn.getSelectedItem();
        String occupation = (String) occptn.getSelectedItem();
        String pan_number = pnnum.getText();
        String aadhar = aadharnum.getText();

        String citizenShip = null;
        if(s_citizen_yes.isSelected()){
            citizenShip="YES";
        }
        else {
            citizenShip="NO";
        }
        String oldAccountStatus = null;
        if(e_account_yes.isSelected()){
            oldAccountStatus="YES";
        }
        else {
            oldAccountStatus="NO";
        }

        try{
           // if (name.equals("")){
            //    JOptionPane.showMessageDialog(null,"Please Enter Name.");
          //  }
          //  else if (fname.equals("")){
         //       JOptionPane.showMessageDialog(null,"Please Enter Father's Name.");
           // }


       //     else {
                Conn c = new Conn();
                /*insert into signup values.... is a DML command*/
               String query = "insert into signuptwo values ('"+formnumber+"', '"+religon+"', '"+categary+"', '"+income+"', '"+qualification+"', '"+occupation+"', '"+pan_number+"', '"+aadhar+"', '"+citizenShip+"', '"+oldAccountStatus+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formnum).setVisible(true);
            }
       // }
        catch (Exception e){
            System.out.println(e);

            }
            }







    public static void main(String[] args) {
 new SignupTwo("");
    }

}
