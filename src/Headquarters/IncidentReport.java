package Headquarters;

import java.io.Serializable;

public class IncidentReport implements Serializable
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

    public IncidentReport(int nhsRegNoRef)
    {
        this.nhsRegNoRef = nhsRegNoRef;
    }

    public IncidentReport(int incidentReportNo, int nhsRegNoRef)
    {
        this.incidentReportNo = incidentReportNo;
        this.nhsRegNoRef = nhsRegNoRef;
    }

    public IncidentReport(int incidentReportNo, int nhsRegNoRef, String medCon, String responder, String diagnosis, String date, String location, String actionTaken, long responseDuration)
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
}
