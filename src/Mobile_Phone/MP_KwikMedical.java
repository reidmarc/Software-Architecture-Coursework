package Mobile_Phone;


import java.io.IOException;

public class MP_KwikMedical
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            // Creates the data layer
            MP_DATA_Layer dataLayer = new MP_DATA_Layer();

            // Creates the application layer, passing in the data layer
            MP_APP_Layer appLayer = new MP_APP_Layer(dataLayer);

            // Creates the GUI layer, passing in the app layer
            MP_GUI_Layer gui = new MP_GUI_Layer(appLayer);
        }
        catch (Exception ex)
        {
            System.err.println("Main Error: " + ex);
            ex.printStackTrace();
        }
    }
}
