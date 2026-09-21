package sleepify;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *  Tests the input validator class
 *  Tests the method of input validator using different possible user input
 * 
 *  @author yugpatel
 *  @version Sep 20, 2026
 */
public class InputValidatorTest
{

    //~ Fields ................................................................
    private InputValidator inputValidator;
    
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    @BeforeEach
    /**
     * Sets up the test
     */
    public void setUp()
    {
        inputValidator = new InputValidator();
    }
    
    @Test
    /**
     * Tests the ValidateSleepRating method
     */
    public void testValidateSleepRating()
    {
        assertTrue(inputValidator.validateSleepRating(5));
        assertFalse(inputValidator.validateSleepRating(11));
    }
    
    @Test
    /**
     * Tests the ValidateSkip method
     */
    public void testValidateSkip()
    {
        assertFalse(inputValidator.validateSkip("ski"));
        assertTrue(inputValidator.validateSkip("skip"));
        assertTrue(inputValidator.validateSkip("Skip"));
    }
    
    @Test
    /**
     * Tests the ValidateSleepHour method
     */
    public void testValidateSleepHour()
    {
        assertFalse(inputValidator.validateSleepHour(25));
        assertTrue(inputValidator.validateSleepHour(12));
    }
    
    @Test
    /**
     * Tests the ValidateEnergyLevel method
     */
    public void testValidateEnergyLevel()
    {
        assertTrue(inputValidator.validateEnergyLevel("low"));
        assertTrue(inputValidator.validateEnergyLevel("medium"));
        assertTrue(inputValidator.validateEnergyLevel("high"));
        assertFalse(inputValidator.validateEnergyLevel("good"));
    }
    
    @Test
    /**
     * Tests the ValidateWokenUp method
     */
    public void testValidateWokenUp()
    {
        assertFalse(inputValidator.validateWokenUp(26));
        assertTrue(inputValidator.validateWokenUp(12));
    }
}
