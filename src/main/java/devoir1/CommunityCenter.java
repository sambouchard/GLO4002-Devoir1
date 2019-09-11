package devoir1;

import java.util.LinkedList;

public class CommunityCenter implements HealthCenter {
    private LinkedList<String> nurseWaitingList;
    private TriageType triageType;

    public CommunityCenter(TriageType triageType){
        setTriageType(triageType);
        setMainWaitingList(new LinkedList<String>());
    }

    @Override
    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        if(this.triageType.equals(TriageType.GRAVITY)){
            gravityTriage(name, gravity);
        }
        else if(triageType.equals(TriageType.FIFO)){
            fifoTriage(name, visibleSymptom);
        }
    }

    private void fifoTriage(String name, VisibleSymptom visibleSymptom) {
        if(visibleSymptom.equals(VisibleSymptom.SPRAIN) || visibleSymptom.equals(VisibleSymptom.BROKEN_BONE)){
            this.nurseWaitingList.addFirst(name);
        }
        else {
            this.nurseWaitingList.add(name);
        }
    }

    private void gravityTriage(String name, int gravity) {
        if(gravity > 5){
            this.nurseWaitingList.addFirst(name);
        }
        else{
            this.nurseWaitingList.add(name);
        }
    }

    @Override
    public LinkedList<String> getMainWaitingList() {
        return this.nurseWaitingList;
    }

    @Override
    public void setMainWaitingList(LinkedList<String> waitingList) {
        this.nurseWaitingList = waitingList;
    }

    @Override
    public String getFirstNameInMainWaitingList() {
        return this.nurseWaitingList.element();
    }

    @Override
    public TriageType getTriageType() {
        return triageType;
    }

    @Override
    public void setTriageType(TriageType triageType) {
        this.triageType = triageType;
    }
}
