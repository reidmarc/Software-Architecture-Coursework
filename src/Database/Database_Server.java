package Database;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Database_Server
{
    public  static void main(String args[])
    {
        try
        {
            //Start the registry
            Registry registry = LocateRegistry.createRegistry(1099);

            // Instantiate the concrete class
            Database_DATA_Layer db = new Database_DATA_Layer();

            // Export the stub using the interface specification
            Database_DATA_Layer_Interface stub = (Database_DATA_Layer_Interface) UnicastRemoteObject.exportObject(db, 0);

            //Bind the stub to the name "Account" in the registry
            registry.bind("Database", stub);

            System.out.println("Server ready");

        }
        catch (Exception e)
        {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
