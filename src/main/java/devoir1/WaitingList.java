package devoir1;

import java.util.LinkedList;

public abstract class WaitingList {
    private LinkedList<String> list = new LinkedList<String>();

    void handlePatient(String Patient, int gravity){}

    public String getFirstPatient() {
        return this.list.element();
    }

    public String getLastPatient(){
        return this.list.getLast();
    }

    public boolean containPatient(String patientName) {
        return this.list.contains(patientName);
    }

    protected void addFirst(String patientName) {
        this.list.addFirst(patientName);
    }

    protected void addLast(String patientName) {
        this.list.addLast(patientName);
    }

}
