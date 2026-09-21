package sleepify;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

// -------------------------------------------------------------------------
/**
 *  Tests MainMenu class
 * 
 *  @author catherinearockia
 *  @version Sep 14, 2026
 */
class MainMenuTest {
    
    private MainMenu good;  
    private MainMenu bad;
    
    
    /**
     * Sets up test cases
     * 
     */
    
    @BeforeEach
public void setUp() {
        
        good = new MainMenu();
        bad = new MainMenu();
    }
    
    // ----------------------------------------------------------
    /**
     * Tests validateType()
     */
    @Test
    public void testValidateType() {
        
        //example of the user entering "abc" when asked to rate their sleep (BAD!)
        assertFalse(bad.validateType("abc", "int", "validateSleepRating"));
        
        //example of the user entering a "2" when asked to enter the amount of sleep they got (GOOD!)
        assertTrue(good.validateType("2", "double", "validateSleepHour"));
    }
    
    
    
    
}
