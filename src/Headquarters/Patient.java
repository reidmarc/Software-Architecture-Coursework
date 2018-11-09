package Headquarters;

import java.io.Serializable;

public class Patient implements Serializable
{
    private String firstName;
    private String surName;
    private String dateOfBirth;
    private String nhsRegNo;
    private String street;
    private String cityCounty;
    private String postCode;
    private String medCon;



    Patient(String firstName, String surName, String dateOfBirth, String nhsRegNo, String street, String cityCounty, String postCode, String medCon)
    {
        this.firstName = firstName;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.nhsRegNo = nhsRegNo;
        this.street = street;
        this.cityCounty = cityCounty;
        this.postCode = postCode;
        this.medCon = medCon;
    }



    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getSurName()
    {
        return surName;
    }

    public void setSurName(String surName)
    {
        this.surName = surName;
    }

    public String getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNhsRegNo()
    {
        return nhsRegNo;
    }

    public void setNhsRegNo(String nhsRegNo)
    {
        this.nhsRegNo = nhsRegNo;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getCityCounty()
    {
        return cityCounty;
    }

    public void setCityCounty(String cityCounty)
    {
        this.cityCounty = cityCounty;
    }

    public String getPostCode()
    {
        return postCode;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

    public String getMedCon()
    {
        return medCon;
    }

    public void setMedCon(String medCon)
    {
        this.medCon = medCon;
    }

    public String toString()
    {
        return "{ " +
                "\"firstName\" : \"" + firstName + "\", " +
                "\"secondName\" : \"" + surName + "\", " +
                "\"dateOfBirth\" : \"" + dateOfBirth + "\", " +
                "\"nhsRegNo\" : \"" + nhsRegNo + "\", " +
                "\"street\" : \"" + street + "\", " +
                "\"cityCounty\" : \"" + cityCounty + "\", " +
                "\"postCode\" : \"" + postCode + "\", " +
                "\"medCon\" : \"" + medCon + "\" }";
    }
}
