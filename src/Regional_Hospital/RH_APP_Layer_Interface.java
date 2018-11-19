package Regional_Hospital;


import Headquarters.PatientAndIncidentReport;
import Headquarters.Patient;

public interface RH_APP_Layer_Interface
{
    Patient retrievePatientDetails(int nhsRegNo);

    PatientAndIncidentReport retrieveIncidentDetails(int nhsRegNo);

    boolean sendPatientDetailsToMobile(String firstName, String surName, String dateOfBirth, int nhsRegNoRef, String street, String cityCounty, String postCode, int incidentReportNo, String medCon);

    boolean sendToMobile(String text);
}
