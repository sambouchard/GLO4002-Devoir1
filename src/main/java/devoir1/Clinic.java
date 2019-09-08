package devoir1;

import java.util.LinkedList;


public class Clinic {

    private LinkedList<String> radiologyWaitingList;
    private LinkedList<String> doctorWaitingLIst;
    private TriageType triageType;

    public Clinic(TriageType triageType) {
        setRadiologyWaitingList(new LinkedList<String>());
        setDoctorWaitingLIst(new LinkedList<String>());
        setTriageType(triageType);
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        if(this.triageType.equals(TriageType.GRAVITY) && gravity == 7 && visibleSymptom.equals(VisibleSymptom.FLU)){
            doctorWaitingLIst.addFirst(name);
            return;
        }
        if(visibleSymptom.equals(VisibleSymptom.SPRAIN) || visibleSymptom.equals(VisibleSymptom.BROKEN_BONE) || gravity ==5){
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


    public TriageType getTriageType() {
        return triageType;
    }

    public void setTriageType(TriageType triageType) {
        this.triageType = triageType;
    }



    // D'autres méthodes peuvent être nécessaires
}
