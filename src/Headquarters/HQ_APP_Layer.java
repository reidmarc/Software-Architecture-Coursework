package Headquarters;

import java.rmi.RemoteException;

public class HQ_APP_Layer implements HQ_APP_Layer_Interface
{
    // The underlying data layer this application layer sits upon
    private HQ_DATA_Layer dataLayer;
    private boolean successful;
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    public HQ_APP_Layer(HQ_DATA_Layer dataLayer)
    {
        this.dataLayer = dataLayer;
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String addPatient(String firstName, String surName, String dateOfBirth, int nhsRegNo, String street, String cityCounty, String postCode, String medCon)
    {

        // Creates the Headquarters.Patient object
        Patient patient = new Patient(firstName, surName, dateOfBirth, nhsRegNo, street, cityCounty, postCode, medCon);

        try
        {
            successful = dataLayer.addPatient(patient);
        }
        catch (RemoteException ex)
        {
            remoteEx(ex);
            successful = false;
        }


        // Either the record was added or not.  Return an appropriate message
        if (successful)
        {
            return "Patient: " + firstName + " " + surName + " added to database.";
        }
        else
        {
            return "Failed to add Patient: " + firstName + " " + surName + ".";
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean checkForPatient(String firstName, String surName, String dateOfBirth)
    {
        // Creates the Headquarters.Patient object
        Patient patient = new Patient(firstName, surName, dateOfBirth);

        try
        {
            successful = dataLayer.checkForPatient(patient);
        }
        catch (RemoteException ex)
        {
            remoteEx(ex);
            successful = false;
        }


        // Either the record was found or not.  Return an appropriate message
        if (successful)
        {
            return true;
            //return "Patient: " + firstName + " " + surName + " exists on the database.";
        }
        else
        {
            return false;
            //return "Patient: " + firstName + " " + surName + " does not exist on the database.";
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean checkForPatient(int nhsRegNo)
    {
        // Creates the Headquarters.Patient object
        Patient patient = new Patient(nhsRegNo);

        try
        {
            successful = dataLayer.checkForPatient(patient);
        }
        catch (RemoteException ex)
        {
            remoteEx(ex);
            successful = false;
        }


        // Either the record was found or not.  Return an appropriate message
        if (successful)
        {
            return true;
            //return "Patient: " + firstName + " " + surName + " exists on the database.";
        }
        else
        {
            return false;
            //return "Patient: " + firstName + " " + surName + " does not exist on the database.";
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String updatePatient(String firstName, String surName, String dateOfBirth, int nhsRegNo, String street, String cityCounty, String postCode)
    {
        return null;
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public Patient retrievePatientDetails(String firstName, String surName, String dateOfBirth)
    {
        // Creates the Patient object
        Patient patient = new Patient(firstName, surName, dateOfBirth);


        try
        {
            return dataLayer.retrievePatientDetails(patient);
        }
        catch (RemoteException ex)
        {
            remoteEx(ex);
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public Patient retrievePatientDetails(int nhsRegNo)
    {
        // Creates the Patient object
        Patient patient = new Patient(nhsRegNo);

        try
        {
            return dataLayer.retrievePatientDetails(patient);
        }
        catch (RemoteException ex)
        {
            remoteEx(ex);
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------














    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    private void remoteEx(RemoteException ex)
    {
        System.err.println("Remote error.\n" + ex.getMessage());
        ex.printStackTrace();
        System.exit(-1);
    }
}
