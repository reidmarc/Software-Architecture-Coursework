package Headquarters;

public class HQ_KwikMedical
{
    public static void main(String[] args)
    {
        // Creates the data layer
        HQ_DATA_Layer dataLayer = new HQ_DATA_Layer();

        // Creates the application layer, passing in the data layer
        HQ_APP_Layer appLayer = new HQ_APP_Layer(dataLayer);

        // Creates the GUI layer, passing in the app layer
        HQ_GUI_Layer gui = new HQ_GUI_Layer(appLayer);
    }
}
