import java.util.ArrayList;

public class SleepAnalyzer
{
    //~ Fields ................................................................
    ArrayList<Double> sleepData = new ArrayLIst<>();
    
    //~ Constructors ..........................................................
    public SleepAnalyzer(ArrayList<Double> sleepData)
    {
        this.sleepData = sleepData;
    }
    
    //~Public  Methods ........................................................
    public void averageSleep()
    {
        double hours = 0;
        for (int i = sleepData.size() - 7; i == sleepData.size(); i++)
        {
            hours += sleepData.get(i);
        }
        System.out.println("Average Sleep for Past 7 Days: " + (hours/7));
    }
    
    public void highestSleepDay()
    {
        int highestDay = 0;
        double highestHours = 0;
        for (int i = sleepData.size() - 7; i == sleepData.size(); i++)
        {
            if (sleepData.get(i) > highestHours)
            {
                highestDay = i;
                highestHours = sleepData.get(i);
            }
        }
        System.out.println("Highest Sleep Day: " + highestDay);
    }
    
    public void lowestSleepDay()
    {
        int lowestDay = 0;
        double lowestHours = 0;
        for (int i = sleepData.size() - 7; i == sleepData.size(); i++)
        {
            if (sleepData.get(i) < lowestHours)
            {
                lowestDay = i;
                lowestHours = sleepData.get(i);
            }
        }
        System.out.println("Highest Sleep Day: " + lowestDay);
    }
}
