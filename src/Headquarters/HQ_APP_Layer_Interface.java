package Headquarters;

public interface HQ_APP_Layer_Interface
{

    String addPatient(String firstName, String surName, String dateOfBirth, int nhsRegNo, String street, String cityCounty, String postCode, String medCon);

    boolean checkForPatient(String firstName, String surName, String dateOfBirth);

    boolean checkForPatient(int nhsRegNo);

    String updatePatient(String firstName, String surName, String dateOfBirth, int nhsRegNo, String street, String cityCounty, String postCode);

    Patient retrievePatientDetails(String firstName, String surName, String dateOfBirth);

    Patient retrievePatientDetails(int nhsRegNo);

}
