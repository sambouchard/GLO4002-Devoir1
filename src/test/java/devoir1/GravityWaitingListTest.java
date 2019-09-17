package devoir1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GravityWaitingListTest {
    @Test
    public void given_aPatientWithAGravityLesserThenFive_when_handlingThePatient_then_patientIsAddedAtTheEndOfTheList(){
        GravityWaitingList gravityWaitingList = new GravityWaitingList();
        String testFirstName = "Manon Grenier";
        int testGravity = 4;
        String expectedName = "Yvon Lavalle";
        gravityWaitingList.handlePatient(testFirstName,testGravity);
        gravityWaitingList.handlePatient(expectedName,testGravity);
        String actualName = gravityWaitingList.getLastPatient();
        assertEquals(expectedName,actualName);
    }

    @Test
    public void given_aPatientWithAGravityOfFive_when_handlingThePatient_then_patientIsAddedAtTheEndOfTheList(){
        GravityWaitingList gravityWaitingList = new GravityWaitingList();
        String testFirstName = "Manon Grenier";
        int testGravity = 5;
        String expectedName = "Yvon Lavalle";
        gravityWaitingList.handlePatient(testFirstName,testGravity);
        gravityWaitingList.handlePatient(expectedName,testGravity);
        String actualName = gravityWaitingList.getLastPatient();
        assertEquals(expectedName,actualName);
    }
    @Test
    public void given_aPatientWithAGravityHigherThenFive_when_handlingThePatient_then_patientIsAddedAtTheBeginningOfTheList(){
        GravityWaitingList gravityWaitingList = new GravityWaitingList();
        String testFirstName = "Manon Grenier";
        int testGravity = 6;
        VisibleSymptom testVisibleSymptom =  VisibleSymptom.BROKEN_BONE;
        String expectedName = "Yvon Lavalle";
        gravityWaitingList.handlePatient(testFirstName,testGravity);
        gravityWaitingList.handlePatient(expectedName,testGravity);
        String actualName = gravityWaitingList.getFirstPatient();
        assertEquals(expectedName,actualName);
    }
}
