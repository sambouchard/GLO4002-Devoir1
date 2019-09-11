package devoir1;

import java.util.LinkedList;

public interface HealthCenter {
    
    void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom);

    LinkedList<String> getMainWaitingList();

    void setMainWaitingList(LinkedList<String> waitingList);

    String getFirstNameInMainWaitingList();

    TriageType getTriageType();

    void setTriageType(TriageType triageType);

}
