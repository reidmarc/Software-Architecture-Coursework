package Headquarters;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HQ_DATA_Layer_Interface extends Remote
{
    boolean addPatient(Patient patient) throws RemoteException;

    boolean updatePatient(Patient patient) throws RemoteException;

    boolean checkForPatient(Patient patient) throws RemoteException;

    Patient retrievePatientDetails(Patient patient) throws RemoteException;

    boolean sendRescueRequest(int nhsRegNo) throws RemoteException;

}
