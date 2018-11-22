package Mobile_Phone;

import Database.Database_DATA_Layer_Interface;
import Headquarters.PatientAndIncidentReport;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MP_DATA_Layer implements MP_DATA_Layer_Interface
{
    // Default Constructor
    public MP_DATA_Layer()
    {

    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean patientAndIncidentReportUpdated(PatientAndIncidentReport patientAndIncidentReport)
    {
        try
        {
            // Get the registry from the server (null = local host)
            Registry registry = LocateRegistry.getRegistry(null);

            // Look up the remote object
            Database_DATA_Layer_Interface stub = (Database_DATA_Layer_Interface) registry.lookup("Database");

            // Returns boolean value, whether the data was inserted to the db or not
            return stub.updatePatientAndIncidentReport(patientAndIncidentReport);
        }
        catch (Exception ex)
        {
            System.out.println("RMI ERROR: " + ex);
            ex.printStackTrace();
            return false;
        }
    }
}
