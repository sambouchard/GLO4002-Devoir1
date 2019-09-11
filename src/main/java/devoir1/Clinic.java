package devoir1;

import java.util.LinkedList;


public class Clinic implements HealthCenter {

    private LinkedList<String> radiologyWaitingList;
    private LinkedList<String> doctorWaitingLIst;
    private TriageType triageType;

    public Clinic(TriageType triageType) {
        setRadiologyWaitingList(new LinkedList<String>());
        setMainWaitingList(new LinkedList<String>());
        setTriageType(triageType);
    }

    @Override
    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        if(this.triageType.equals(TriageType.GRAVITY)){
            gravityTriage(name, gravity, visibleSymptom);
        }
        else if(triageType.equals(TriageType.FIFO)){
            fifoTriage(name, visibleSymptom);
        }


    }

    private void fifoTriage(String name, VisibleSymptom visibleSymptom) {
        if(visibleSymptom.equals(VisibleSymptom.SPRAIN) || visibleSymptom.equals(VisibleSymptom.BROKEN_BONE) ){
            doctorWaitingLIst.addFirst(name);
        }else{
            this.doctorWaitingLIst.add(name);
        }
        if(visibleSymptom.equals(VisibleSymptom.SPRAIN) || visibleSymptom.equals(VisibleSymptom.BROKEN_BONE)){
            this.radiologyWaitingList.add(name);
        }
    }

    private void gravityTriage(String name, int gravity, VisibleSymptom visibleSymptom) {
        if(gravity > 5){
            doctorWaitingLIst.addFirst(name);
        }
        else{
            doctorWaitingLIst.add(name);
        }
        if(visibleSymptom.equals(VisibleSymptom.SPRAIN) || visibleSymptom.equals(VisibleSymptom.BROKEN_BONE)){
            radiologyWaitingList.addFirst(name);
        }
    }

    public LinkedList<String> getRadiologyWaitingList() {
        return radiologyWaitingList;
    }

    public void setRadiologyWaitingList(LinkedList<String> radiologyWaitingList) {
        this.radiologyWaitingList = radiologyWaitingList;
    }

    @Override
    public LinkedList<String> getMainWaitingList() {
        return this.doctorWaitingLIst;
    }

    @Override
    public void setMainWaitingList(LinkedList<String> doctorWaitingLIst){
        this.doctorWaitingLIst = doctorWaitingLIst;
    }

    @Override
    public String getFirstNameInMainWaitingList(){
        return this.doctorWaitingLIst.element();
    }

    public String getFirstNameInRadiologyWaitingLIst() { return  this.radiologyWaitingList.element(); }


    @Override
    public TriageType getTriageType() {
        return triageType;
    }

    @Override
    public void setTriageType(TriageType triageType) {
        this.triageType = triageType;
    }



    // D'autres méthodes peuvent être nécessaires
}
