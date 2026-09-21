package sleepify;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SleepAnalyzerTest
{
    //~ Fields ................................................................
    private SleepAnalyzer sleepAnalyzer;
    
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    /**
     * Sets up the test
     */
    @BeforeEach
    public void setUp()
    {
        UserInput userInput1 = new UserInput(6.00, 1, 9, "high", "none");
        UserInput userInput2 = new UserInput(8.00, 1, 5, "low", "i don't know");
        UserInput userInput3 = new UserInput(9.50, 0, 10, "high", "none");
        StoreAllUserInput storeAllUserInput = new StoreAllUserInput();
        storeAllUserInput.addEntry(userInput1);
        storeAllUserInput.addEntry(userInput2);
        storeAllUserInput.addEntry(userInput3);
        sleepAnalyzer = new SleepAnalyzer(storeAllUserInput);
    }
    
    @Test
    /**
     * Tests the average sleep method
     */
    public void testAverageSleep()
    {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        sleepAnalyzer.averageSleep();
        assertEquals("Average Sleep for Past 3 Days: 8 hours", output.toString().trim());
    }
    
    @Test
    /**
     * Tests the highest sleep day method
     */
    public void testHighestSleepDay()
    {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        sleepAnalyzer.highestSleepDay();
        assertEquals("Highest sleep day is 3", output.toString().trim());
    }
    
    @Test
    /**
     * Tests the lowest sleep day method
     */
    public void testLowestSleepDay()
    {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        sleepAnalyzer.lowestSleepDay();
        assertEquals("Lowest sleep day is 1", output.toString().trim());
    }
     
    // ----------------------------------------------------------
    /**
     * Test recommendation system normal 
     */
    @Test
    public void testRecommendationSystemNormal() 
    {
        StoreAllUserInput store = new StoreAllUserInput();
        UserInput entry = new UserInput(6.0, 1, 8, "low", "dream");
        store.addEntry(entry);
        SleepAnalyzer analyzer = new SleepAnalyzer(store);

        analyzer.recommendationSystem();
    }

     // ----------------------------------------------------------
    /**
     * test recommendation system bad input
     */
    @Test
    public void testRecommendationSystemBadInput()
    {
        StoreAllUserInput store = new StoreAllUserInput();
        SleepAnalyzer analyzer = new SleepAnalyzer(store);
        
        analyzer.recommendationSystem();

    }    
}  
