package devoir1;


public class Clinic extends GravityChecker {

    private WaitingList radiologyWaitingList;
    private WaitingList doctorWaitingLIst;

    public Clinic(TriageType triageType) {
        this.radiologyWaitingList = WaitingListFactory.instantiateWaitingList(triageType);
        this.doctorWaitingLIst = WaitingListFactory.instantiateWaitingList(triageType);
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        if(checkIfGravityIsGreaterThanOne(gravity)){
            this.doctorWaitingLIst.handlePatient(name,gravity);
            if (visibleSymptom.equals(VisibleSymptom.SPRAIN) || visibleSymptom.equals(VisibleSymptom.BROKEN_BONE)) {
                this.radiologyWaitingList.handlePatient(name,gravity);
            }
        }
    }

    public WaitingList getDoctorWaitingLIst() {
        return doctorWaitingLIst;
    }

    public WaitingList getRadiologyWaitingList() {
        return radiologyWaitingList;
    }
}
