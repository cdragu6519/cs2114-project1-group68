package sleepify;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 *  Stores and manages all UserInput sleep records entered by the user 
 *  Provides methods for adding and accessing entries 
 * 
 *  @author carol
 *  @version Sep 14, 2026
 */
public class StoreAllUserInput
{
    private ArrayList<UserInput> entries;
    private CSVManager csvManager;
 
    
    // ----------------------------------------------------------
    /**
     * Creates a new object and initializes an empty list to store
     * the all time UserInputs  
     */
    public StoreAllUserInput() {
        csvManager = new CSVManager("sleepData.csv");
        entries = csvManager.loadEntries(); 
    }
    
   
    // ----------------------------------------------------------
    /**
     * Adds a UserInpt object to the list of entries
     * @param entry
     */
    public void addEntry(UserInput entry) {
        if (entry != null) {
            entries.add(entry);
            
            //save the updated list after added
            csvManager.saveEntries(entries);
            
        }
        else {
            System.out.println("Entry cannot be added");
        }
        
    }
   
    
    // ----------------------------------------------------------
    /**
     * returns all stored sleep records form the user
     * @return ArrayList 
     */
    public ArrayList<UserInput> getEntries() {
        return entries;
    }
}

