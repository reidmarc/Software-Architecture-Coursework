package Mobile_Phone;


import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class MP_Connection extends Thread
{
    private DataOutputStream out;
    private DataInputStream in;

    private String currentDate;
    private Socket clientSocket;
    private JTextField firstNameTxt;
    private JTextField surNameTxt;
    private JTextField dateOfBirthTxt;
    private JTextField nhsRegNoTxt;
    private JTextField streetTxt;
    private JTextField cityCountyTxt;
    private JTextField postcodeTxt;
    private JTextField reportNoTxt;
    private JTextField medConTxt;
    private JTextField currentDateTxt;
    private JTextField startTimeTxt;
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public MP_Connection(Socket aClientSocket, JTextField firstNameTxt, JTextField surNameTxt, JTextField dateOfBirthTxt, JTextField nhsRegNoTxt, JTextField streetTxt, JTextField cityCountyTxt, JTextField postcodeTxt, JTextField reportNoTxt, JTextField medConTxt, JTextField currentDateTxt, JTextField startTimeTxt)
    {
        try
        {
            this.clientSocket = aClientSocket;

            in = new DataInputStream( clientSocket.getInputStream());
            out = new DataOutputStream( clientSocket.getOutputStream());

            currentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

            this.firstNameTxt = firstNameTxt;
            this.surNameTxt = surNameTxt;
            this.dateOfBirthTxt = dateOfBirthTxt;
            this.nhsRegNoTxt = nhsRegNoTxt;
            this.streetTxt = streetTxt;
            this.cityCountyTxt = cityCountyTxt;
            this.postcodeTxt = postcodeTxt;
            this.reportNoTxt = reportNoTxt;
            this.medConTxt = medConTxt;
            this.currentDateTxt = currentDateTxt;
            this.startTimeTxt = startTimeTxt;
            this.start();
        }
        catch (IOException e)
        {
            System.out.println("RH_Connection: " + e.getMessage());
            e.printStackTrace();
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public void run()
    {
        try
        {
            Timing timing = new Timing();
            long startTime = timing.startTiming();

            String firstName = in.readUTF();
            String surName = in.readUTF();
            String dateOfBirth = in.readUTF();
            String nhsRegNo = in.readUTF();
            String street = in.readUTF();
            String cityCounty = in.readUTF();
            String postcode = in.readUTF();
            String reportNo = in.readUTF();
            String medCon = in.readUTF();

            out.writeUTF("Received");

            firstNameTxt.setText(firstName);
            surNameTxt.setText(surName);
            dateOfBirthTxt.setText(dateOfBirth);
            nhsRegNoTxt.setText(nhsRegNo);
            streetTxt.setText(street);
            cityCountyTxt.setText(cityCounty);
            postcodeTxt.setText(postcode);
            reportNoTxt.setText(reportNo);
            medConTxt.setText(medCon);
            currentDateTxt.setText(currentDate);



            startTimeTxt.setText("" + startTime);


        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
