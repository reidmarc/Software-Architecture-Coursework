package Headquarters;

public interface HQ_APP_Layer_Interface
{

    String addPatient(String firstName, String surName, String dateOfBirth, String nhsRegNo, String street, String cityCounty, String postCode, String medCon);

    String checkForPatient(String nhsRegNo);

    String updatePatient(String firstName, String surName, String dateOfBirth, String nhsRegNo, String street, String cityCounty, String postCode);

}
