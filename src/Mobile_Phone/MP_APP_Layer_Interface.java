package Mobile_Phone;

public interface MP_APP_Layer_Interface
{
    boolean patientAndIncidentReportUpdated(String firstName, String surName, String dateOfBirth, int nhsRegNoRef, String street, String cityCounty, String postCode, int incidentReportNo, String medCon, String responder, String diagnosis, String date, String location, String actionTaken, long responseDuration);
}
