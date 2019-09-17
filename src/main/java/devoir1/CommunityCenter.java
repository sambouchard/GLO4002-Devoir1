package devoir1;

public class CommunityCenter extends GravityChecker {
    private WaitingList nursesWaitingList;

    public CommunityCenter(TriageType triageType){
        this.nursesWaitingList = WaitingListFactory.instantiateWaitingList(triageType);
    }
    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        if (checkIfGravityIsGreaterThanOne(gravity)) {
            this.nursesWaitingList.handlePatient(name,gravity);
        }

    }

    public WaitingList getNursesWaitingList(){
        return this.nursesWaitingList;
    }
}
