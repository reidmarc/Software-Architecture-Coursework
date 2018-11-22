package Headquarters;

import Database.Database_DATA_Layer_Interface;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class HQ_DATA_Layer implements HQ_DATA_Layer_Interface
{
    // Default Constructor
    public HQ_DATA_Layer()
    {

    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean addPatient(Patient patient) throws RemoteException
    {
        try
        {
            // Get the registry from the server (null = local host)
            Registry registry = LocateRegistry.getRegistry(null);

            // Look up the remote object
            Database_DATA_Layer_Interface stub = (Database_DATA_Layer_Interface) registry.lookup("Database");

            // Returns boolean value, whether the data was inserted to the db or not
            return stub.addPatient(patient);
        }
        catch (Exception ex)
        {
            System.out.println("RMI ERROR: " + ex);
            ex.printStackTrace();
            return false;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean sendRescueRequest(int nhsRegNo) throws RemoteException
    {
        Socket s = null;

        try
        {
            int serverPort = 7896;
            s = new Socket("127.0.0.1", serverPort);

            DataInputStream in = new DataInputStream( s.getInputStream());
            DataOutputStream out = new DataOutputStream( s.getOutputStream());

            out.writeInt(nhsRegNo);

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
            return false;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean updatePatient(Patient patient) throws RemoteException
    {
        try
        {
            // Get the registry from the server (null = local host)
            Registry registry = LocateRegistry.getRegistry(null);

            // Look up the remote object
            Database_DATA_Layer_Interface stub = (Database_DATA_Layer_Interface) registry.lookup("Database");

            // Returns boolean value, whether the data was inserted to the db or not
            return stub.updatePatient(patient);
        }
        catch (Exception ex)
        {
            System.out.println("RMI ERROR: " + ex);
            ex.printStackTrace();
            return false;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean checkForPatient(Patient patient) throws RemoteException
    {
        try
        {
            // Get the registry from the server (null = local host)
            Registry registry = LocateRegistry.getRegistry(1099);


            // Look up the remote object
            Database_DATA_Layer_Interface stub = (Database_DATA_Layer_Interface) registry.lookup("Database");

            // Returns boolean value, whether the data was inserted to the db or not
            return stub.checkForPatient(patient);
        }
        catch (Exception ex)
        {
            System.out.println("RMI ERROR: " + ex);
            ex.printStackTrace();
            return false;
        }
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
}
