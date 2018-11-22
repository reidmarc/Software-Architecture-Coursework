package Regional_Hospital;


import java.io.IOException;


public class RH_KwikMedical
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            // Creates the data layer
            RH_DATA_Layer dataLayer = new RH_DATA_Layer();

            // Creates the application layer, passing in the data layer
            RH_APP_Layer appLayer = new RH_APP_Layer(dataLayer);

            // Creates the GUI layer, passing in the app layer
            RH_GUI_Layer gui = new RH_GUI_Layer(appLayer);

        }
        catch (Exception ex)
        {
            System.err.println("Main Error: " + ex);
            ex.printStackTrace();
        }
    }
}
