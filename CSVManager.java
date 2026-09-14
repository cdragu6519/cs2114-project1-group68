package sleepify;
// for representing a file on computer
// for example File file = new File("sleepData.csv");
// this would give us a file called sleepData.csv

import java.io.File;
import java.io.FileWriter;

// Handles errors like file DNE or is locked or cant write
import java.io.IOException;

// ArrayList<SleepEntry> entries = new ArrayList<>();
// allows us to hold many sleep entries
import java.util.ArrayList;

//Scanner scanner = new Scanner(file); allows reading csv file
// one line at a time
import java.util.Scanner;

public class CSVManager {
    // stires the name of the file like examplesleepData.csv or user1.csv
    private String fileName;

    
    // CSVManager object created: CSVManager csv = new CSVManager("sleepData.csv");
    
    public CSVManager(String fileName) {
        // allows every method to know which file to use
        this.fileName = fileName;
    }


    
    // Save a SleepEntry to the CSV file
    // example: SleepEntry entry =
    // new SleepEntry(...);
    // csv.saveEntry(entry);
    public void saveEntries(ArrayList<UserInput> entries) {
           // opening file in writing form. true lets us append instead of writing
     // on top of old data
        try (FileWriter writer = new FileWriter(fileName)) {
            //Go through every UserInput object inside the entries ArrayList, 
            // one at a time, and call the current one entry."
            for (UserInput entry : entries) {
                // methods come from userInput
             // entry is the UserInput object that we named entry
                writer.write(
                    entry.getSleepTime()+ "," +                   
                    entry.getWokenUp() + "," +
                    entry.getSleepRating() + "," +
                    entry.getEnergy() + "," +
                    entry.getDreamLog() + "\n"  // new line 
                );
            }
            // catch the exceptions when theres errors print message
            // instead of crashing file
        } catch (IOException e) {
            System.out.println("Error saving entries.");
        }
    }

    // Load all SleepEntry objects from the CSV file
    public ArrayList<UserInput> loadEntries() {
        // creates empty array [], later our entrys are added
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
                String[] data = line.split(",");
                // gets the csv data into numbered format, 0 is date, 1 is
                // bedtime etc...
                UserInput entry = new UserInput(
                        Integer.parseInt(data[0]),                         // date str
                        Integer.parseInt(data[2]),       // wake ups int
                        Integer.parseInt(data[3]),       // sleep quality int
                        data[4],                         // energy str
                        data[5]                          // dream str
                );
                // after reading each entry list becomes [entry1, entry2 ... ] etc
                entries.add(entry);
            }
            // clode read mode
            scanner.close();
            // deals w missing data, invailid input etc
        } catch (Exception e) {
            System.out.println("Error loading entries.");
        }
        // returns loaded entires
        // ArrayList<SleepEntry> entries =
      //   csv.loadEntries();
        return entries;
    }
}


// user logs sleep example:
//UserEntry e1 =
//new UserEntry(
//    "2025-11-01",
//    "10:30 PM",
//    "6:45 AM",
//    2,
//    8,
//    "Happy",
//    "Flying"
//);

// csv.saveEntry(e1);

// this is what would be in csv:
// 2025-11-01,10:30 PM,6:45 AM,2,8,Happy,Flying







