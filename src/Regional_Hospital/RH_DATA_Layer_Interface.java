package Regional_Hospital;

import Headquarters.PatientAndIncidentReport;
import Headquarters.Patient;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RH_DATA_Layer_Interface extends Remote
{
    Patient retrievePatientDetails(Patient patient) throws RemoteException;

    PatientAndIncidentReport retrieveIncidentDetails(PatientAndIncidentReport patientAndIncidentReport) throws RemoteException;

    boolean sendPatientDetailsToMobile(PatientAndIncidentReport patientAndIncidentReport) throws RemoteException;

    boolean sendToMobile(String text) throws RemoteException;
}
