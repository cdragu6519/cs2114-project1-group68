// -------------------------------------------------------------------------
package sleepify;

/**
 *  Validates the input of the user.
 *  Creates different methods to make sure all the entries by the user is valid.
 * 
 *  @author Yug Patel
 *  @version Sep 14, 2026
 */
public class InputValidator
{
    // ----------------------------------------------------------
    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    /**
     * Determines whether the sleep rating is between 0 - 10 or not.
     * @param rating of the sleep.
     * @return boolean result of whether the rating is between 0-10.
     */
    public Boolean validateSleepRating(int rating)
    {
        if (rating >= 0 && rating <= 10)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Determines whether the user has enter "skip" for a question.
     * @param s string that user would enter to skip a question.
     * @return boolean result whether "skip" is used.
     */
    public Boolean validateSkip(String s)
    {
        if (s.equalsIgnoreCase("skip"))
        {
            return true;
        }
        return false;
    }
    
    /**
     * Determines whether the user has entered valid sleep hour and not exceed
     * 24 hours a day. 
     * @param hour number of hours slept.
     * @return boolean result of whether the number of sleep is valid.
     */
    public Boolean validateSleepHour(int hour)
    {
        if (hour <= 24 && hour >= 0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Determines whether the energy level entered by the user is a valid option.
     * @param energyLevel level of energy throughout the day.
     * @return boolean result whether a valid energyLevel has been used.
     */
    public Boolean validateEnergyLevel(String energyLevel)
    {
        if (energyLevel.equalsIgnoreCase("low"))
        {
            return true;
        }
        else if (energyLevel.equalsIgnoreCase("medium"))
        {
            return true;
        }
        else if (energyLevel.equalsIgnoreCase("high"))
        {
            return true;
        }
        return false;
    }
    
    /**
     * Determines whether the user has entered valid number of times wokenUp
     * @param wokenUp number of times woken up.
     * @return boolean result of whether the number of woken up is valid.
     */
    public Boolean validateWokenUp(int wokenUp)
    {
        if (wokenUp <= 25 && wokenUp >= 0)
        {
            return true;
        }
        return false;
    }
}
