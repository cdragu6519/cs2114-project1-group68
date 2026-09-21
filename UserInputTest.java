package sleepify;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

// -------------------------------------------------------------------------
/**
 *  Tests UserInput class
 * 
 *  @author catherinearockia
 *  @version Sep 14, 2026
 */
class UserInputTest {

    private UserInput mock;
    
    /**
     * Sets up test cases
     * 
     */
    
    @BeforeEach
    public void setUp() {
        
        mock = new UserInput(8.0,2,9, "high", "running around in a field of flowers");
        
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests getSleepTime() method.
     */
    
    @Test
    public void testSleepTime() {
        
        assertEquals(8, mock.getSleepTime());
        System.out.println(mock.getSleepTime());
    }
    
    // ----------------------------------------------------------
    /**
     * Tests getWokenUp() method.
     */
    @Test
    public void testWokenUp() {
        
        assertEquals(2, mock.getWokenUp());
    }
    
    // ----------------------------------------------------------
    /**
     * Tests getSleepRating() method.
     */
    @Test
    public void testSleepRating() {
        
        assertEquals(9, mock.getSleepRating());
        
    }
    
    // ----------------------------------------------------------
    /**
     * Tests getEnergy()  method.
     */
    @Test
    public void testEnergy() {
        
        assertEquals("high", mock.getEnergy());
        
    }
    
    // ----------------------------------------------------------
    /**
     * Tests getDreamLog() method.
     */
    @Test
    public void testDreamLog() {
        
        assertEquals("running around in a field of flowers", mock.getDreamLog());
        
    }
}
