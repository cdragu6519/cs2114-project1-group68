package sleepify;

import java.util.ArrayList;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the CSVManager class.
 *
 * @author Cassandra
 * @version Sep 20, 2026
 */
public class CSVManagerTest extends TestCase
{
    private CSVManager csv;
    private ArrayList<UserInput> entries;
    private UserInput day1;

    // ----------------------------------------------------------
    /**
     * Sets up test objects.
     */
    public void setUp()
    {
        csv = new CSVManager("testSleepData.csv");

        entries = new ArrayList<UserInput>();

        day1 = new UserInput(
            8.0,
            2,
            9,
            "high",
            "good dream");
    }

    // ----------------------------------------------------------
    /**
     * Tests saving a valid entry.
     */
    public void testSaveEntriesNormal()
    {
        entries.add(day1);

        csv.saveEntries(entries);

        ArrayList<UserInput> loaded =
            csv.loadEntries();

        assertEquals(1, loaded.size());
        assertEquals(8.0,
            loaded.get(0).getSleepTime(),
            0.01);
    }


    // ----------------------------------------------------------
    /**
     * Tests saving an empty list.
     */
    public void testSaveEntriesBadInput()
    {
        csv.saveEntries(entries);

        ArrayList<UserInput> loaded =
            csv.loadEntries();

        assertTrue(loaded.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * Tests loading a file with valid data.
     */
    public void testLoadEntriesNormal()
    {
        entries.add(day1);

        csv.saveEntries(entries);

        ArrayList<UserInput> loaded =
            csv.loadEntries();

        assertEquals("high",
            loaded.get(0).getEnergy());

        assertEquals(9,
            loaded.get(0).getSleepRating());
    }


    // ----------------------------------------------------------
    /**
     * Tests loading a file that does not exist.
     */
    public void testLoadEntriesBadInput()
    {
        CSVManager badCsv =
            new CSVManager("fakeFile.csv");

        ArrayList<UserInput> loaded =
            badCsv.loadEntries();

        assertTrue(loaded.isEmpty());
    }
}
