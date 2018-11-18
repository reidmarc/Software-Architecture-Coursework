package Regional_Hospital;

import Headquarters.IncidentReport;
import Headquarters.Patient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RH_DATA_Layer_Interface extends Remote
{
    Patient retrievePatientDetails(Patient patient) throws RemoteException;

    IncidentReport retrieveIncidentDetails(IncidentReport incidentReport) throws RemoteException;
}
