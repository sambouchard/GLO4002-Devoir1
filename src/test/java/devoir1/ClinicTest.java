package devoir1;


import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class ClinicTest {

    @Test
    public void given_aPatientWithAMigraine_when_heShowsUpToTheClinic_then_heIsTheFirstInTheWaitingList(){
        Clinic testClinic = new Clinic(TriageType.FIFO);
        String expectedName = "Yvon Lavalle";
        int testGravity = 2;
        VisibleSymptom testMigraine = VisibleSymptom.MIGRAINE;
        testClinic.triagePatient(expectedName,testGravity,testMigraine);
        String actualName = testClinic.getFirstNameInDoctorWaitingList();
        assertEquals(expectedName,actualName);
    }

    @Test
    public void given_aPatientWithAMigraine_when_heShowsUpToTheClinic_then_HeIsNotInTheRadiologyWaitingList_(){
        Clinic testClinic = new Clinic(TriageType.FIFO);
        String testName = "Yvon Lavalle";
        int testGravity = 2;
        VisibleSymptom testMigraine = VisibleSymptom.MIGRAINE;
        testClinic.triagePatient(testName,testGravity,testMigraine);
        assertFalse(testClinic.getRadiologyWaitingList().contains(testName));
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
        String actualName = testClinic.getDoctorWaitingList().get(1);
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
        String actualPatientName = testClinic.getFirstNameInDoctorWaitingList();
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
        String actualPatientName = testClinic.getFirstNameInDoctorWaitingList();
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
        String actualPatientName = testClinic.getFirstNameInDoctorWaitingList();
        assertEquals(expectedPatientName,actualPatientName);
    }

    @Test
    public void given_aClinicWithAGravityTriageTypeAndBothOfTheRadiologyAndDoctorWaitingListWithAPatientInIt_when_aPatientShowsUpWithABrokenBoneOfSeverity7_then_heIsSecondInTheRadiologyWaitingList(){
        Clinic testClinic = new Clinic(TriageType.GRAVITY);
        String expectedPatientName = "Yvon Lavalle";
        String testSecondName = "Manon Grenier";
        int testGravity = 7;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.BROKEN_BONE;
        testClinic.triagePatient(testSecondName,testGravity,testVisibleSymptom);
        testClinic.triagePatient(expectedPatientName,testGravity,testVisibleSymptom);
        LinkedList<String> actualRadiologyWaitingList = testClinic.getRadiologyWaitingList();
        String actualSecondPatientName = actualRadiologyWaitingList.get(1);
        assertEquals(expectedPatientName,actualSecondPatientName);
    }

}

