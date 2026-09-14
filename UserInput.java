package sleepify;
// -------------------------------------------------------------------------
/**
 *  UserInput class
 *  @author catherinearockia
 *  @version Sep 14, 2026
 */
public class UserInput {

 //UserInput fields
      
        private double sleepTime;
        private int wokenUp;
        private int sleepRating;
        private String energy;
        private String dreamLog;
        
        // ----------------------------------------------------------
        /**
         * Create a new UserInput object.
         * @param sleepTime
         * @param wokenUp
         * @param sleepRating
         * @param energy
         * @param dreamLog
         */
        public UserInput(double sleepTime,int wokenUp, int sleepRating, String energy, String dreamLog) {
            
            this.sleepTime = sleepTime;
            this.wokenUp = wokenUp;
            this.sleepRating = sleepRating;
            this.energy = energy;
            this.dreamLog = dreamLog;
        }
        
        
        // ----------------------------------------------------------
        /**
         * @return sleepTime
         */
        public double getSleepTime() {
            
            return sleepTime;
        }
        
        // ----------------------------------------------------------
        /**
         * @return wokenUp
         */
        public int getWokenUp() {
            
            return wokenUp;
            
        }
        
        // ----------------------------------------------------------
        /**
         * @return sleepRating
         */
        public int getSleepRating() {
            
            return sleepRating;
            
        }
        
        // ----------------------------------------------------------
        /**
         * @return energy
         */
        public String getEnergy() {
            
            return energy;
            
        }
        
        // ----------------------------------------------------------
        /**
         * @return dreamLog
         */
        public String getDreamLog() {
            
            return dreamLog;
            
        }


}
