package devoir1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClinicTest {
    @Test
    public void whenTriagingPatient_thenPatientIsAddedToTheDoctorWaitingList() {
        Clinic testClinic = new Clinic(TriageType.FIFO);
        String expectedName = "Manon Grenier";
        int testGravity = 4;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.MIGRAINE;
        testClinic.triagePatient(expectedName,testGravity,testVisibleSymptom);
        WaitingList actualDoctorWaitingList = testClinic.getDoctorWaitingLIst();
        assertTrue(actualDoctorWaitingList.containPatient(expectedName));
    }

    @Test
    public void whenTriagingPatientWithTheFlu_thenPatientIsNotAddedToTheRadiologyWaitingList() {
        Clinic testClinic = new Clinic(TriageType.FIFO);
        String expectedName = "Manon Grenier";
        int testGravity = 4;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.FLU;
        testClinic.triagePatient(expectedName,testGravity,testVisibleSymptom);
        WaitingList actualRadiologyWaitingList = testClinic.getRadiologyWaitingList();
        assertFalse(actualRadiologyWaitingList.containPatient(expectedName));
    }

    @Test
    public void whenTriagingPatientWithABrokenBone_thenPatientIsAddedToTheRadiologyWaitingList() {
        Clinic testClinic = new Clinic(TriageType.FIFO);
        String expectedName = "Manon Grenier";
        int testGravity = 4;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.BROKEN_BONE;
        testClinic.triagePatient(expectedName,testGravity,testVisibleSymptom);
        WaitingList actualRadiologyWaitingList = testClinic.getRadiologyWaitingList();
        assertTrue(actualRadiologyWaitingList.containPatient(expectedName));
    }

    @Test
    public void whenTriagingPatientWithASprain_thenPatientIsAddedToTheRadiologyWaitingList() {
        Clinic testClinic = new Clinic(TriageType.FIFO);
        String expectedName = "Manon Grenier";
        int testGravity = 4;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.SPRAIN;
        testClinic.triagePatient(expectedName,testGravity,testVisibleSymptom);
        WaitingList actualRadiologyWaitingList = testClinic.getRadiologyWaitingList();
        assertTrue(actualRadiologyWaitingList.containPatient(expectedName));
    }
}