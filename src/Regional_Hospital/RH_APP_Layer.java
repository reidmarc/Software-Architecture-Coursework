package Regional_Hospital;



import Headquarters.IncidentReport;
import Headquarters.Patient;

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
    public IncidentReport retrieveIncidentDetails(int nhsRegNo)
    {
        IncidentReport incidentReport = new IncidentReport(nhsRegNo);

        try
        {
            return dataLayer.retrieveIncidentDetails(incidentReport);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
            return incidentReport;
        }
    }
}
