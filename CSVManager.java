package sleepify;

// for representing a file on computer
// for example File file = new File("sleepData.csv");
// this would give us a file called sleepData.csv
import java.io.File;
import java.io.FileWriter;

// Handles errors like file DNE or is locked or cant write
import java.io.IOException;

// ArrayList<UserInput> entries = new ArrayList<>();
// allows us to hold many sleep entries
import java.util.ArrayList;

// Scanner scanner = new Scanner(file);
// allows reading csv file
// one line at a time
import java.util.Scanner;

public class CSVManager {
    
    // stores the name of the file like examplesleepData.csv or user1.csv
    private String fileName;

    // CSVManager object created:
    // CSVManager csv = new CSVManager("sleepData.csv");
    public CSVManager(String fileName) {
        // allows every method to know which file to use
        this.fileName = fileName;
    }

    // Save UserInput entries to the CSV file
    public void saveEntries(ArrayList<UserInput> entries) {

        // opening file in writing form
        // writes all current entries to file
        try (FileWriter writer = new FileWriter(fileName)) {

            // Go through every UserInput object inside the entries ArrayList,
            // one at a time, and call the current one entry.
            for (UserInput entry : entries) {

                // methods come from UserInput
                // entry is the UserInput object that we named entry
                writer.write(
                    entry.getSleepTime() + "," +
                    entry.getWokenUp() + "," +
                    entry.getSleepRating() + "," +
                    entry.getEnergy() + "," +
                    entry.getDreamLog() + "\n"
                );
            }

            // catch the exceptions when theres errors print message
            // instead of crashing file
        }
        catch (IOException e) {
            System.out.println("Error saving entries.");
        }
    }

    // Load all UserInput objects from the CSV file
    public ArrayList<UserInput> loadEntries() {

        // creates empty array [], later our entries are added
        // [entry1, entry2, entry3]
        ArrayList<UserInput> entries = new ArrayList<>();

        try {
            File file = new File(fileName);

            if (!file.exists()) {
                // returns empty list
                return entries;
            }

            // creates scanner, which opens file for reading
            Scanner scanner = new Scanner(file);

            // if theres another line keep reading
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                // split into 5 pieces:
                // sleepTime, wakeups, rating, energy, dreamLog
                String[] data = line.split(",", 5);

                UserInput entry = new UserInput(
                    Double.parseDouble(data[0]), // sleep time
                    Integer.parseInt(data[1]),  // wake ups
                    Integer.parseInt(data[2]),  // sleep rating
                    data[3],                    // energy
                    data[4]                     // dream log
                );

                // after reading each entry list becomes
                // [entry1, entry2 ... ] etc
                entries.add(entry);
            }

            // close read mode
            scanner.close();

            // deals w missing data, invalid input etc
        }
        catch (Exception e) {
            System.out.println("Error loading entries.");
        }

        // returns loaded entries
        // ArrayList<UserInput> entries =
        // csv.loadEntries();
        return entries;
    }
}


/**
UserInput entry =
new UserInput(
    8.5,
    2,
    9,
    "high",
    "running around in a field of flowers"
);

csv file then contains: 8.5,2,9,high,running around in a field of flowers




*/





