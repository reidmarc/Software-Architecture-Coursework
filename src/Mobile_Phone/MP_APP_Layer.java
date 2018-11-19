package Mobile_Phone;


import Headquarters.PatientAndIncidentReport;

public class MP_APP_Layer implements MP_APP_Layer_Interface
{
    // The underlying data layer this application layer sits upon
    private MP_DATA_Layer dataLayer;

    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public MP_APP_Layer(MP_DATA_Layer dataLayer)
    {
        this.dataLayer = dataLayer;
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean patientAndIncidentReportUpdated(String firstName, String surName, String dateOfBirth, int nhsRegNoRef, String street, String cityCounty, String postCode, int incidentReportNo, String medCon, String responder, String diagnosis, String date, String location, String actionTaken, long responseDuration)
    {
        PatientAndIncidentReport patientAndIncidentReport = new PatientAndIncidentReport(firstName, surName, dateOfBirth, nhsRegNoRef, street, cityCounty, postCode, incidentReportNo, medCon, responder, diagnosis, date, location, actionTaken, responseDuration);

        return dataLayer.patientAndIncidentReportUpdated(patientAndIncidentReport);
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

}
