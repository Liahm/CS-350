import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.io.IOException;

/**
 * Created by Ariete on 4/22/2017.
 */
public abstract class Output {
    public static String newLine = System.getProperty("line.separator");
    public static String voiceName = "kevin16";
    public static VoiceManager voiceManager = VoiceManager.getInstance();
    public static Voice voice = voiceManager.getVoice(voiceName);
    public static void intro(int choice)
    {
        voice.allocate();
        switch (choice) {
            case 1:
                voice.speak("Welcome");
                System.out.println("Welcome");
                voice.speak("1) Survey Menu.");
                System.out.println("1) Survey Menu.");
                voice.speak("2) Test Menu.");
                System.out.println("2) Test Menu.");
                voice.speak("E) Exit.");
                System.out.println("E) Exit.");
                break;
            case 2:
                voice.speak("1) Create a new Survey.");
                System.out.println("1) Create a new Survey."); //HW2
                voice.speak("2) Display a Survey.");
                System.out.println("2) Display a Survey."); //HW2
                voice.speak("3) Load a Survey.");
                System.out.println("3) Load a Survey."); //HW2
                voice.speak("4) Save a Survey.");
                System.out.println("4) Save a Survey."); //HW2
                voice.speak("5) Edit a Survey.");
                System.out.println("5) Edit a Survey."); //HW3
                voice.speak("6) Take a Survey.");
                System.out.println("6) Take a Survey."); //HW3
                voice.speak("7) Tabulate a Survey.");
                System.out.println("7) Tabulate a Survey."); //HW3
                voice.speak("8) Back.");
                System.out.println("8) Back.");
                voice.speak("E) Exit.");
                System.out.println("E) Exit."); //8, e, E, Exit, exit will work
                break;
            case 3:
                voice.speak("1) Create a new Test.");
                System.out.println("1) Create a new Test.");
                voice.speak("2) Display a Test.");
                System.out.println("2) Display a Test.");
                voice.speak("3) Load a Test.");
                System.out.println("3) Load a Test.");
                voice.speak("4) Save a Test.");
                System.out.println("4) Save a Test.");
                voice.speak("5) Edit a Test.");
                System.out.println("5) Edit a Test."); //HW3
                voice.speak("6) Take a Test.");
                System.out.println("6) Take a Test."); //HW3
                voice.speak("7) Tabulate a Test.");
                System.out.println("7) Tabulate a Test.");
                voice.speak("8) Grade a Test.");
                System.out.println("8) Grade a Test."); //HW3
                voice.speak("8) Back.");
                System.out.println("8) Back.");
                voice.speak("E) Exit");
                System.out.println("E) Exit"); //8, e, E, Exit, exit will work
                break;
        }
    }
    public static void create(int choice)
    {
        voice.allocate();
        switch (choice)
        {
            case 1:
                voice.speak("Please select the type of survey");
                System.out.println("Please select the type of survey"); //HW2
                voice.speak("1) True/False");
                System.out.println("1) True/False"); //HW2
                voice.speak("2) Multiple Choice");
                System.out.println("2) Multiple Choice"); //HW2
                voice.speak("3) Short Answer");
                System.out.println("3) Short Answer"); //HW2
                voice.speak("4) Essay Answer");
                System.out.println("4) Essay Answer"); //HW2
                voice.speak("5) Matching");
                System.out.println("5) Matching"); //HW2
                voice.speak("6) Rank the choices");
                System.out.println("6) Rank the choices"); //HW2
                voice.speak("7) Back");
                System.out.println("7) Back");
                voice.speak("E) Exit");
                System.out.println("E) Exit");
                break;
            case 2:
                voice.speak("Please select the type of Test");
                System.out.println("Please select the type of Test"); //HW2
                voice.speak("1) True/False");
                System.out.println("1) True/False"); //HW2
                voice.speak("2) Multiple Choice");
                System.out.println("2) Multiple Choice"); //HW2
                voice.speak("3) Short Answer");
                System.out.println("3) Short Answer"); //HW2
                voice.speak("4) Essay Answer");
                System.out.println("4) Essay Answer"); //HW2
                voice.speak("5) Matching");
                System.out.println("5) Matching"); //HW2
                voice.speak("6) Rank the choices");
                System.out.println("6) Rank the choices"); //HW2
                voice.speak("7) Back");
                System.out.println("7) Back");
                voice.speak("E) Exit");
                System.out.println("E) Exit");
                break;
        }
    }
    public static void saved()
    {
        voice.allocate();
        voice.speak("All files are already saved");
        System.out.println("All files are already saved");
    }

    public static void incorrectInput()
    {
        voice.allocate();
        voice.speak("Incorrect Input, please retry.");
        System.out.println("Incorrect Input, please retry.");
    }
    public static void returningOptions(String name)
    {
        voice.allocate();
        voice.speak("Returning to "+name+" options, please retry." + newLine);
        System.out.println("Returning to "+name+" options, please retry." + newLine);
    }
    public static void emptyInput()
    {
        voice.allocate();
        voice.speak("Incorrect Input, \"Empty String\" detected.");
        System.out.println("Incorrect Input, \"Empty String\" detected.");
    }
    public static void saveFile(int choice)
    {
        voice.allocate();
        switch (choice)
        {
            case 1:
                voice.speak("Do you want to save the file?(Y/N)");
                System.out.println("Do you want to save the file?(Y/N)");
                break;
            case 2:
                voice.speak("Files saved" + newLine);
                System.out.println("Files saved" + newLine);
                break;
        }
    }
    public static void invalidInput() {
        voice.allocate();
        voice.speak("Please enter a valid value" +newLine);
        System.out.println("Please enter a valid value" +newLine); //print this out if input is invalid and repeat.
    }
    public static void loadInfo(int choice)
    {
        voice.allocate();
        switch (choice) {
            case 1:
                voice.speak("Please enter the name of the folder that you want to load.");
                System.out.println("Please enter the name of the folder that you want to load.");
                break;
            case 2:
                voice.speak("Please enter the name of the file that you want to load.");
                System.out.println("Please enter the name of the file that you want to load.");
                break;
            case 3:
                voice.speak("Files loaded." + newLine);
                System.out.println("Files loaded." + newLine);
                break;
        }
    }
    public static void noFolder(int choice)
    {
        voice.allocate();
        switch (choice) {
            case 1:
                voice.speak("Folder doesn't exist." + newLine);
                System.out.println("Folder doesn't exist." + newLine);
                break;
            case 2:
                voice.speak("File doesn't exist." + newLine);
                System.out.println("File doesn't exist." + newLine);
                break;
            case 3:
                voice.speak("No folders/files found.");
                System.out.println("No folders/files found.");
        }
    }
    public static void noClue()
    {
        voice.allocate();
        voice.speak("This should never happen, but there was an error?");
        System.out.println("This should never happen, but there was an error?");
    }
    public static void displayFiles(String loadingFile, int choice, String name)
    {
        voice.allocate();
        switch (choice) {
            case 1:
                System.out.println("==============================================");
                voice.speak("All the files from " + loadingFile);
                System.out.println("All the files from " + loadingFile);
                System.out.println("==============================================");
                break;
            case 2:
                System.out.println("==============================================");
                voice.speak("All the folders from " + name);
                System.out.println("All the folders from " + name);
                System.out.println("==============================================");
                break;
        }
    }
    public static void EditPhrases(int choice)
    {
        voice.allocate();
        switch (choice) {
            case 1:
                voice.speak("Files found in temporary folder, do you want to Delete/Save files or Ignore (D/S/I)?");
                System.out.println("Files found in temporary folder, do you want to Delete/Save files or Ignore (D/S/I)?");
                break;
            case 2:
                voice.speak("Would you like to load a folder?");
                System.out.println("Would you like to load a folder?");
                break;
            case 3:
                voice.speak("Please select folder to load");
                System.out.println("Please select folder to load");
                break;
            case 4:
                voice.speak("Which file would like like to edit?");
                System.out.println("Which file would like like to edit?");
                break;
            case 5:
                voice.speak("Do you want to edit the Question/Options?");
                System.out.println("Do you want to edit the Question/Options?");
                break;
            case 6:
                voice.speak("Do you want to edit the Question/Options/Answer? (Q/O/A)");
                System.out.println("Do you want to edit the Question/Options/Answer? (Q/O/A)");
                break;
            case 7:
                voice.speak("You can't modify options for this question");
                System.out.println("You can't modify options for this question");
                break;
            case 8:
                voice.speak("Do you want to Delete/Add?");
                System.out.println("Do you want to Delete/Add?");
                break;
            case 9:
                voice.speak("Choose option to delete(Please write the full option or type All to delete all options)");
                System.out.println("Choose option to delete(Please write the full option or type All to delete all options)");
                break;
            case 10:
                voice.speak("Please write the new question.");
                System.out.println("Please write the new question.");
                break;
            case 11:
                voice.speak("Edit saved" + newLine);
                System.out.println("Edit saved" + newLine);
                break;
            case 12:
                voice.speak("Please write the");
                System.out.println("Please write the");
                break;
            case 13:
                voice.speak("All options deleted.");
                System.out.println("All options deleted.");
                break;
            case 14:
                voice.speak("Please write the option you want to add. It will be recorded as the last option");
                System.out.println("Please write the option you want to add. It will be recorded as the last option");
                break;
            case 15:
                voice.speak("This is a survey edit, Answers can't be editted.");
                System.out.println("This is a survey edit, Answers can't be editted.");
                break;
        }
    }
    public static void EditPhrases2(int choice, String input)
    {
        voice.allocate();
        switch (choice)
        {
            case 1:
                voice.speak("The option "+ input + " has been deleted." + newLine);
                System.out.println("The option "+ input + " has been deleted." + newLine);
                break;
            case 2:
                voice.speak("The option "+ input + " has been added to the option list." +newLine);
                System.out.println("The option "+ input + " has been added to the option list." +newLine);
                break;
            case 3:
                voice.speak("The answer "+ input + " has been added to the answer list." +newLine);
                System.out.println("The answer "+ input + " has been added to the answer list." +newLine);
                break;
        }
    }
    public static void TakePhrases(int choice)
    {
        voice.allocate();
        switch(choice)
        {
            case 1:
                voice.speak("Please identify yourself. (your username will be used to create a file with all your scores)");
                System.out.println("Please identify yourself. (your username will be used to create a file with all your scores)");
                break;
            case 2:
                voice.speak("Which Test would like to take?");
                System.out.println("Which Test would like to take?");
                break;
            case 3:
                System.out.println("==============================================");
                voice.speak("Instructions. For T/F questions your answer should be T or F.");
                System.out.println("Instructions. For T/F questions your answer should be T or F.");
                voice.speak("If you press Enter, your answer will be set.");
                System.out.println("If you press Enter, your answer will be set.");
                voice.speak("For matching answers, your answer should be a 1, b 2, c 3. Order doesn't matter as long as that's the format");
                System.out.println("For matching answers, your answer should be a 1, b 2, c 3. Order doesn't matter as long as that's the format");
                voice.speak("For Multiple choice write the letter and end it with a period for answers followed by a comma if there are multiple. (a., b.) ");
                System.out.println("For Multiple choice write the letter and end it with a period for answers followed by a comma if there are multiple. (a., b.) ");
                voice.speak("For ranking please write your answer in this format a>b>c>d");
                System.out.println("For ranking please write your answer in this format a>b>c>d");
                System.out.println("==============================================");
                break;

        }
    }

    public static void gradeTabulate(int choice, String name)
    {
        voice.allocate();
        switch (choice)
        {
            case 1:
                voice.speak("Select which " + name +" to tabulate");
                System.out.println("Select which " + name +" to tabulate");
                break;
            case 2:
                voice.speak("Select the question to tabulate (Write the #) or write All");
                System.out.println("Select the question to tabulate (Write the #) or write All");
                break;
            case 3:
                voice.speak("Select "+name+ " folder");
                System.out.println("Select "+name+ " folder");
                break;
            case 4:
                voice.speak(name + " has been loaded");
                System.out.println(name + " has been loaded");
                break;
            case 5:
                voice.speak("Results");
                System.out.println("Results");
                break;
            case 6:
                voice.speak("Tabulation");
                System.out.println("Tabulation");
                break;
            case 7:
                voice.speak(name);
                System.out.println(name);
                break;
        }
    }
    public static void gradeTabulateValue(int choice, int tabulate)
    {
        voice.allocate();
        switch (choice)
        {
            case 1:
                voice.speak("True: " + tabulate);
                System.out.println("True: " + tabulate);
                break;
            case 2:
                voice.speak("False: " + tabulate);
                System.out.println("False: " + tabulate);
                break;

        }
    }
    public static void gradeTabulate2(int choice, String name, int value)
    {
        voice.allocate();
        switch(choice)
        {
            case 1:
                voice.speak(name + ": " + value);
                System.out.println(name + ": " + value);
                break;
        }
    }

    public static void gradeTest(int choice)
    {
        voice.allocate();
        switch(choice)
        {
            case 1:
                voice.speak("Manual Grading required for Essay/short answer.");
                System.out.println("Manual Grading required for Essay/short answer.");
                break;
            case 2:
                voice.speak("Full marks on this question");
                System.out.println("Full marks on this question");
                break;
        }
    }
    public static void grading(int grade)
    {
        voice.allocate();
        voice.speak("Your grade is: " + grade + " plus the amount of essays/short answers");
        System.out.println("Your grade is: " + grade + " plus the amount of essays/short answers");
    }
    public static void gradingFail(int number)
    {
        voice.allocate();
        voice.speak("0 on question " + number);
        System.out.println("0 on question " + number);
    }


}
