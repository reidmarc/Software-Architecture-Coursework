package Mobile_Phone;

import Headquarters.PatientAndIncidentReport;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MP_APP_Layer implements MP_APP_Layer_Interface
{
    // The underlying data layer this application layer sits upon
    private MP_DATA_Layer dataLayer;
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public MP_APP_Layer(MP_DATA_Layer dataLayer)
    {
        this.dataLayer = dataLayer;
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean patientAndIncidentReportUpdated(String firstName, String surName, String dateOfBirth, int nhsRegNoRef, String street, String cityCounty, String postCode, int incidentReportNo, String medCon, String responder, String diagnosis, String date, String location, String actionTaken, long responseDuration)
    {
        PatientAndIncidentReport patientAndIncidentReport = new PatientAndIncidentReport(firstName, surName, dateOfBirth, nhsRegNoRef, street, cityCounty, postCode, incidentReportNo, medCon, responder, diagnosis, date, location, actionTaken, responseDuration);

        return dataLayer.patientAndIncidentReportUpdated(patientAndIncidentReport);
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public void startServer(JTextField firstNameTxt, JTextField surNameTxt, JTextField dateOfBirthTxt, JTextField nhsRegNoTxt, JTextField streetTxt, JTextField cityCountyTxt, JTextField postcodeTxt, JTextField reportNoTxt, JTextField medConTxt, JTextField currentDateTxt, JTextField startTimeTxt)
    {
        try
        {
            int serverPort = 7898;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            System.out.println("Server ready");

            while (true)
            {
                Socket clientSocket = listenSocket.accept();
                MP_Connection c = new MP_Connection(clientSocket, firstNameTxt, surNameTxt, dateOfBirthTxt, nhsRegNoTxt, streetTxt, cityCountyTxt, postcodeTxt, reportNoTxt, medConTxt, currentDateTxt, startTimeTxt);
            }
        }
        catch (IOException e) {
            System.out.println("Listen: " + e.getMessage());
        }
    }
}
