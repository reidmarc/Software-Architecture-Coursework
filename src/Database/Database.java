package Database;

import Headquarters.Patient;

import java.rmi.RemoteException;
import java.sql.*;

public class Database implements Database_Interface
{
    private Connection conn;

    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean addPatient(Patient patient) throws RemoteException
    {
        try
        {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // First we need to establish a connection to the database
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/patients?user=NotJava&password=NotJava");

            // Create a new SQL statement
            Statement statement = conn.createStatement();

            // Build the INSERT statement
            String update = "INSERT INTO PatientRecord (firstName, surName, dateOfBirth, street, cityCounty, postcode) " + "VALUES ('" + patient.getFirstName() + "', '" + patient.getSurName() + "', '" + patient.getDateOfBirth()  + "','" + patient.getStreet()  + "','" + patient.getCityCounty()  + "','" + patient.getPostCode()  + "')";

            // Execute the statement
            statement.executeUpdate(update);

            // Release resources held by the statement
            statement.close();

            // Release resources held by the connection.  This also ensures that the INSERT completes
            conn.close();

            System.out.println("Patient: " + patient.getFirstName() + " " + patient.getSurName() + " added to the DB.");
            return true;

        }
        catch (ClassNotFoundException ex)
        {
            classNotFoundEx(ex);
            return false;
        }
        catch (SQLException ex)
        {
            sqlEx(ex);
            return false;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean updatePatient(Patient patient) throws RemoteException
    {

        try
        {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // First we need to establish a connection to the database
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/patients?user=NotJava&password=NotJava");

            // Create a new SQL statement
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            // Build the Query
            String exists = "SELECT * FROM PatientRecord WHERE nhsRegNo = '" + patient.getNhsRegNo() + "'";

            // Execute the statement
            ResultSet result = statement.executeQuery(exists);

            if (result.isBeforeFirst())
            {

                // We will update the first hit (there should be only one)
                result.first();

                String firstName = patient.getFirstName();
                String surName = patient.getSurName();
                String dateOfBirth = patient.getDateOfBirth();
                String street = patient.getStreet();
                String cityCounty = patient.getCityCounty();
                String postcode = patient.getPostCode();


                // Update the relevant columns in the DB
                result.updateString("firstName", firstName);
                result.updateString("surName", surName);

                result.updateString("dateOfBirth", dateOfBirth);
                result.updateString("street", street);

                result.updateString("cityCounty", cityCounty);
                result.updateString("postcode", postcode);

                // Update the row in the DB
                result.updateRow();
            }
            else
            {
                return false;
            }

            // Release resources held by the statement
            statement.close();


            /*
            // Create a new SQL statement
            Statement statement2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            // Build the Query
            String exists2 = "SELECT * FROM IncidentReport WHERE nhsRegNo = '" + patient.getNhsRegNo() + "'";

            // Execute the statement
            ResultSet result2 = statement.executeQuery(exists);

            if (result2.isBeforeFirst())
            {

                // We will update the first hit (there should be only one)
                result2.first();

                String medCon = patient.getMedCon();

                // Update the relevant columns in the DB
                result2.updateString("medCon", medCon);

                // Update the row in the DB
                result2.updateRow();
            }
            else
            {
                return false;
            }

            // Release resources held by the statement
            statement2.close();
            */

            // Release resources held by the connection.  This also ensures that the INSERT completes
            conn.close();

            System.out.println("Patient: " + patient.getFirstName() + " " + patient.getSurName() + " updated on the DB.");
            return true;

        }
        catch (ClassNotFoundException ex)
        {
            classNotFoundEx(ex);
            return false;
        }
        catch (SQLException ex)
        {
            sqlEx(ex);
            return false;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean checkForPatient(Patient patient) throws RemoteException
    {
        String exists = "";
        boolean theResult = false;

        try
        {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // First we need to establish a connection to the database
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/patients?user=NotJava&password=NotJava");

            // Create a new SQL statement
            Statement statementExist = conn.createStatement();


            if (patient.getNhsRegNo() > 0)
            {
                exists = "SELECT * FROM PatientRecord WHERE nhsRegNo = '" + patient.getNhsRegNo() + "'";
            }
            else if (patient.getFirstName() != null && patient.getSurName() != null && patient.getDateOfBirth() != null)
            {
                // Build the Query
                exists = "SELECT * FROM PatientRecord WHERE firstName = '" + patient.getFirstName() + "' AND surName = '" + patient.getSurName() + "' AND dateOfBirth = '" + patient.getDateOfBirth() + "'";
            }
            else
            {
                return theResult;
            }

            // Execute the statement
            ResultSet result = statementExist.executeQuery(exists);

            while(result.next())
            {
                theResult = true;
            }

            return theResult;
        }
        catch (ClassNotFoundException ex)
        {
            classNotFoundEx(ex);
            return false;
        }
        catch (SQLException ex)
        {
            sqlEx(ex);
            return false;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public Patient retrievePatientDetails(Patient patient) throws RemoteException
    {
        String query = "";

        try
        {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // First we need to establish a connection to the database
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/patients?user=NotJava&password=NotJava");

            // Create a new SQL statement
            Statement statementExist = conn.createStatement();

            // Build the Query
            //String exists = "SELECT * FROM PatientRecord WHERE firstName = '" + patient.getFirstName() + "' AND surName = '" + patient.getSurName() + "' AND dateOfBirth = '" + patient.getDateOfBirth() + "'";


            if (patient.getNhsRegNo() > 0)
            {
                query = "SELECT * FROM PatientRecord WHERE nhsRegNo = '" + patient.getNhsRegNo() + "'";
            }
            else if (patient.getFirstName() != null && patient.getSurName() != null && patient.getDateOfBirth() != null)
            {
                // Build the Query
                query = "SELECT * FROM PatientRecord WHERE firstName = '" + patient.getFirstName() + "' AND surName = '" + patient.getSurName() + "' AND dateOfBirth = '" + patient.getDateOfBirth() + "'";
            }
            else
            {
                return patient;
            }

            // Execute the statement
            ResultSet result = statementExist.executeQuery(query);

            while(result.next())
            {
                patient.setFirstName(result.getString("firstName"));
                patient.setSurName(result.getString("surName"));
                patient.setDateOfBirth(result.getString("dateOfBirth"));
                patient.setNhsRegNo(result.getInt("nhsRegNo"));
                patient.setStreet(result.getString("street"));
                patient.setCityCounty(result.getString("cityCounty"));
                patient.setPostCode(result.getString("postcode"));
            }

            return patient;
        }
        catch (ClassNotFoundException ex)
        {
            classNotFoundEx(ex);
            return null;
        }
        catch (SQLException ex)
        {
            sqlEx(ex);
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------






/*
while (result.next())
                {
                    String firstName = result.getString("firstName");
                    String surName = result.getString("surName");
                    String dateOfBirth = result.getString("dateOfBirth");
                    String nhsRegNo = result.getString("nhsRegNo");
                    String street = result.getString("street");
                    String cityCounty = result.getString("cityCounty");
                    String postcode = result.getString("postcode");
                }
 */
























    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    private void classNotFoundEx(ClassNotFoundException ex)
    {
        System.err.println("Could not load the DB driver.\n" + ex.getMessage());
        ex.printStackTrace();
        System.exit(-1);
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    private void sqlEx(SQLException ex)
    {
        System.err.println("SQL error.\n" + ex.getMessage());
        ex.printStackTrace();
        System.exit(-1);
    }
}
