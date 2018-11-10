package Database;

import Headquarters.Patient;

import java.sql.*;

public class Database implements Database_Interface
{
    private Connection conn;

    @Override
    public boolean addPatient(Patient patient)
    {
        try
        {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // First we need to establish a connection to the database
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/patients?user=NotJava&password=NotJava");

            // Create a new SQL statement
            Statement statementExist = conn.createStatement();

            // Build the Query
            String exists = "SELECT * FROM PatientRecord WHERE nhsRegNo = '" + patient.getNhsRegNo() + "'";

            // Execute the statement
            ResultSet result = statementExist.executeQuery(exists);

            if (!result.isBeforeFirst())
            {
                // Release resources held by the statement
                statementExist.close();

                // Create a new SQL statement
                Statement statement = conn.createStatement();

                // Build the INSERT statement
                String update = "INSERT INTO PatientRecord (firstName, surName, dateOfBirth, nhsRegNo, street, cityCounty, postcode, medCon) " + "VALUES ('" + patient.getFirstName() + "', '" + patient.getSurName() + "', '" + patient.getDateOfBirth()  + "', '" + patient.getNhsRegNo() + "','" + patient.getStreet()  + "','" + patient.getCityCounty()  + "','" + patient.getPostCode()  + "','" + patient.getMedCon() + "')";

                // Execute the statement
                statement.executeUpdate(update);

                // Release resources held by the statement
                statement.close();

                // Release resources held by the connection.  This also ensures that the INSERT completes
                conn.close();

                System.out.println("Update successful");
                return true;
            }
            else
            {
                // Release resources held by the statement
                statementExist.close();

                return false;
            }
        }
        catch (ClassNotFoundException cnf)
        {
            System.err.println("Could not load driver");
            System.err.println(cnf.getMessage());
            System.exit(-1);
            return false;
        }
        catch (SQLException sqe)
        {
            System.err.println("Error performing SQL Update");
            System.err.println(sqe.getMessage());
            System.exit(-1);
            return false;
        }
    }
}
