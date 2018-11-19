package Mobile_Phone;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Duration;
import java.time.LocalTime;

public class MP_GUI_Layer implements Runnable
{
    private JPanel outerPanel, innerLeftPanel, innerRightPanel;
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
    private JTextField startTimeTxt;




    private JButton sendDetailsBtn;

    private MP_APP_Layer appLayer;


    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public MP_GUI_Layer (MP_APP_Layer appLayer)
    {
        this.appLayer = appLayer;
        createWindow();
        run();
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    @Override
    public void run()
    {
        try
        {
            int serverPort = 7898;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            System.out.println("Server ready");

            while(true)
            {
                Socket clientSocket = listenSocket.accept();
                MP_Connection c = new MP_Connection(clientSocket, firstNameTxt, surNameTxt, dateOfBirthTxt, nhsRegNoTxt, streetTxt, cityCountyTxt, postcodeTxt, reportNoTxt, medConTxt, currentDateTxt, startTimeTxt);
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
        JFrame frame = new JFrame("Ambulance GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        startTimeTxt = new JTextField();
        sendDetailsBtn = new JButton("Send Details");


        firstNameTxt.setEditable(false);
        surNameTxt.setEditable(false);
        dateOfBirthTxt.setEditable(false);
        nhsRegNoTxt.setEditable(false);
        streetTxt.setEditable(false);
        cityCountyTxt.setEditable(false);
        postcodeTxt.setEditable(false);
        startTimeTxt.setVisible(false);


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
        innerLeftPanel.add(startTimeTxt);

        innerLeftPanel.add(sendDetailsBtn);
        innerLeftPanel.add(blankLabel3);



        sendDetailsBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                long startTime = Long.parseLong(startTimeTxt.getText());

                Timing timing = new Timing();
                long duration = timing.endTiming(startTime);

                System.out.println("Duration: " + duration + " seconds");



                // WHAT DOES THE BUTTON DO?????

                boolean isUpdated = appLayer.patientAndIncidentReportUpdated
                        (
                            firstNameTxt.getText(),
                            surNameTxt.getText(),
                            dateOfBirthTxt.getText(),
                            Integer.parseInt(nhsRegNoTxt.getText()),
                            streetTxt.getText(),
                            cityCountyTxt.getText(),
                            postcodeTxt.getText(),
                            Integer.parseInt(reportNoTxt.getText()),
                            medConTxt.getText(),
                            responderTxt.getText(),
                            diagnosisTxt.getText(),
                            currentDateTxt.getText(),
                            locationTxt.getText(),
                            actionTakenTxt.getText(),
                            duration
                        );

                if (isUpdated)
                {
                    System.out.println("Success");
                }
                else
                {
                    System.out.println("BAAAAAAAD");
                }

                resetGUI();
            }
        });
    }

    private void resetGUI()
    {
        firstNameTxt.setText("");
        surNameTxt.setText("");
        dateOfBirthTxt.setText("");
        nhsRegNoTxt.setText("");
        streetTxt.setText("");
        cityCountyTxt.setText("");
        postcodeTxt.setText("");
        reportNoTxt.setText("");
        medConTxt.setText("");
        responderTxt.setText("");
        diagnosisTxt.setText("");
        currentDateTxt.setText("");
        locationTxt.setText("");
        actionTakenTxt.setText("");
        startTimeTxt.setText("");

    }

    private void innerRightPanelContent()
    {
        innerRightPanel = new JPanel();
        innerRightPanel.setLayout(new GridLayout(10,2,1,1));

        JLabel blankLabel1 = new JLabel(" ");
        JLabel blankLabel2 = new JLabel(" ");
        JLabel blankLabel3 = new JLabel(" ");

        JLabel incidentDetailsLabels = new JLabel("    Incident Details");
        JLabel reportNoLabel = new JLabel("    Report No: ");
        JLabel medConLabel = new JLabel("    Medical Condition: ");
        JLabel responderLabel = new JLabel("    Responder: ");
        JLabel diagnosisLabel = new JLabel("    Diagnosis: ");
        JLabel currentDateLabel = new JLabel("    Date: ");
        JLabel locationLabel = new JLabel("    Location: ");
        JLabel actionTakenLabel = new JLabel("    Action Taken: ");


        reportNoTxt = new JTextField();
        medConTxt = new JTextField();
        responderTxt = new JTextField();
        diagnosisTxt = new JTextField();
        currentDateTxt = new JTextField();
        locationTxt = new JTextField();
        actionTakenTxt = new JTextField();


        reportNoTxt.setEditable(false);
        medConTxt.setEditable(false);
        currentDateTxt.setEditable(false);


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
        innerRightPanel.add(blankLabel2);
        innerRightPanel.add(blankLabel3);



    }


    private void outerPanelContent()
    {
        outerPanel = new JPanel();
        outerPanel.setLayout(new GridLayout(1,2));
    }
}
