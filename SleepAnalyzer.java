//-------------------------------------------------------------------------
/**
*  Analyzes the sleep data
*  Provide various analysis based on the sleep data entered by the user.
* 
*  @author Yug Patel
*  @version Sep 14, 2026
*/
package sleepify;

import java.util.ArrayList;
public class SleepAnalyzer
{
    //~ Fields ................................................................
    private StoreAllUserInput sleepData;
    
    //~ Constructors ..........................................................
    /**
     * Create a new SleepAnalyzer object.
     * @param sleepData data by the user
     */
    public SleepAnalyzer(StoreAllUserInput sleepData)
    {
        this.sleepData = sleepData;
    }
    
    //~Public  Methods ........................................................

/**
     * Calculates the average sleep of the user for the past 7 days.
     */
    public void averageSleep()
    {
        ArrayList<UserInput> entries = sleepData.getEntries();
        
        double hours = 0;
        int start = Math.max(0, entries.size() - 7);
        
        for (int i = start; i < entries.size(); i++)
        {
            hours += entries.get(i).getSleepTime();
        }
        int numberOfDays = entries.size() - start;
        
        System.out.println("Average Sleep for Past " + numberOfDays + " Days: " 
            + (hours/numberOfDays));
    }
    
    /**
     * Find the highest sleep day of the user from the past 7 days.
     */
    public void highestSleepDay()
    {
        ArrayList<UserInput> entries = sleepData.getEntries();
        int start = Math.max(0, entries.size() - 7); 
        int highestDay = 0;
        double highestHours = 0;
        
        for (int i = start; i < entries.size(); i++)
        {
            if (entries.get(i).getSleepTime() > highestHours)
            {
                highestDay = i;
                highestHours = entries.get(i).getSleepTime();
            }
        }
        System.out.println("Highest sleep day is " + (highestDay + 1));
    }
    
    /**
     * Find the lowest sleep day of the user from the past 7 days.
     */
    public void lowestSleepDay()
    {
        ArrayList<UserInput> entries = sleepData.getEntries();
        int start = Math.max(0, entries.size() - 7); 
        int lowestDay = 0;
        double lowestHours = 0;
        
        for (int i = start; i < entries.size(); i++)
        {
            if (entries.get(i).getSleepTime() < lowestHours)
            {
                lowestDay = i;
                lowestHours = entries.get(i).getSleepTime();
            }
        }
        System.out.println("Lowest sleep day is " + (lowestDay + 1));
    }
}
