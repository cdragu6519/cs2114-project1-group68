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
            + Math.round(hours/numberOfDays) + " hours");
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

    public void recommendationSystem() {
        ArrayList<UserInput> entries = sleepData.getEntries();
        
        if(entries.isEmpty()) {
            System.out.println("Not enough data to generate recommendations.");
        }
        
        //creating variable for most recent entries 
       UserInput latestEntry = entries.get(entries.size() - 1);
       
       if(latestEntry.getSleepTime() < 7 
           && latestEntry.getEnergy().equals("low")) {
           System.out.println("You slept less than 7 hours and reported low enery. "
           + "Try getting more sleep to improve your moood. "
           + "The recommended amount for sleep is 7-9 hours");
       }
       
       if(latestEntry.getWokenUp() > 3) {
           System.out.println("You woke up several times during the night "
               + "Consider improving your sleeping enviornment");
       }
       
       if(latestEntry.getSleepTime() >= 7 
           && latestEntry.getEnergy().equals("high")) {
           System.out.println("Your sleep habits appear healthy. Keep it up!");
       }
       
       if (latestEntry.getSleepRating() < 5) {
           System.out.println("You rated your sleep poorly " +
               "Try maintaining a more consistent sleep schedule");
       }
    }
}
