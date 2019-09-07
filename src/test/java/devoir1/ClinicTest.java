package devoir1;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ClinicTest {

    @Test
    public void given_aPatientWithAMigraine_when_heShowsUpToTheClinic_then_heIsTheFirstInTheWaitingList(){
        Clinic testClinic = new Clinic();
        String expectedName = "Yvon Lavalle";
        int testGravity = 2;
        VisibleSymptom testMigraine = VisibleSymptom.MIGRAINE;
        testClinic.triagePatient(expectedName,testGravity,testMigraine);
        String actualName = testClinic.getFirstNameInDoctorWaitingList();
        assertEquals(expectedName,actualName);
    }

    @Test
    public void given_aPatientWithAMigraine_when_heShowsUpToTheClinic_then_HeIsNotInTheRadiologyWaitingList_(){
        Clinic testClinic = new Clinic();
        String testName = "Yvon Lavalle";
        int testGravity = 2;
        VisibleSymptom testMigraine = VisibleSymptom.MIGRAINE;
        testClinic.triagePatient(testName,testGravity,testMigraine);
        assertFalse(testClinic.getRadiologyWaitingList().contains(testName));
    }

    @Test
    public void given_aADoctorListWithOnePatientInIt_when_APatientShowsUpWithTheFlu_then_heIsSecondInTheDoctorWaitingList(){
        Clinic testClinic = new Clinic();
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
        Clinic testClinic = new Clinic();
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
        Clinic testClinic = new Clinic();
        String expectedName = "Yvon Lavalle";
        int testGravity = 2;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.SPRAIN;
        testClinic.triagePatient(expectedName,testGravity,testVisibleSymptom);
        assertTrue(testClinic.getRadiologyWaitingList().contains(expectedName));
    }

    @Test
    public void given_aPatientWithABrokenBone_when_heShowsUpToTheClinic_then_heIsAddedToTheRadiologyWaitingList(){
        Clinic testClinic = new Clinic();
        String expectedName = "Yvon Lavalle";
        int testGravity = 2;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.SPRAIN;
        testClinic.triagePatient(expectedName,testGravity,testVisibleSymptom);
        assertTrue(testClinic.getRadiologyWaitingList().contains(expectedName));


    }


}

