package Headquarters;


import Database.Database_Interface;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class HQ_DATA_Layer implements Database_Interface
{
    // Default Constructor
    public HQ_DATA_Layer()
    {

    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean addPatient(Patient patient)  throws RemoteException
    {
        try
        {
            // Get the registry from the server (null = local host)
            Registry registry = LocateRegistry.getRegistry(null);

            // Look up the remote object
            Database_Interface stub = (Database_Interface) registry.lookup("Database");

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
    public boolean checkForPatient(Patient patient) throws RemoteException
    {
        try
        {
            // Get the registry from the server (null = local host)
            Registry registry = LocateRegistry.getRegistry(null);


            // Look up the remote object
            Database_Interface stub = (Database_Interface) registry.lookup("Database");

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
            Registry registry = LocateRegistry.getRegistry(null);

            // Look up the remote object
            Database_Interface stub = (Database_Interface) registry.lookup("Database");

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
}
