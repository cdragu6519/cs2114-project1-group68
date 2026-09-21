package sleepify;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InputValidatorTest
{

    //~ Fields ................................................................
    private InputValidator inputValidator;
    
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    public void setUp()
    {
        inputValidator = new InputValidator();
    }
    
    public void testValidateSleepRating()
    {
        assertTrue(inputValidator.validateSleepRating(5));
        assertFalse(inputValidator.validateSleepRating(11));
    }
    
    public void testValidateSkip()
    {
        assertFalse(inputValidator.validateSkip("ski"));
        assertTrue(inputValidator.validateSkip("skip"));
        assertTrue(inputValidator.validateSkip("Skip"));
    }
    
    public void testValidateSleepHour()
    {
        assertFalse(inputValidator.validateSleepHour(25));
        assertTrue(inputValidator.validateSleepHour(12));
    }
    
    public void testValidateEnergyLevel()
    {
        assertTrue(inputValidator.validateEnergyLevel("low"));
        assertTrue(inputValidator.validateEnergyLevel("medium"));
        assertTrue(inputValidator.validateEnergyLevel("high"));
        assertFalse(inputValidator.validateEnergyLevel("good"));
    }
    
    public void testValidateWokenUp()
    {
        assertFalse(inputValidator.validateWokenUp(26));
        assertTrue(inputValidator.validateWokenUp(12));
    }
}
