package Regional_Hospital;


import Headquarters.IncidentReport;
import Headquarters.Patient;

public interface RH_APP_Layer_Interface
{
    Patient retrievePatientDetails(int nhsRegNo);

    IncidentReport retrieveIncidentDetails(int nhsRegNo);
}
