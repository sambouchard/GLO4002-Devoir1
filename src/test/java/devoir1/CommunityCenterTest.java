package devoir1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommunityCenterTest {


    @Test
    public void given_aPatientWithAMigraine_when_heShowsUpToCommunityCenter_then_heIsTheFirstInTheNurseWaitingList(){
        CommunityCenter testComunityCenter = new CommunityCenter(TriageType.FIFO);
        String expectedName = "Yvon Lavalle";
        int testGravity = 2;
        VisibleSymptom testMigraine = VisibleSymptom.MIGRAINE;
        testComunityCenter.triagePatient(expectedName,testGravity,testMigraine);
        String actualName = testComunityCenter.getFirstNameInMainWaitingList();
        assertEquals(expectedName,actualName);
    }

    @Test
    public void given_aAnNurseWaitingListWithOnePatientInIt_when_APatientShowsUpWithTheFlu_then_heIsSecondInTheNurseWaitingList(){
        CommunityCenter testCommunityCenter = new CommunityCenter(TriageType.FIFO);
        String testFirstName = "Yvon Lavalle";
        String expectedSecondName = "Manon Grenier";
        int testGravity = 2;
        VisibleSymptom testFlu = VisibleSymptom.FLU;
        testCommunityCenter.triagePatient(testFirstName,testGravity,testFlu);
        testCommunityCenter.triagePatient(expectedSecondName,testGravity,testFlu);
        String actualName = testCommunityCenter.getMainWaitingList().get(1);
        assertEquals(expectedSecondName,actualName);
    }

    @Test
    public void given_aPatientWithASprain_when_thereIsOneOrMorePatientAlreadyInTheNurseWaitingList_then_heIsFirstInTheNurseWaitingList(){
        CommunityCenter testCommunityCenter = new CommunityCenter(TriageType.FIFO);
        String expectedPatientName = "Yvon Lavalle";
        String testSecondName = "Manon Grenier";
        int testGravity = 2;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.SPRAIN;
        testCommunityCenter.triagePatient(testSecondName,testGravity,testVisibleSymptom);
        testCommunityCenter.triagePatient(expectedPatientName,testGravity,testVisibleSymptom);
        String actualPatientName = testCommunityCenter.getFirstNameInMainWaitingList();
        assertEquals(expectedPatientName,actualPatientName);
    }

    @Test
    public void given_aPatientWithABrokenBone_when_thereIsOneOrMorePatientAlreadyInTheNurseWaitingList_then_heIsFirstInTheNurseWaitingList(){
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
        CommunityCenter testCommunityCenter = new CommunityCenter(TriageType.GRAVITY);
        String expectedPatientName = "Yvon Lavalle";
        String testSecondName = "Manon Grenier";
        int testGravity = 7;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.FLU;
        testCommunityCenter.triagePatient(testSecondName,testGravity,testVisibleSymptom);
        testCommunityCenter.triagePatient(expectedPatientName,testGravity,testVisibleSymptom);
        String actualPatientName = testCommunityCenter.getFirstNameInMainWaitingList();
        assertEquals(expectedPatientName,actualPatientName);
    }

    @Test
    public void given_aCommunityCenterWithAGravityTriageTypeAndTheNurseWaitingListWithAPatientInIt_when_aPatientShowsUpWithABrokenBoneOfSeverity7_then_heIsFirstInTheNurseWaitingList(){
        CommunityCenter testCommunityCenter = new CommunityCenter(TriageType.GRAVITY);
        String expectedPatientName = "Yvon Lavalle";
        String testSecondName = "Manon Grenier";
        int testGravity = 7;
        VisibleSymptom testVisibleSymptom = VisibleSymptom.BROKEN_BONE;
        testCommunityCenter.triagePatient(testSecondName,testGravity,testVisibleSymptom);
        testCommunityCenter.triagePatient(expectedPatientName,testGravity,testVisibleSymptom);
        String actualPatientName = testCommunityCenter.getFirstNameInMainWaitingList();
        assertEquals(expectedPatientName,actualPatientName);
    }
}
