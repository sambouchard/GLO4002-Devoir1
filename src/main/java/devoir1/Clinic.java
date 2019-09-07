package devoir1;

import java.util.LinkedList;


public class Clinic {

    private LinkedList<String> radiologyWaitingList;
    private LinkedList<String> doctorWaitingLIst;

    public Clinic() {
        setRadiologyWaitingList(new LinkedList<String>());
        setDoctorWaitingLIst(new LinkedList<String>());
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        if(gravity == 5){
            doctorWaitingLIst.addFirst(name);
        }else{
            this.doctorWaitingLIst.add(name);
        }
        if(visibleSymptom.equals(VisibleSymptom.SPRAIN) || visibleSymptom.equals(VisibleSymptom.BROKEN_BONE)){
            this.radiologyWaitingList.add(name);
        }

    }
    public LinkedList<String> getRadiologyWaitingList() {
        return radiologyWaitingList;
    }

    public void setRadiologyWaitingList(LinkedList<String> radiologyWaitingList) {
        this.radiologyWaitingList = radiologyWaitingList;
    }

    public LinkedList<String> getDoctorWaitingList() {
        return this.doctorWaitingLIst;
    }

    public void setDoctorWaitingLIst(LinkedList<String> doctorWaitingLIst){
        this.doctorWaitingLIst = doctorWaitingLIst;
    }

    public String getFirstNameInDoctorWaitingList(){
        return this.doctorWaitingLIst.element();
    }


    // D'autres méthodes peuvent être nécessaires
}
