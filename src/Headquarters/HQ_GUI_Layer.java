package Headquarters;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HQ_GUI_Layer extends JFrame
{
    private JPanel left, right, top, bottom;
    private JScrollPane scrollPane;

    /*
    private String firstName;
    private String surName;
    private String dateOfBirth;
    private String nhsRegNo;
    private String street;
    private String cityCounty;
    private String postCode;
    private String medCon;
    */

    private JTextField firstNameTxt;
    private JTextField surNameTxt;
    private JTextField nhsRegNoTxt;
    private JTextField streetTxt;
    private JTextField cityCountyTxt;
    private JTextField postcodeTxt;
    private JTextField medConTxt;
    private JButton clearBtn, checkBtn, addBtn, updateBtn;
    private JTextArea descriptionTxtArea;
    private JDateChooser dateOfBirthPicker;

    private boolean result = false;
    private Patient patient = new Patient();
    private Validation validation;

    private HQ_APP_Layer appLayer;
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public HQ_GUI_Layer (HQ_APP_Layer appLayer)
    {
        this.appLayer = appLayer;

        validation = new Validation();

        createWindow();
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    private void createWindow()
    {
        UIManager.getLookAndFeelDefaults().put("defaultFont", new Font("Arial", Font.PLAIN, 12));

        //Create and set up the window.
        JFrame frame = new JFrame("HQ GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new GridLayout(2,1, 10, 10));
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);

        leftPanelContent();
        rightPanelContent();
        bottomPanel();

        top = new JPanel();
        top.setLayout(new GridLayout(1,2));

        top.add(left);
        top.add(right);
        frame.add(top);
        frame.add(bottom);

        //Display the window
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.toFront();

        resetGUI();
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    private void leftPanelContent()
    {
        left = new JPanel();
        left.setLayout(new GridLayout(12,1));

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
        checkBtn = new JButton("Check for Patient");
        clearBtn = new JButton("Clear Details");

        patientDetailsLabel.setFont(new Font("Arial", Font.BOLD, 16));

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
        left.add(checkBtn);
        left.add(clearBtn);

        clearBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                resetGUI();
            }
        });


        checkBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // IF All fields are empty
                if (firstNameTxt.getText().equals("") || surNameTxt.getText().equals("") || ((JTextField)dateOfBirthPicker.getDateEditor().getUiComponent()).getText().equals(""))
                {
                    descriptionTxtArea.setText("You must enter the following fields to check if the Patient is on the database:\n\nFirst Name\nSurname\nDate of Birth\nNHS Reg No (can be blank if unknown)");
                }
                // Else they are not all empty
                else
                {
                    if
                    (
                        validation.isItOnlyCharacters(firstNameTxt.getText()) &&
                        validation.isItOnlyCharacters(surNameTxt.getText()) &&
                        validation.isItOnlyCharacters(cityCountyTxt.getText()) &&
                        validation.isItOnlyNumbersAndCharacters(streetTxt.getText()) &&
                        validation.isItOnlyNumbersAndCharacters(postcodeTxt.getText()) &&
                        validation.isItOnlyNumeric(nhsRegNoTxt.getText())
                    )
                    {
                        System.out.println("First Name Validation Passed");


                        // IF the Patients nhsRegNo has been entered
                        if (!nhsRegNoTxt.getText().equals(""))
                        {
                            // Takes the string value for nhsRegNo converts it to an int then passes it to the app layer
                            result = appLayer.checkForPatient(Integer.parseInt(nhsRegNoTxt.getText()));


                            if (result)
                            {
                                patient = appLayer.retrievePatientDetails
                                        (
                                                Integer.parseInt(nhsRegNoTxt.getText())
                                        );

                                firstNameTxt.setText(patient.getFirstName());
                                surNameTxt.setText(patient.getSurName());
                                ((JTextField)dateOfBirthPicker.getDateEditor().getUiComponent()).setText(patient.getDateOfBirth());
                                //dateOfBirthTxt.setText(patient.getDateOfBirth()); /////////////////////////////////////////////////////////////////////
                                nhsRegNoTxt.setText("" + patient.getNhsRegNo());
                                streetTxt.setText(patient.getStreet());
                                cityCountyTxt.setText(patient.getCityCounty());
                                postcodeTxt.setText(patient.getPostCode());

                                descriptionTxtArea.setText("Patient found by NHS Reg No\n\nPlease check the Patients details stored and then \nenter the Patients medical condition then press Update Patient Record");
                                updateBtn.setEnabled(true);
                                nhsRegNoTxt.setEditable(false);
                                medConTxt.setEditable(true);

                            }
                            else
                            {
                                descriptionTxtArea.setText("Patient could not be found by the NHS Reg No entered.\nPlease try again leaving the NHS Reg No field blank");
                                nhsRegNoTxt.setText("");
                                nhsRegNoTxt.setEditable(false);
                            }


                        }
                        // ELSE no nhsRegNo has been entered
                        else
                        {
                            result = appLayer.checkForPatient
                                    (
                                            firstNameTxt.getText(),
                                            surNameTxt.getText(),
                                            ((JTextField)dateOfBirthPicker.getDateEditor().getUiComponent()).getText()
                                            //dateOfBirthTxt.getText() ////////////////////////////////////////////////////////
                                    );


                            if (result)
                            {
                                // GET DETAILS AND DISPLAY THEM

                                patient = appLayer.retrievePatientDetails
                                        (
                                                firstNameTxt.getText(),
                                                surNameTxt.getText(),
                                                ((JTextField)dateOfBirthPicker.getDateEditor().getUiComponent()).getText()
                                                //dateOfBirthTxt.getText() ///////////////////////////////////////////////////////////////
                                        );

                                firstNameTxt.setText(patient.getFirstName());
                                surNameTxt.setText(patient.getSurName());

                                ((JTextField)dateOfBirthPicker.getDateEditor().getUiComponent()).setText(patient.getDateOfBirth());
                                //dateOfBirthTxt.setText(patient.getDateOfBirth()); ///////////////////////////////////////////////////////////
                                nhsRegNoTxt.setText("" + patient.getNhsRegNo());
                                streetTxt.setText(patient.getStreet());
                                cityCountyTxt.setText(patient.getCityCounty());
                                postcodeTxt.setText(patient.getPostCode());

                                nhsRegNoTxt.setEditable(false);
                                descriptionTxtArea.setText("Please enter the Patients medical condition\n\nThen click the Update Patient Record button.");
                                updateBtn.setEnabled(true);
                                medConTxt.setEditable(true);

                            }
                            else
                            {
                                descriptionTxtArea.setText("Patient not found on the database\n\nPlease enter all the details then add Patient Record button.");
                                nhsRegNoTxt.setEditable(false);
                                addBtn.setEnabled(true);
                                medConTxt.setEditable(true);
                            }
                        }

                    }
                    else
                    {
                        descriptionTxtArea.setText("Please check the values you are entering are correct.");
                        System.out.println("First Name Validation FAILED");
                    }


                }
            }
        });
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    private void rightPanelContent()
    {
        right = new JPanel();
        right.setLayout(new GridLayout(12,1));

        JLabel blankLabel1 = new JLabel(" ");
        firstNameTxt = new JTextField();
        surNameTxt = new JTextField();

        dateOfBirthPicker = new JDateChooser();
        dateOfBirthPicker.setDateFormatString("yyyy-MM-dd");

        nhsRegNoTxt = new JTextField();
        streetTxt = new JTextField();
        cityCountyTxt = new JTextField();
        postcodeTxt = new JTextField();
        medConTxt = new JTextField();
        JLabel blankLabel2 = new JLabel(" ");
        addBtn = new JButton("Add Patient Record");
        updateBtn = new JButton("Update Patient Record");

        right.add(blankLabel1);
        right.add(firstNameTxt);
        right.add(surNameTxt);
        right.add(dateOfBirthPicker);
        right.add(nhsRegNoTxt);
        right.add(streetTxt);
        right.add(cityCountyTxt);
        right.add(postcodeTxt);
        right.add(medConTxt);
        right.add(blankLabel2);
        right.add(addBtn);
        right.add(updateBtn);

        addBtn.setEnabled(false);
        updateBtn.setEnabled(false);
        medConTxt.setEditable(false);



        addBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // VALIDATE MED CON

                String result = appLayer.addPatient
                (
                        firstNameTxt.getText(),
                        surNameTxt.getText(),
                        ((JTextField)dateOfBirthPicker.getDateEditor().getUiComponent()).getText(),
                        streetTxt.getText(),
                        cityCountyTxt.getText(),
                        postcodeTxt.getText(),
                        medConTxt.getText()
                );

                popupBox(result);


                Patient patient = appLayer.retrievePatientDetails
                        (
                                firstNameTxt.getText(),
                                surNameTxt.getText(),
                                ((JTextField)dateOfBirthPicker.getDateEditor().getUiComponent()).getText()
                        );

                if (appLayer.sendRescueRequest
                        (
                                patient.getNhsRegNo()
                        ))
                {
                    popupBox("Rescue Request Sent");
                }
                else
                {
                    popupBox("Rescue Request NOT Sent");
                }
                resetGUI();
            }
        });


        updateBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // VALIDATE MED CON



                String result = appLayer.updatePatient
                        (
                                firstNameTxt.getText(),
                                surNameTxt.getText(),
                                ((JTextField)dateOfBirthPicker.getDateEditor().getUiComponent()).getText(),
                                Integer.parseInt(nhsRegNoTxt.getText()),
                                streetTxt.getText(),
                                cityCountyTxt.getText(),
                                postcodeTxt.getText(),
                                medConTxt.getText()
                        );

                popupBox(result);

                if (appLayer.sendRescueRequest
                        (
                            Integer.parseInt(nhsRegNoTxt.getText())
                        ))
                {
                    popupBox("Rescue Request Sent");
                }
                else
                {
                    popupBox("Rescue Request NOT Sent");
                }

                resetGUI();
            }
        });
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    private void bottomPanel()
    {
        bottom = new JPanel();
        bottom.setLayout(new GridLayout(1,1));

        descriptionTxtArea = new JTextArea();
        descriptionTxtArea.setLineWrap(true);
        descriptionTxtArea.setWrapStyleWord(true);
        descriptionTxtArea.setEditable(false);

        scrollPane = new JScrollPane(descriptionTxtArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(400, 315));

        bottom.add(scrollPane);

        descriptionTxtArea.setText("Please enter the Patients details.\nYou must enter the following fields to check if the Patient is on the database:\n\nFirst Name\nSurname\nDate of Birth\nNHS Reg No (can be blank if unknown)");
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    private void resetGUI()
    {
        firstNameTxt.setText("");
        surNameTxt.setText("");
        ((JTextField)dateOfBirthPicker.getDateEditor().getUiComponent()).setText("");
        nhsRegNoTxt.setText("");
        streetTxt.setText("");
        cityCountyTxt.setText("");
        postcodeTxt.setText("");
        medConTxt.setText("");

        descriptionTxtArea.setText("");

        firstNameTxt.setEditable(true);
        surNameTxt.setEditable(true);
        //dateOfBirthTxt.setEditable(true);
        nhsRegNoTxt.setEditable(true);
        streetTxt.setEditable(true);
        cityCountyTxt.setEditable(true);
        postcodeTxt.setEditable(true);
        medConTxt.setEditable(false);


        checkBtn.setEnabled(true);
        addBtn.setEnabled(false);
        updateBtn.setEnabled(false);

        descriptionTxtArea.setText("Please enter the Patients details.\nYou must enter the following fields to check if the Patient is on the database:\n\nFirst Name\nSurname\nDate of Birth\nNHS Reg No ");

    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    private void popupBox(String result)
    {
        JOptionPane.showMessageDialog(null, result, "KwikMedical", JOptionPane.INFORMATION_MESSAGE);
    }
}
