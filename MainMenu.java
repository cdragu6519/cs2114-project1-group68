package sleepify;

import java.util.ArrayList;
import java.util.Scanner;


public class MainMenu {
    
    
        private StoreAllUserInput storeAllUserInput;
        private InputValidator inputValidator;
        private SleepAnalyzer sleepAnalyzer;
        private CSVManager csvManager;
        private Scanner scanner;
 
        
    
        public MainMenu()  {
            
            storeAllUserInput = new StoreAllUserInput();
            inputValidator = new InputValidator();
            csvManager = new CSVManager("sleepData.csv");
            scanner = new Scanner(System.in);    
        }
     

        private boolean validateType(String input, String type, String question) {

            //sets up temporary input variables inputD and inputI to check if inputValidator (question specific testing) will return as true/false
            double inputD = 0.0;
            int inputI = 0;
            
            // first if block of code checks if we are trying to scan a double
            // second if block calls inputValidator based on the specific question in order to make sure the input is fits question-based criteria (for sleepTime, input must be less than 24 hours
            // case 1) first condition passes, second one fails (returns false, reprompts user with question-based feedback
            // case 2) first condition passes, second passes (returns false, reprompts user with data-type feedback
            // case 3) first condition fails, (returns false, reprompts user with data-type feedback
            // case 4) first condition passes, second condition passes (returns true, now it can be stored as a parameter to then be stores in a UserInput instance.
            //***** THIS VALIDATETYPE METHOD IS USED IN USERENTRY FOR EACH PARAEMETER
            //***** THIS LOGIC IS APPLIED FOR EXPECTED STRING, DOUBLE, AND INT PARAMETERS.
            
            if (type.equals("double")) {
                try {
                    inputD = Double.parseDouble(input);
                    if (question.equals("validateSleepHour")) {
                        if(!inputValidator.validateSleepHour(inputD)) {
                            System.out.println("Sorry, your input is way too high. Please try again: ");
                            return false;
                        }
                        
                    }
                    return true;
                } catch (NumberFormatException e) {
                    System.out.println("Sorry, your input isn't a number. Please try again: ");
                    return false;
                }
            }
            
            
            

            if (type.equals("int")) {
                try {
                    inputI = Integer.parseInt(input);
                    if (question.equals("validateSleepRating")) {
                        if(!inputValidator.validateSleepRating(inputI)) {
                            System.out.println("Sorry, validation for sleep Rating is failing");
                            return false;
                        }    
                        
                    }
                    
                    if (question.equals("validateWokenUp")) {
                        if(!inputValidator.validateSleepRating(inputI)) {
                            System.out.println("sorry, validation for naps is failing");
                            return false;
                        }    
                        
                    }
                    return true;
                } catch (NumberFormatException e) {
                    System.out.println("Sorry, your input isn't a number. Please try again: ");
                    return false;
                }
            }

            if (type.equals("String")) {
                
                    if(question.equals("validateEnergyLevel")) {
                        
                        if (!inputValidator.validateEnergyLevel(input)) {
                            System.out.println("sorry, validation for ENERGY is failing, please reenter");
                            return false;
                        }
                        
                        return true;
                    }
                
            }
            
            return false;
            
            //all validation is working, above return statement isn't needed but avoids Syntax errors
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
                System.out.println("3:   Save Sleep Records");
                System.out.println("4:   Exit");
                System.out.println("Your Selection: ");
                String selection = scanner.nextLine();
                
                switch(selection) { 
                    case "1":
                        createEntry();
                        break;
                    case "2":
                        viewStats();
                        break;
                    case "3":
                        saveRecords();
                    case "4":
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
            double sleepTimeEntry = 0;
            boolean wokenUpCheck = false;
            int wokenUpEntry = 0;
            boolean sleepRatingCheck = false;
            int sleepRatingEntry = 0;
            boolean energyCheck = false;
            String energyEntry = "low";
            
            
            String userInput = "";
           // boolean dreamLogCheck = false;
         //   String dreamLogEntry;
            
            
            System.out.println("Welcome! Please enter, or type skip, to answer the following questions: " );
            System.out.println("");
            
            while (sleepCheck == false) {
                System.out.println("Please enter the amount of sleep (to the nearest hour) you got last night: ");
                
                
                
                
                userInput = scanner.nextLine();
                
                while (!validateType(userInput, "double","validateSleepHour")) {
                    
                    userInput = scanner.nextLine();
                    
                }
                
                
                sleepTimeEntry = Double.parseDouble(userInput);
                
                sleepCheck = true;
                
                System.out.println("");
                
            }
            
            System.out.println("");
            
            
            while (wokenUpCheck == false) {
                System.out.println("Please enter the amount of times you woke up (whole number): ");
                
                
                
                
                userInput = scanner.nextLine();
                
                while (!validateType(userInput, "int","validateWokenUp")) {
                    
                    userInput = scanner.nextLine();
                    
                }
                
                
                wokenUpEntry = Integer.parseInt(userInput);
                
                wokenUpCheck = true;
                
                System.out.println("");
            }
            
            
            
            
            while (sleepRatingCheck == false) {
                System.out.println("Please rate your sleep from 0-10 (whole number): ");
                
                
                
                
                userInput = scanner.nextLine();
                
                while (!validateType(userInput, "int","validateSleepRating")) {
                    
                    userInput = scanner.nextLine();
                    
                }
                
                
                sleepRatingEntry = Integer.parseInt(userInput);
                
                sleepRatingCheck = true;
                
                System.out.println("");
            }
            
            while (energyCheck == false) {
                System.out.println("Please describe your energy level using low, medium, or high (no spaces): ");
                
                
                
                
                userInput = scanner.nextLine();
                
                while (!validateType(userInput, "String","validateEnergyLevel")) {
                    
                    userInput = scanner.nextLine();
                    
                }
                
                
                energyEntry = userInput;
                
                energyCheck = true;
                
                System.out.println("");
            }

            UserInput entry = new UserInput(sleepTimeEntry,wokenUpEntry,sleepRatingEntry,energyEntry,"0");
            storeAllUserInput.addEntry(entry);
            System.out.println("Awesome! Your last night sleep was safely recorded.");
        }

        
        public void viewStats() {
         ArrayList<UserInput> sleepEntries = storeAllUserInput.getEntries();
            
         if (sleepEntries.isEmpty()) {
             System.out.println("Sorry, we currently have no sleep data " 
                 + "from you. Come back for your statistics after seven days!");
             }
         
         System.out.println("Welcome to your sleep summary.");
         ArrayList<UserInput> entries = storeAllUserInput.getEntries();
         ArrayList<Double> sleepTimes = new ArrayList<>();

         for (UserInput entry : entries) {
             sleepTimes.add(entry.getSleepTime());
             }

         SleepAnalyzer sleepanalyzer = new SleepAnalyzer(sleepTimes);
         sleepanalyzer.averageSleep();
         sleepanalyzer.highestSleepDay();
         sleepanalyzer.lowestSleepDay();
         
         }
        
        
        public void saveRecords() {
            ArrayList<UserInput> sleepEntries = storeAllUserInput.getEntries();
            
            for (UserInput entry : sleepEntries) {
                System.out.println(entry);
            }
            
            csvManager.saveEntries(sleepEntries);
            System.out.println("Your sleep records have been saved! Sweet dreams!");
        }
        
        public static void main(String[] args) {
            MainMenu menu = new MainMenu();
            menu.startProgram();
        }
    
}
