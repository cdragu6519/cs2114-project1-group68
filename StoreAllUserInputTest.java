package sleepify;

import student.TestCase;
// -------------------------------------------------------------------------
/**
 *  Tests the StoreAllUserInput class.
 * 
 *  @author carol
 *  @version Sep 20, 2026
 */
public class StoreAllUserInputTest extends TestCase
{
    
    private StoreAllUserInput sleepRecords;
    private UserInput day1;
    private UserInput day2;
    
    // ----------------------------------------------------------
    /**
     * sets up objects used by the test
     */
    public void setUp()
    {
        sleepRecords = new StoreAllUserInput();
        
        day1 = new UserInput(8.0, 1, 8, "high", "bad dream");
        day2 = new UserInput(6.0, 2, 7, "low", "good dream");
    }
    
    // ----------------------------------------------------------
    /**
     * tests add entry with a valid UserInput object.
     */
    public void testAddEntryNormal() {
        sleepRecords.addEntry(day1);
        
        //checks if the day1 is the first entry
        assertEquals(day1, sleepRecords.getEntries().get(0));     
    }
    /**
     * tests add entry with a null object 
     */
    public void testAddEntryBadInput() {
        sleepRecords.addEntry(null);
        
        //proving nothing was added
        assertEquals(0, sleepRecords.getEntries().size());
    }
    
    // ----------------------------------------------------------
    /**
     * tests get multiple entries.
     */
    public void testGetEntriesNormal() {
        sleepRecords.addEntry(day1);
        sleepRecords.addEntry(day2);
      
        assertEquals(day1, sleepRecords.getEntries().get(0));
        assertEquals(day2, sleepRecords.getEntries().get(1));
    }
    
    /**
     * tests get entries when no entries exists.
     */
    public void testGetEntriesBadInput() {
        assertTrue(sleepRecords.getEntries().isEmpty());
    }
}
