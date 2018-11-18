package Regional_Hospital;



import Headquarters.IncidentReport;
import Headquarters.Patient;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RH_GUI_Layer implements Runnable
{
    private JPanel outerPanel, outerRightPanel, innerLeftPanel, innerRightPanel;
    private JTextField firstNameTxt;
    private JTextField surNameTxt;
    private JTextField dateOfBirthTxt;
    private JTextField nhsRegNoTxt;
    private JTextField streetTxt;
    private JTextField cityCountyTxt;
    private JTextField postcodeTxt;
    private JTextField reportNoTxt;
    private JTextField medConTxt;
    private JTextField responderTxt;
    private JTextField diagnosisTxt;
    private JTextField currentDateTxt;
    private JTextField locationTxt;
    private JTextField actionTakenTxt;
    private JTextField responseDurationTxt;

    private JButton sendDetailsBtn, forwardsBtn, backwardsBtn;


    private RH_APP_Layer appLayer;


    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public RH_GUI_Layer (RH_APP_Layer appLayer)
    {
        this.appLayer = appLayer;

        createWindow();
        run();

    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    public void run()
    {
        try
        {
            int serverPort = 7896;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            System.out.println("Server ready");

            while(true)
            {
                Socket clientSocket = listenSocket.accept();
                Connection c = new Connection(clientSocket, nhsRegNoTxt);
            }
        }
        catch(IOException e)
        {
            System.out.println("Listen: " + e.getMessage());
        }
    }

    private void createWindow()
    {
        UIManager.getLookAndFeelDefaults().put("defaultFont", new Font("Arial", Font.PLAIN, 12));

        //Create and set up the window.
        JFrame frame = new JFrame("Regional Hospital GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new GridLayout(2,1, 10, 10));
        frame.setLayout(new GridLayout(1,2));
        frame.setResizable(false);

        outerPanelContent();
        innerRightPanelContent();
        innerLeftPanelContent();

        outerPanel.add(innerLeftPanel);
        outerPanel.add(innerRightPanel);

        frame.add(outerPanel);


        //Display the window
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.toFront();


    }

    private void innerLeftPanelContent()
    {
        innerLeftPanel = new JPanel();
        innerLeftPanel.setLayout(new GridLayout(10,2,1,1));


        JLabel blankLabel1 = new JLabel(" ");
        JLabel blankLabel2 = new JLabel(" ");
        JLabel blankLabel3 = new JLabel(" ");


        JLabel patientDetailsLabel = new JLabel("    Patient Details");
        JLabel firstNameLabel = new JLabel("    First Name:");
        JLabel surNameLabel = new JLabel("    Surname:");
        JLabel dateOfBirthLabel = new JLabel("    Date of Birth:");
        JLabel nhsRegNoLabel = new JLabel("    NHS Registration No:    ");
        JLabel streetLabel = new JLabel("    Street:");
        JLabel cityCountyLabel = new JLabel("    City / County:");
        JLabel postcodeLabel = new JLabel("    Postcode:");



        firstNameTxt = new JTextField();
        surNameTxt = new JTextField();
        dateOfBirthTxt = new JTextField();
        nhsRegNoTxt = new JTextField();
        streetTxt = new JTextField();
        cityCountyTxt = new JTextField();
        postcodeTxt = new JTextField();
        backwardsBtn = new JButton("<<<");
        forwardsBtn = new JButton(">>>");


        firstNameTxt.setEditable(false);
        surNameTxt.setEditable(false);
        dateOfBirthTxt.setEditable(false);
        nhsRegNoTxt.setEditable(false);
        streetTxt.setEditable(false);
        cityCountyTxt.setEditable(false);
        postcodeTxt.setEditable(false);

        innerLeftPanel.add(patientDetailsLabel);
        innerLeftPanel.add(blankLabel1);
        innerLeftPanel.add(firstNameLabel);
        innerLeftPanel.add(firstNameTxt);
        innerLeftPanel.add(surNameLabel);
        innerLeftPanel.add(surNameTxt);
        innerLeftPanel.add(dateOfBirthLabel);
        innerLeftPanel.add(dateOfBirthTxt);
        innerLeftPanel.add(nhsRegNoLabel);
        innerLeftPanel.add(nhsRegNoTxt);
        innerLeftPanel.add(streetLabel);
        innerLeftPanel.add(streetTxt);
        innerLeftPanel.add(cityCountyLabel);
        innerLeftPanel.add(cityCountyTxt);
        innerLeftPanel.add(postcodeLabel);
        innerLeftPanel.add(postcodeTxt);
        innerLeftPanel.add(blankLabel2);
        innerLeftPanel.add(blankLabel3);
        innerLeftPanel.add(backwardsBtn);
        innerLeftPanel.add(forwardsBtn);


        nhsRegNoTxt.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                Patient patient = appLayer.retrievePatientDetails(Integer.parseInt(nhsRegNoTxt.getText()));

                firstNameTxt.setText(patient.getFirstName());
                surNameTxt.setText(patient.getSurName());
                dateOfBirthTxt.setText(patient.getDateOfBirth());
                streetTxt.setText(patient.getStreet());
                cityCountyTxt.setText(patient.getCityCounty());
                postcodeTxt.setText(patient.getPostCode());


                IncidentReport incidentReport = appLayer.retrieveIncidentDetails(Integer.parseInt(nhsRegNoTxt.getText()));

                reportNoTxt.setText("" + incidentReport.getIncidentReportNo());
                medConTxt.setText(incidentReport.getMedCon());
                //responderTxt.setText(incidentReport.getResponder());
                //diagnosisTxt.setText(incidentReport.getDiagnosis());
                //currentDateTxt.setText(incidentReport.getDate());
                //locationTxt.setText(incidentReport.getLocation());
                //actionTakenTxt.setText(incidentReport.getActionTaken());
                //responseDurationTxt.setText("" + incidentReport.getResponseDuration());

            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
            }
        });
    }

    private void innerRightPanelContent()
    {
        innerRightPanel = new JPanel();
        innerRightPanel.setLayout(new GridLayout(10,2,1,1));

        JLabel blankLabel1 = new JLabel(" ");
        JLabel blankLabel2 = new JLabel(" ");
        JLabel blankLabel3 = new JLabel(" ");
        JLabel blankLabel4 = new JLabel(" ");


        JLabel incidentDetailsLabels = new JLabel("    Incident Details");
        JLabel reportNoLabel = new JLabel("    Report No: ");
        JLabel medConLabel = new JLabel("    Medical Condition: ");
        JLabel responderLabel = new JLabel("    Responder: ");
        JLabel diagnosisLabel = new JLabel("    Diagnosis: ");
        JLabel currentDateLabel = new JLabel("    Date: ");
        JLabel locationLabel = new JLabel("    Location: ");
        JLabel actionTakenLabel = new JLabel("    Action Taken: ");
        JLabel responseDurationLabel = new JLabel("    Response Duration: ");


        reportNoTxt = new JTextField();
        medConTxt = new JTextField();
        responderTxt = new JTextField();
        diagnosisTxt = new JTextField();
        currentDateTxt = new JTextField();
        locationTxt = new JTextField();
        actionTakenTxt = new JTextField();
        responseDurationTxt = new JTextField();
        sendDetailsBtn = new JButton("Send Details");



        reportNoTxt.setEditable(false);
        medConTxt.setEditable(false);
        responderTxt.setEditable(false);
        diagnosisTxt.setEditable(false);
        currentDateTxt.setEditable(false);
        locationTxt.setEditable(false);
        actionTakenTxt.setEditable(false);
        responseDurationTxt.setEditable(false);

        innerRightPanel.add(incidentDetailsLabels);
        innerRightPanel.add(blankLabel1);
        innerRightPanel.add(reportNoLabel);
        innerRightPanel.add(reportNoTxt);
        innerRightPanel.add(medConLabel);
        innerRightPanel.add(medConTxt);
        innerRightPanel.add(responderLabel);
        innerRightPanel.add(responderTxt);
        innerRightPanel.add(diagnosisLabel);
        innerRightPanel.add(diagnosisTxt);
        innerRightPanel.add(currentDateLabel);
        innerRightPanel.add(currentDateTxt);
        innerRightPanel.add(locationLabel);
        innerRightPanel.add(locationTxt);
        innerRightPanel.add(actionTakenLabel);
        innerRightPanel.add(actionTakenTxt);
        innerRightPanel.add(responseDurationLabel);
        innerRightPanel.add(responseDurationTxt);

        innerRightPanel.add(blankLabel3);
        innerRightPanel.add(sendDetailsBtn);

        sendDetailsBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {



            }
        });


    }


    private void outerPanelContent()
    {
        outerPanel = new JPanel();
        outerPanel.setLayout(new GridLayout(1,2));



    }




}
