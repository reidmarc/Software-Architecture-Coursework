package Headquarters;

import java.io.Serializable;

public class PatientAndIncidentReport implements Serializable
{
    static final long serialVersionUID = 2L;

    int incidentReportNo;
    int nhsRegNoRef;
    String medCon;
    String responder;
    String diagnosis;
    String date;
    String location;
    String actionTaken;
    long responseDuration;

    private String firstName;
    private String surName;
    private String dateOfBirth;
    private String street;
    private String cityCounty;
    private String postCode;


    public PatientAndIncidentReport(int nhsRegNoRef)
    {
        this.nhsRegNoRef = nhsRegNoRef;
    }

    public PatientAndIncidentReport(int incidentReportNo, int nhsRegNoRef)
    {
        this.incidentReportNo = incidentReportNo;
        this.nhsRegNoRef = nhsRegNoRef;
    }

    public PatientAndIncidentReport(String firstName, String surName, String dateOfBirth, int nhsRegNoRef, String street, String cityCounty, String postCode, int incidentReportNo, String medCon)
    {
        this.firstName = firstName;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.nhsRegNoRef = nhsRegNoRef;
        this.street = street;
        this.cityCounty = cityCounty;
        this.postCode = postCode;
        this.incidentReportNo = incidentReportNo;
        this.medCon = medCon;
    }

    public PatientAndIncidentReport(String firstName, String surName, String dateOfBirth, int nhsRegNoRef, String street, String cityCounty, String postCode, int incidentReportNo, String medCon, String responder, String diagnosis, String date, String location, String actionTaken, long responseDuration)
    {
        this.firstName = firstName;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.nhsRegNoRef = nhsRegNoRef;
        this.street = street;
        this.cityCounty = cityCounty;
        this.postCode = postCode;
        this.incidentReportNo = incidentReportNo;
        this.medCon = medCon;
        this.responder = responder;
        this.diagnosis = diagnosis;
        this.date = date;
        this.location = location;
        this.actionTaken = actionTaken;
        this.responseDuration = responseDuration;
    }



    /*
    public PatientAndIncidentReport(int incidentReportNo, int nhsRegNoRef, String medCon, String responder, String diagnosis, String date, String location, String actionTaken, long responseDuration)
    {
        this.incidentReportNo = incidentReportNo;
        this.nhsRegNoRef = nhsRegNoRef;
        this.medCon = medCon;
        this.responder = responder;
        this.diagnosis = diagnosis;
        this.date = date;
        this.location = location;
        this.actionTaken = actionTaken;
        this.responseDuration = responseDuration;
    }

    public PatientAndIncidentReport(int incidentReportNo, int nhsRegNoRef, String medCon, String responder, String diagnosis, String date, String location, String actionTaken, long responseDuration, String firstName, String surName, String dateOfBirth, String street, String cityCounty, String postCode)
    {
        this.incidentReportNo = incidentReportNo;
        this.nhsRegNoRef = nhsRegNoRef;
        this.medCon = medCon;
        this.responder = responder;
        this.diagnosis = diagnosis;
        this.date = date;
        this.location = location;
        this.actionTaken = actionTaken;
        this.responseDuration = responseDuration;
        this.firstName = firstName;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.street = street;
        this.cityCounty = cityCounty;
        this.postCode = postCode;
    }
*/




    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public int getIncidentReportNo()
    {
        return incidentReportNo;
    }

    public void setIncidentReportNo(int incidentReportNo)
    {
        this.incidentReportNo = incidentReportNo;
    }

    public int getNhsRegNoRef()
    {
        return nhsRegNoRef;
    }

    public void setNhsRegNoRef(int nhsRegNoRef)
    {
        this.nhsRegNoRef = nhsRegNoRef;
    }

    public String getMedCon()
    {
        return medCon;
    }

    public void setMedCon(String medCon)
    {
        this.medCon = medCon;
    }

    public String getResponder()
    {
        return responder;
    }

    public void setResponder(String responder)
    {
        this.responder = responder;
    }

    public String getDiagnosis()
    {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis)
    {
        this.diagnosis = diagnosis;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getActionTaken()
    {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken)
    {
        this.actionTaken = actionTaken;
    }

    public long getResponseDuration()
    {
        return responseDuration;
    }

    public void setResponseDuration(long responseDuration)
    {
        this.responseDuration = responseDuration;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCityCounty() {
        return cityCounty;
    }

    public void setCityCounty(String cityCounty) {
        this.cityCounty = cityCounty;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
