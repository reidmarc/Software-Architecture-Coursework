package Regional_Hospital;


import Database.Database_DATA_Layer_Interface;
import Headquarters.PatientAndIncidentReport;
import Headquarters.Patient;
import java.io.*;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RH_DATA_Layer implements RH_DATA_Layer_Interface
{

    // Default Constructor
    public RH_DATA_Layer()
    {

    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public Patient retrievePatientDetails(Patient patient) throws RemoteException
    {
        try
        {
            // Get the registry from the server (null = local host)
            Registry registry = LocateRegistry.getRegistry(1099);

            // Look up the remote object
            Database_DATA_Layer_Interface stub = (Database_DATA_Layer_Interface) registry.lookup("Database");

            // Returns boolean value, whether the data was inserted to the db or not
            return stub.retrievePatientDetails(patient);
        }
        catch (Exception ex)
        {
            System.out.println("RMI ERROR: " + ex);
            ex.printStackTrace();
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public PatientAndIncidentReport retrieveIncidentDetails(PatientAndIncidentReport patientAndIncidentReport) throws RemoteException
    {
        try
        {
            // Get the registry from the server (null = local host)
            Registry registry = LocateRegistry.getRegistry(1099);

            // Look up the remote object
            Database_DATA_Layer_Interface stub = (Database_DATA_Layer_Interface) registry.lookup("Database");

            // Returns boolean value, whether the data was inserted to the db or not
            return stub.retrieveIncidentDetails(patientAndIncidentReport);
        }
        catch (Exception ex)
        {
            System.out.println("RMI ERROR: " + ex);
            ex.printStackTrace();
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean sendPatientDetailsToMobile(PatientAndIncidentReport patientAndIncidentReport) throws RemoteException
    {
        Socket s = null;

        try
        {
            int serverPort = 7898;
            s = new Socket("127.0.0.1", serverPort);

            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            String firstName = patientAndIncidentReport.getFirstName();
            String surName = patientAndIncidentReport.getSurName();
            String dateOfBirth = patientAndIncidentReport.getDateOfBirth();
            String nhsRegNo = "" + patientAndIncidentReport.getNhsRegNoRef();
            String street = patientAndIncidentReport.getStreet();
            String cityCounty = patientAndIncidentReport.getCityCounty();
            String postcode = patientAndIncidentReport.getPostCode();
            String reportNo = "" + patientAndIncidentReport.getIncidentReportNo();
            String medCon = patientAndIncidentReport.getMedCon();

            out.writeUTF(firstName);
            out.writeUTF(surName);
            out.writeUTF(dateOfBirth);
            out.writeUTF(nhsRegNo);
            out.writeUTF(street);
            out.writeUTF(cityCounty);
            out.writeUTF(postcode);
            out.writeUTF(reportNo);
            out.writeUTF(medCon);

            String data = in.readUTF();

            s.close();

            if (data != null)
            {
                return true;
            }
            else
            {
                return false;
            }

        }
        catch (Exception e)
        {
            System.out.println("Error:"+e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean sendToMobile(String text) throws RemoteException
    {
        Socket s = null;

        try
        {
            int serverPort = 7898;
            s = new Socket("127.0.0.1", serverPort);
            System.out.println("1");

            //ObjectInputStream in = new ObjectInputStream( s.getInputStream());
            //ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            System.out.println("2");

            out.writeUTF(text);

            System.out.println("3");

            String data = in.readUTF();

            System.out.println("4");

            s.close();

            if (data != null)
            {
                return true;
            }
            else
            {
                return false;
            }

        }
        catch (Exception e)
        {
            System.out.println("Error:"+e.getMessage());
            return false;
        }
    }
}
