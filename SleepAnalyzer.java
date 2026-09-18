//-------------------------------------------------------------------------
/**
*  Analyzes the sleep data
*  Provide various analysis based on the sleep data entered by the user.
* 
*  @author Yug Patel
*  @version Sep 14, 2026
*/

import java.util.ArrayList;
public class SleepAnalyzer
{
    //~ Fields ................................................................
    ArrayList<Double> sleepData = new ArrayList<>();
    
    //~ Constructors ..........................................................
    /**
     * Create a new SleepAnalyzer object.
     * @param sleepData data by the user
     */
    public SleepAnalyzer(ArrayList<Double> sleepData)
    {
        this.sleepData = sleepData;
    }
    
    //~Public  Methods ........................................................

/**
     * Calculates the average sleep of the user for the past 7 days.
     */
    public void averageSleep()
    {
        double hours = 0;
        for (int i = sleepData.size() - 7; i != sleepData.size(); i++)
        {
            hours += sleepData.get(i);
        }
        System.out.println("Average Sleep for Past 7 Days: " + (hours/7));
    }
    
    /**
     * Find the highest sleep day of the user from the past 7 days.
     */
    public void highestSleepDay()
    {
        int highestDay = 0;
        double highestHours = 0;
        for (int i = sleepData.size() - 7; i != sleepData.size(); i++)
        {
            if (sleepData.get(i) > highestHours)
            {
                highestDay = i;
                highestHours = sleepData.get(i);
            }
        }
        System.out.println("Highest sleep day in past 7 days is " + highestDay);
    }
    
    /**
     * Find the lowest sleep day of the user from the past 7 days.
     */
    public void lowestSleepDay()
    {
        int lowestDay = 0;
        double lowestHours = 0;
        for (int i = sleepData.size() - 7; i != sleepData.size(); i++)
        {
            if (sleepData.get(i) < lowestHours)
            {
                lowestDay = i;
                lowestHours = sleepData.get(i);
            }
        }
        System.out.println("Lowest sleep day in past 7 days is " + lowestDay);
    }
}
