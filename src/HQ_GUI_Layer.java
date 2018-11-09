import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HQ_GUI_Layer extends JFrame
{
    private static JPanel left, right;

    private static String firstName;
    private static String surName;
    private static String dateOfBirth;
    private static String nhsRegNo;
    private static String street;
    private static String cityCounty;
    private static String postCode;
    private static String medCon;

    private static JTextField firstNameTxt;
    private static JTextField surNameTxt;
    private static JTextField dateOfBirthTxt;
    private static JTextField nhsRegNoTxt;
    private static JTextField streetTxt;
    private static JTextField cityCountyTxt;
    private static JTextField postcodeTxt;
    private static JTextField medConTxt;
    private static JButton enterBtn;




    public static void main(String[] args)
    {
        createWindow();




    }

    private static void createWindow()
    {

        //Create and set up the window.
        JFrame frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,2));
        frame.setResizable(false);

        leftPanelContent();
        rightPanelContent();

        frame.add(left);
        frame.add(right);

        //Display the window
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.toFront();



    }

    private static void leftPanelContent()
    {
        left = new JPanel();
        left.setLayout(new GridLayout(11,1));

        JLabel patientDetailsLabel = new JLabel("Patient Details");
        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel surNameLabel = new JLabel("Surname:");
        JLabel dateOfBirthLabel = new JLabel("Date of Birth:");
        JLabel nhsRegNoLabel = new JLabel("NHS Registration No:");
        JLabel streetLabel = new JLabel("Street:");
        JLabel cityCountyLabel = new JLabel("City / County:");
        JLabel postcodeLabel = new JLabel("Postcode:");
        JLabel medConLabel = new JLabel("Medical Condition:");
        JLabel blankLabel1 = new JLabel(" ");
        JLabel blankLabel2 = new JLabel(" ");


        left.add(patientDetailsLabel);
        left.add(firstNameLabel);
        left.add(surNameLabel);
        left.add(dateOfBirthLabel);
        left.add(nhsRegNoLabel);
        left.add(streetLabel);
        left.add(cityCountyLabel);
        left.add(postcodeLabel);
        left.add(medConLabel);
        left.add(blankLabel1);
        left.add(blankLabel2);
    }

    private static void rightPanelContent()
    {
        right = new JPanel();
        right.setLayout(new GridLayout(11,1));

        JLabel blankLabel1 = new JLabel(" ");
        firstNameTxt = new JTextField();
        surNameTxt = new JTextField();
        dateOfBirthTxt = new JTextField();
        nhsRegNoTxt = new JTextField();
        streetTxt = new JTextField();
        cityCountyTxt = new JTextField();
        postcodeTxt = new JTextField();
        medConTxt = new JTextField();
        JLabel blankLabel2 = new JLabel(" ");
        enterBtn = new JButton("Enter Details");

        right.add(blankLabel1);
        right.add(firstNameTxt);
        right.add(surNameTxt);
        right.add(dateOfBirthTxt);
        right.add(nhsRegNoTxt);
        right.add(streetTxt);
        right.add(cityCountyTxt);
        right.add(postcodeTxt);
        right.add(medConTxt);
        right.add(blankLabel2);
        right.add(enterBtn);

        // Button listener
        enterBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Button Pressed");

                firstName = firstNameTxt.getText();
                surName = surNameTxt.getText();
                dateOfBirth = dateOfBirthTxt.getText();
                nhsRegNo = nhsRegNoTxt.getText();
                street = streetTxt.getText();
                cityCounty = cityCountyTxt.getText();
                postCode = postcodeTxt.getText();
                medCon = medConTxt.getText();

                clearTextFields();

            }
        });
    }

    private static void clearTextFields()
    {
        firstNameTxt.setText("");
        surNameTxt.setText("");
        dateOfBirthTxt.setText("");
        nhsRegNoTxt.setText("");
        streetTxt.setText("");
        cityCountyTxt.setText("");
        postcodeTxt.setText("");
        medConTxt.setText("");

        //infoBox("Data Entered", "Successful");
    }

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "KwikMedical: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
