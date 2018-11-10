package Headquarters;


import Database.Database_Interface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class HQ_DATA_Layer implements Database_Interface
{

    // Default Constructor
    public HQ_DATA_Layer()
    {

    }

    @Override
    public boolean addPatient(Patient patient)
    {
        try
        {
            // Get the registry from the server (null = local host)
            Registry registry = LocateRegistry.getRegistry(null);

            // Look up the remote object
            Database_Interface stub = (Database_Interface) registry.lookup("Database");


            boolean sent = stub.addPatient(patient);

            return sent;
        }
        catch (Exception ex)
        {
            System.out.println("RMI ERROR: " + ex);
            ex.printStackTrace();
            return false;
        }
    }
}
