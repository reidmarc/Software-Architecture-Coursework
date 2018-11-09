package Headquarters;

public class HQ_APP_Layer implements HQ_APP_Layer_Interface
{
    // The underlying data layer this application layer sits upon
    private HQ_DATA_Layer dataLayer;


    public HQ_APP_Layer(HQ_DATA_Layer dataLayer)
    {
        this.dataLayer = dataLayer;
    }


    @Override
    public String addPatient(String firstName, String surName, String dateOfBirth, String nhsRegNo, String street, String cityCounty, String postCode, String medCon)
    {
        // Creates the Headquarters.Patient object
        Patient patient = new Patient(firstName, surName, dateOfBirth, nhsRegNo, street, cityCounty, postCode, medCon);


        boolean successful = dataLayer.addPatient(patient);


        // Either the record was added or not.  Return an appropriate message
        if (successful)
        {
            return "Headquarters.Patient: " + firstName + " " + surName + " added to database.";
        }
        else
        {
            return "Failed to add Headquarters.Patient: " + firstName + " " + surName + ".";
        }
    }


    @Override
    public String checkForPatient(String nhsRegNo)
    {
        return null;
    }

    @Override
    public String updatePatient(String firstName, String surName, String dateOfBirth, String nhsRegNo, String street, String cityCounty, String postCode)
    {
        return null;
    }













}
