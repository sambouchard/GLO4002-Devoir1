package devoir1;

public class FifoWaitingList extends WaitingList {


    @Override
    void handlePatient(String patientName, int gravity) {
        addLast(patientName);
    }
}
