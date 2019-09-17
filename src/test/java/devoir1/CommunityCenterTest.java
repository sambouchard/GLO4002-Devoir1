package devoir1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommunityCenterTest {
    @Test
    public void given_aPatientWithAGravityHigherThanOne_thenAddHimOnTheNursesWaitingList(){
        CommunityCenter testCommunityCenter = new CommunityCenter(TriageType.FIFO);
        String expectedName = "Manon Grenier";
        int testGravity = 4;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.FLU;
        testCommunityCenter.triagePatient(expectedName,testGravity,testVisibleSymptom);
        WaitingList actualNursesWaitingList = testCommunityCenter.getNursesWaitingList();
        assertTrue(actualNursesWaitingList.containPatient(expectedName));
    }
}
