package sleepify;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * Manages saving and loading sleep records to and from a CSV file.
 * The CSV file stores each UserInput object as a single line containing
 * sleep time, wake ups, sleep rating, energy level, and dream log.
 *
 * @author cassie
 * @version Sep 18, 2026
 */
public class CSVManager
{
    //~ Fields .................................................................

    /**
     * Name of the CSV file being used.
     */
    private String fileName;


    //~ Constructor ............................................................

    // ----------------------------------------------------------
    /**
     * Creates a new CSVManager that reads from and writes to the
     * specified file.
     *
     * @param fileName
     *            the name of the CSV file
     */
    public CSVManager(String fileName)
    {
        this.fileName = fileName;
    }


    //~ Public Methods .........................................................

    // ----------------------------------------------------------
    /**
     * Saves all UserInput objects in the given list to the CSV file.
     *
     * @param entries
     *            the list of UserInput records to save
     */
    public void saveEntries(ArrayList<UserInput> entries)
    {
        try (FileWriter writer = new FileWriter(fileName))
        {
            for (UserInput entry : entries)
            {
                writer.write(
                    entry.getSleepTime() + ","
                        + entry.getWokenUp() + ","
                        + entry.getSleepRating() + ","
                        + entry.getEnergy() + ","
                        + entry.getDreamLog() + "\n");
            }
        }
        catch (IOException exception)
        {
            System.out.println("Error saving entries.");
        }
    }


    // ----------------------------------------------------------
    /**
     * Loads all UserInput records stored in the CSV file.
     *
     * @return an ArrayList containing all loaded UserInput objects;
     *         returns an empty list if the file does not exist
     */
    public ArrayList<UserInput> loadEntries()
    {
        ArrayList<UserInput> entries = new ArrayList<>();

        try
        {
            File file = new File(fileName);

            if (!file.exists())
            {
                return entries;
            }

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();

                String[] data = line.split(",", 5);

                UserInput entry = new UserInput(
                    Double.parseDouble(data[0]),
                    Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]),
                    data[3],
                    data[4]);

                entries.add(entry);
            }

            scanner.close();
        }
        catch (Exception exception)
        {
            System.out.println("Error loading entries.");
        }

        return entries;
    }
}


/**
 * Example:
 *
 * <pre>
 * UserInput entry =
 *     new UserInput(
 *         8.5,
 *         2,
 *         9,
 *         "high",
 *         "running around in a field of flowers");
 *
 * CSV file contents:
 * 8.5,2,9,high,running around in a field of flowers
 * </pre>
 */
