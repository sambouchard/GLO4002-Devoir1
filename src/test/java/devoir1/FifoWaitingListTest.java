package devoir1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FifoWaitingListTest {
    @Test
    public void given_aPatientWithAnyTypeOfVisibleSymptomAndAnyGravity_when_handlingThePatient_then_addHimAtTheEndOfTheList(){
        FifoWaitingList fifoWaitingList = new FifoWaitingList();
        String testFirstName = "Manon Grenier";
        int testGravity = 5;
        String expectedName = "Yvon Lavalle";
        fifoWaitingList.handlePatient(testFirstName,testGravity);
        fifoWaitingList.handlePatient(expectedName,testGravity);
        String actualName = fifoWaitingList.getLastPatient();
        assertEquals(expectedName,actualName);
    }
}
