package devoir1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GravityCheckerTest {
    @Test
    public void given_aGravityOfOne_when_checkingIfItIsGreaterThanOne_then_returnFalse(){
        GravityChecker testGravityChecker = new GravityChecker();
        int actualGravity = 1;
        boolean actualResult = testGravityChecker.checkIfGravityIsGreaterThanOne(actualGravity);
        assertFalse(actualResult);
    }
    @Test
    public void given_aGravityGreaterThanOne_when_checkingIfItIsGreaterThanOne_then_returnTrue(){
        GravityChecker testGravityChecker = new GravityChecker();
        int actualGravity = 3;
        boolean actualResult = testGravityChecker.checkIfGravityIsGreaterThanOne(actualGravity);
        assertTrue(actualResult);
    }
}
