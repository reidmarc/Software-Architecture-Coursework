package Database;

import Headquarters.Patient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Database_Interface extends Remote
{
    boolean addPatient(Patient patient) throws RemoteException;
}
