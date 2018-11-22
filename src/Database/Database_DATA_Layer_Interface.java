package Database;

import Headquarters.PatientAndIncidentReport;
import Headquarters.Patient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Database_DATA_Layer_Interface extends Remote
{
    boolean addPatient(Patient patient) throws RemoteException;

    boolean updatePatient(Patient patient) throws RemoteException;

    boolean checkForPatient(Patient patient) throws RemoteException;

    Patient retrievePatientDetails(Patient patient) throws RemoteException;

    PatientAndIncidentReport retrieveIncidentDetails(PatientAndIncidentReport patientAndIncidentReport) throws RemoteException;

    boolean updatePatientAndIncidentReport(PatientAndIncidentReport patientAndIncidentReport) throws RemoteException;
}
