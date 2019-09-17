package devoir1;

public class GravityWaitingList extends  WaitingList {


    @Override
    void handlePatient(String patientName, int gravity) {
        if (gravity > 5) {
            addFirst(patientName);
        } else {
            addLast(patientName);
        }
    }
}
