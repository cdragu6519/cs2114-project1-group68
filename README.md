# CS2114 Project 1 Group 68

A brief, one-sentence description of what your Java application does.

## Prerequisites
Ensure you have the Java Development Kit (JDK) installed:
* **Java SE 11** or higher.
* Verify your installation by running: `java -version`

## How to Compile and Run

### Option 1: Compiling Manually (Command Line)
Navigate to the root directory of the project and follow these steps:

1. **Compile all Java files:**
   ```bash
   javac src/*.java -d bin
   ```
   *(This compiles all files in the `src` folder and places the `.class` outputs into a `bin` folder).*

2. **Run the application:**
   ```bash
   java -cp bin Main
   ```
   *(Replace `Main` with the actual name of the class containing your `public static void main(String[] args)` method).*

---

### Option 2: Using the Provided Script (Optional Quick Run)
If you are using Java 11 or newer and your `Main.java` doesn't strictly depend on separate manual compilation steps for basic execution, you can sometimes run the entry point directly, though standard compilation (Option 1) is preferred.

![Alternative Text](cs2114-project1-group68/systemDiag.png)

