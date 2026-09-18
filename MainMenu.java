package sleepify;

import java.util.ArrayList;
import java.util.Scanner;


public class MainMenu {
    
    
        private StoreAllUserInput storeAllUserInput;
        private InputValidator inputValidator;
      //  private SleepAnalyzer sleepAnalyzer;
        private CSVManager csvManager;
        private Scanner scanner;
 
        
    
        public MainMenu()  {
            
            storeAllUserInput = new StoreAllUserInput();
            inputValidator = new InputValidator();
           // sleepAnalyzer = new SleepAnalyzer();
          //  csvManager = new CSVManager();
            scanner = new Scanner(System.in);
            
        }
        
        public void startProgram() {
            boolean run = true;
            
            System.out.println("*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
            System.out.println("*       ~ welcome to sleepify ~        *");
            System.out.println("*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
            
            while (run) {
            
                System.out.println("");
                System.out.println("Please select a number to pick your selection: ");
                System.out.println("1:   Create a New Sleep Entry");
                System.out.println("2:   View Sleep Statistics");
                System.out.println("3:   Exit");
                System.out.println("Your Selection: ");
                
                String selection = scanner.nextLine();
                
                switch(selection) {
                    
                    case "1":
                        createEntry();
                        break;
                //    case "2":
                 //       viewStats();
                      //  break;
        //add exit case
                    case "3":
                        run = false;
                        System.out.println("");
                        System.out.println("   Thanks for using sleepify. Sweet Dreams ~   ");
                        System.out.println("");
                        break;
                    default:
                        System.out.println("Invalid input. Please select from the list.");
                }
     
            }
            
        }
        
        public void createEntry() {
            boolean sleepCheck = false;
            int sleepTimeEntry = 0;
            boolean wokenUpCheck = false;
            int wokenUpEntry = 0;
            boolean sleepRatingCheck = false;
            int sleepRatingEntry = 0;
            boolean energyCheck = false;
            String energyEntry = "low";
           // boolean dreamLogCheck = false;
         //   String dreamLogEntry;
            
            
            System.out.println("Welcome! Please enter, or type skip, to answer the following questions: " );
            System.out.println("");
            
            while (sleepCheck == false) {
                System.out.println("Please enter the amount of sleep (to the nearest hour) you got last night: ");
                sleepTimeEntry = scanner.nextInt();
                if (inputValidator.validateSleepHour(sleepTimeEntry)) {
                    sleepCheck = true;
                }
                System.out.println("");
            }
            
            
            while (wokenUpCheck == false) {
                System.out.println("Now, how many times did you wake up in the middle of the night: ");
                wokenUpEntry = scanner.nextInt();
                if (inputValidator.validateSleepHour(wokenUpEntry)) {
                    wokenUpCheck = true;
                }
                System.out.println("");
            }
            
            while (sleepRatingCheck == false) {
                System.out.println("Now, how would you rate your sleep last night from 0-10? : ");
                sleepRatingEntry = scanner.nextInt();
                if (inputValidator.validateSleepRating(sleepRatingEntry)) {
                    sleepRatingCheck = true;
                }
                System.out.println("");
            }
            
            while (energyCheck == false) {
                System.out.println("Now, would you say your energy level today is low, level, or high?: ");
                energyEntry = scanner.nextLine();
                if (inputValidator.validateEnergyLevel(energyEntry)) {
                    energyCheck = true;
                }
                System.out.println("");
            }
            
            UserInput entry = new UserInput(sleepTimeEntry,wokenUpEntry,sleepRatingEntry,energyEntry,"0");
            
            storeAllUserInput.addEntry(entry);
            
            System.out.println("Awesome! Your last night sleep was safely recorded.");
        }
        
        
       // public void viewStats() {
            
            
        //    ArrayList<UserInput> sleepEntries = storeAllUserInput.getEntries();
            
        //    if (sleepEntries.isEmpty()) {
        //        System.out.println("Sorry, we currently have no sleep data "
        //            + "from you. Come back for your statistics after seven days!");
        //    }
            
        //    System.out.println("");
         //   System.out.println("Welcome to your sleep summary.");
         //   System.out.println("");
         //   System.out.println("Your average sleep for the past seven days is " + ((Object)sleepEntries).getAverageSleep());
            
       // }
        
        
        public void saveRecords() {
            ArrayList<UserInput> sleepEntries = storeAllUserInput.getEntries();
    
            csvManager.saveEntries(sleepEntries);
            
            System.out.println("Your sleep records have been saved! Sweet dreams!");
        }
        
        public static void main(String[] args) {
            MainMenu menu = new MainMenu();
            menu.startProgram();
        }
    
}
