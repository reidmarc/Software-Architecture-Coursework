package Regional_Hospital;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class RH_Connection extends Thread
{
    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;
    JTextField nhsRegNoTxt;

    public RH_Connection(Socket aClientSocket, JTextField nhsRegNoTxt)
    {
        try
        {
            clientSocket = aClientSocket;
            in = new DataInputStream( clientSocket.getInputStream());
            out = new DataOutputStream( clientSocket.getOutputStream());

            this.nhsRegNoTxt = nhsRegNoTxt;
            this.start();
        }
        catch(IOException e)
        {
            System.out.println("RH_Connection: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void run()
    {
        try
        {
            int nhsRegNo = in.readInt();

            nhsRegNoTxt.setText("" + nhsRegNo);

            System.out.println("Received from HQ");
            out.writeUTF("Received");
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}