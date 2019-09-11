package devoir1;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClinicTest {

    @Test
    public void given_aPatientWithAMigraine_when_heShowsUpToTheClinic_then_heIsTheFirstInTheWaitingList(){
        Clinic testClinic = new Clinic(TriageType.FIFO);
        String expectedName = "Yvon Lavalle";
        int testGravity = 2;
        VisibleSymptom testMigraine = VisibleSymptom.MIGRAINE;
        testClinic.triagePatient(expectedName,testGravity,testMigraine);
        String actualName = testClinic.getFirstNameInMainWaitingList();
        assertEquals(expectedName,actualName);
    }

    @Test
    public void given_aPatientWithAMigraine_when_heShowsUpToTheClinic_then_HeIsNotInTheRadiologyWaitingList_(){
        Clinic testClinic = new Clinic(TriageType.FIFO);
        String testName = "Yvon Lavalle";
        int testGravity = 2;
        VisibleSymptom testMigraine = VisibleSymptom.MIGRAINE;
        testClinic.triagePatient(testName,testGravity,testMigraine);
        boolean radiologyWaitingListContainsName = testClinic.getRadiologyWaitingList().contains(testName);
        assertFalse(radiologyWaitingListContainsName);
    }

    @Test
    public void given_aADoctorListWithOnePatientInIt_when_APatientShowsUpWithTheFlu_then_heIsSecondInTheDoctorWaitingList(){
        Clinic testClinic = new Clinic(TriageType.FIFO);
        String testFirstName = "Yvon Lavalle";
        String expectedSecondName = "Manon Grenier";
        int testGravity = 2;
        VisibleSymptom testFlu = VisibleSymptom.FLU;
        testClinic.triagePatient(testFirstName,testGravity,testFlu);
        testClinic.triagePatient(expectedSecondName,testGravity,testFlu);
        String actualName = testClinic.getMainWaitingList().get(1);
        assertEquals(expectedSecondName,actualName);
    }

    @Test
    public void given_aADoctorListWithOnePatientInIt_when_APatientShowsUpWithTheFlu_then_heIsNotOnTheRadiologyWaitingList(){
        Clinic testClinic = new Clinic(TriageType.FIFO);
        String testFirstName = "Yvon Lavalle";
        String expectedSecondName = "Manon Grenier";
        int testGravity = 2;
        VisibleSymptom testFlu = VisibleSymptom.FLU;
        testClinic.triagePatient(testFirstName,testGravity,testFlu);
        testClinic.triagePatient(expectedSecondName,testGravity,testFlu);
        assertFalse(testClinic.getRadiologyWaitingList().contains(expectedSecondName));
    }

    @Test
    public void given_aPatientWithAPatientWithASprain_when_heShowsUpToTheClinic_then_heIsAddedToTheRadiologyWaitingList(){
        Clinic testClinic = new Clinic(TriageType.FIFO);
        String expectedName = "Yvon Lavalle";
        int testGravity = 2;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.SPRAIN;
        testClinic.triagePatient(expectedName,testGravity,testVisibleSymptom);
        assertTrue(testClinic.getRadiologyWaitingList().contains(expectedName));
    }

    @Test
    public void given_aPatientWithABrokenBone_when_heShowsUpToTheClinic_then_heIsAddedToTheRadiologyWaitingList(){
        Clinic testClinic = new Clinic(TriageType.FIFO);
        String expectedName = "Yvon Lavalle";
        int testGravity = 2;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.BROKEN_BONE;
        testClinic.triagePatient(expectedName,testGravity,testVisibleSymptom);
        assertTrue(testClinic.getRadiologyWaitingList().contains(expectedName));


    }

    @Test
    public void given_aPatientWithASprain_when_thereIsOneOrMorePatientAlreadyInTheDoctorWaitingList_then_heIsFirstInTheWaitingList(){
        Clinic testClinic = new Clinic(TriageType.FIFO);
        String expectedPatientName = "Yvon Lavalle";
        String testSecondName = "Manon Grenier";
        int testGravity = 2;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.SPRAIN;
        testClinic.triagePatient(testSecondName,testGravity,testVisibleSymptom);
        testClinic.triagePatient(expectedPatientName,testGravity,testVisibleSymptom);
        String actualPatientName = testClinic.getFirstNameInMainWaitingList();
        assertEquals(expectedPatientName,actualPatientName);
    }

    @Test
    public void given_aPatientWithABrokenBone_when_thereIsOneOrMorePatientAlreadyInTheDoctorWaitingList_then_heIsFirstInTheWaitingList(){
        Clinic testClinic = new Clinic(TriageType.FIFO);
        String expectedPatientName = "Yvon Lavalle";
        String testSecondName = "Manon Grenier";
        int testGravity = 2;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.BROKEN_BONE;
        testClinic.triagePatient(testSecondName,testGravity,testVisibleSymptom);
        testClinic.triagePatient(expectedPatientName,testGravity,testVisibleSymptom);
        String actualPatientName = testClinic.getFirstNameInMainWaitingList();
        assertEquals(expectedPatientName,actualPatientName);
    }

    @Test
    public void given_aClinicWithGravityTriageTypeAndAPatientInTheDoctorWaitingList_when_aPatientShowsUpWithAFluOfSeverity7_then_addHimAtTheBeginningOfTheDoctorWaitingList(){
        Clinic testClinic = new Clinic(TriageType.GRAVITY);
        String expectedPatientName = "Yvon Lavalle";
        String testSecondName = "Manon Grenier";
        int testGravity = 7;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.FLU;
        testClinic.triagePatient(testSecondName,testGravity,testVisibleSymptom);
        testClinic.triagePatient(expectedPatientName,testGravity,testVisibleSymptom);
        String actualPatientName = testClinic.getFirstNameInMainWaitingList();
        assertEquals(expectedPatientName,actualPatientName);
    }

    @Test
    public void given_aClinicWithAGravityTriageTypeAndBothOfTheRadiologyAndDoctorWaitingListWithAPatientInIt_when_aPatientShowsUpWithABrokenBoneOfSeverity7_then_heIsFirstInTheRadiologyWaitingList(){
        Clinic testClinic = new Clinic(TriageType.GRAVITY);
        String expectedPatientName = "Yvon Lavalle";
        String testSecondName = "Manon Grenier";
        int testGravity = 7;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.BROKEN_BONE;
        testClinic.triagePatient(testSecondName,testGravity,testVisibleSymptom);
        testClinic.triagePatient(expectedPatientName,testGravity,testVisibleSymptom);
        String actualSecondPatientName = testClinic.getFirstNameInRadiologyWaitingLIst();
        assertEquals(expectedPatientName,actualSecondPatientName);
    }

    @Test
    public void given_aClinicWithAGravityTriageTypeAndBothOfTheRadiologyAndDoctorWaitingListWithAPatientInIt_when_aPatientShowsUpWithABrokenBoneOfSeverity7_then_heIsFirstInTheDoctorWaitingList(){
        Clinic testClinic = new Clinic(TriageType.GRAVITY);
        String expectedPatientName = "Yvon Lavalle";
        String testSecondName = "Manon Grenier";
        int testGravity = 7;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.BROKEN_BONE;
        testClinic.triagePatient(testSecondName,testGravity,testVisibleSymptom);
        testClinic.triagePatient(expectedPatientName,testGravity,testVisibleSymptom);
        String actualPatientName = testClinic.getFirstNameInMainWaitingList();
        assertEquals(expectedPatientName,actualPatientName);
    }

    @Test
    public void given_aPatientWithASymptomOfGravityOne_when_theClinicHasAGravityTriageType_then_dontAddHimOnTheDoctorWaitingList(){
        Clinic testClinic = new Clinic(TriageType.GRAVITY);
        String expectedPatientName = "Yvon Lavalle";
        int testGravity = 1;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.BROKEN_BONE;
        testClinic.triagePatient(expectedPatientName,testGravity,testVisibleSymptom);
        boolean containsPatientName = testClinic.getMainWaitingList().contains(expectedPatientName);
        assertFalse(containsPatientName);

    }

    @Test
    public void given_aPatientWithASymptomOfGravityOne_when_theClinicHasAFifoTriageType_then_dontAddHimOnTheDoctorWaitingList(){
        Clinic testClinic = new Clinic(TriageType.FIFO);
        String expectedPatientName = "Yvon Lavalle";
        int testGravity = 1;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.BROKEN_BONE;
        testClinic.triagePatient(expectedPatientName,testGravity,testVisibleSymptom);
        boolean containsPatientName = testClinic.getMainWaitingList().contains(expectedPatientName);
        assertFalse(containsPatientName);

    }

    @Test
    public void given_aPatientWithASymptomOfGravityOne_when_theClinicHasAGravityTriageType_then_dontAddHimOnTheRadiologyWaitingList(){
        Clinic testClinic = new Clinic(TriageType.GRAVITY);
        String expectedPatientName = "Yvon Lavalle";
        int testGravity = 1;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.BROKEN_BONE;
        testClinic.triagePatient(expectedPatientName,testGravity,testVisibleSymptom);
        boolean containsPatientName = testClinic.getRadiologyWaitingList().contains(expectedPatientName);
        assertFalse(containsPatientName);

    }

    @Test
    public void given_aPatientWithASymptomOfGravityOne_when_theClinicHasAFifoTriageType_then_dontAddHimOnTheRadiologyWaitingList(){
        Clinic testClinic = new Clinic(TriageType.FIFO);
        String expectedPatientName = "Yvon Lavalle";
        int testGravity = 1;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.BROKEN_BONE;
        testClinic.triagePatient(expectedPatientName,testGravity,testVisibleSymptom);
        boolean containsPatientName = testClinic.getRadiologyWaitingList().contains(expectedPatientName);
        assertFalse(containsPatientName);

    }
}