package Regional_Hospital;



import Headquarters.PatientAndIncidentReport;
import Headquarters.Patient;
import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;


public class RH_APP_Layer implements RH_APP_Layer_Interface
{
    // The underlying data layer this application layer sits upon
    private RH_DATA_Layer dataLayer;
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public RH_APP_Layer(RH_DATA_Layer dataLayer)
    {
        this.dataLayer = dataLayer;
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public Patient retrievePatientDetails(int nhsRegNo)
    {
        Patient patient = new Patient(nhsRegNo);

        try
        {
            return dataLayer.retrievePatientDetails(patient);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
            return patient;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public PatientAndIncidentReport retrieveIncidentDetails(int nhsRegNo)
    {
        PatientAndIncidentReport patientAndIncidentReport = new PatientAndIncidentReport(nhsRegNo);

        try
        {
            return dataLayer.retrieveIncidentDetails(patientAndIncidentReport);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
            return patientAndIncidentReport;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean sendPatientDetailsToMobile(String firstName, String surName, String dateOfBirth, int nhsRegNoRef, String street, String cityCounty, String postCode, int incidentReportNo, String medCon)
    {
        PatientAndIncidentReport patientAndIncidentReport  = new PatientAndIncidentReport (firstName, surName, dateOfBirth, nhsRegNoRef, street, cityCounty, postCode, incidentReportNo, medCon);

        try
        {
            return dataLayer.sendPatientDetailsToMobile(patientAndIncidentReport);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public boolean sendPatientDetailsToMobile(int incidentReportNo, int nhsRegNo)
    {
        PatientAndIncidentReport patientAndIncidentReport  = new PatientAndIncidentReport (incidentReportNo, nhsRegNo);

        try
        {
            return dataLayer.sendPatientDetailsToMobile(patientAndIncidentReport);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public void startServer(JTextField nhsRegNoTxt)
    {
        try
        {
            int serverPort = 7896;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            System.out.println("Server ready");

            while(true)
            {
                Socket clientSocket = listenSocket.accept();
                RH_Connection c = new RH_Connection(clientSocket, nhsRegNoTxt);
            }
        }
        catch(IOException e)
        {
            System.out.println("Listen: " + e.getMessage());
        }
    }
}
