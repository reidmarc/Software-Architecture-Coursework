package Headquarters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HQ_GUI_Layer extends JFrame
{
    private JPanel left, right;

    private String firstName;
    private String surName;
    private String dateOfBirth;
    private String nhsRegNo;
    private String street;
    private String cityCounty;
    private String postCode;
    private String medCon;

    private JTextField firstNameTxt;
    private JTextField surNameTxt;
    private JTextField dateOfBirthTxt;
    private JTextField nhsRegNoTxt;
    private JTextField streetTxt;
    private JTextField cityCountyTxt;
    private JTextField postcodeTxt;
    private JTextField medConTxt;
    private JButton enterBtn;

    private HQ_APP_Layer appLayer;

    public HQ_GUI_Layer (HQ_APP_Layer appLayer)
    {
        this.appLayer = appLayer;

        createWindow();
    }



    private void createWindow()
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

    private void leftPanelContent()
    {
        left = new JPanel();
        left.setLayout(new GridLayout(11,1));

        JLabel patientDetailsLabel = new JLabel("Headquarters.Patient Details");
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

    private void rightPanelContent()
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
                String result = appLayer.addPatient
                        (
                            firstNameTxt.getText(),
                            surNameTxt.getText(),
                            dateOfBirthTxt.getText(),
                            nhsRegNoTxt.getText(),
                            streetTxt.getText(),
                            cityCountyTxt.getText(),
                            postcodeTxt.getText(),
                            medConTxt.getText()
                        );

                popupBox(result);

                clearTextFields();
            }
        });
    }

    private void clearTextFields()
    {
        firstNameTxt.setText("");
        surNameTxt.setText("");
        dateOfBirthTxt.setText("");
        nhsRegNoTxt.setText("");
        streetTxt.setText("");
        cityCountyTxt.setText("");
        postcodeTxt.setText("");
        medConTxt.setText("");
    }

    public void popupBox(String result)
    {
        JOptionPane.showMessageDialog(null, result, "KwikMedical", JOptionPane.INFORMATION_MESSAGE);
    }
}
