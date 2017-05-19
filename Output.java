import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Ariete on 4/22/2017.
 */
public abstract class Output {
    public static String newLine = System.getProperty("line.separator");
    public static void intro(int choice)
    {
        switch (choice) {
            case 1:
                System.out.println("Welcome");
                System.out.println("1) Survey Menu.");
                System.out.println("2) Test Menu.");
                System.out.println("E) Exit.");
                break;
            case 2:
                System.out.println("1) Create a new Survey."); //HW2
                System.out.println("2) Display a Survey."); //HW2
                System.out.println("3) Load a Survey."); //HW2
                System.out.println("4) Save a Survey."); //HW2
                System.out.println("5) Edit a Survey."); //HW3
                System.out.println("6) Take a Survey."); //HW3
                System.out.println("7) Grade a Survey."); //HW3
                System.out.println("8) Back.");
                System.out.println("E) Exit."); //8, e, E, Exit, exit will work
                break;
            case 3:
                System.out.println("1) Create a new Test.");
                System.out.println("2) Display a Test.");
                System.out.println("3) Load a Test.");
                System.out.println("4) Save a Test.");
                System.out.println("5) Edit a Test."); //HW3
                System.out.println("6) Take a Test."); //HW3
                System.out.println("7) Grade a Test."); //HW3
                System.out.println("8) Back.");
                System.out.println("E) Exit"); //8, e, E, Exit, exit will work
                break;
        }
    }
    public static void saved()
    {
        System.out.println("All files are already saved");
    }

    public static void incorrectInput()
    {
        System.out.println("Incorrect Input, please retry.");
    }
    public static void returningOptions(String name)
    {
        System.out.println("Returning to "+name+" options, please retry." + newLine);
    }
    public static void emptyInput()
    {
        System.out.println("Incorrect Input, \"Empty String\" detected.");
    }
    public static void saveFile(int choice)
    {
        switch (choice)
        {
            case 1:
                System.out.println("Do you want to save the file?(Y/N)");
                break;
            case 2:
                System.out.println("Files saved" + newLine);
                break;
        }

    }
    public static void invalidInput() {
        System.out.println("Please enter a valid value" +newLine); //print this out if input is invalid and repeat.
    }
    public static void loadInfo(int choice)
    {
        switch (choice) {
            case 1:
                System.out.println("Please enter the name of the folder that you want to load.");
                break;
            case 2:
                System.out.println("Please enter the name of the file that you want to load.");
                break;
            case 3:
                System.out.println("Files loaded." + newLine);
                break;
        }
    }
    public static void noFolder(int choice)
    {
        switch (choice) {
            case 1:
                System.out.println("Folder doesn't exist." + newLine);
                break;
            case 2:
                System.out.println("File doesn't exist." + newLine);
                break;
            case 3:
                System.out.println("No folders/files found.");
        }
    }
    public static void noClue()
    {
        System.out.println("This should never happen, but there was an error?");
    }
    public static void displayFiles(String loadingFile, int choice, String name)
    {
        switch (choice) {
            case 1:
                System.out.println("==============================================");
                System.out.println("All the files from " + loadingFile);
                System.out.println("==============================================");
                break;
            case 2:
                System.out.println("==============================================");
                System.out.println("All the folders from " + name);
                System.out.println("==============================================");
                break;
        }
    }
    public static void EditPhrases(int choice)
    {
        switch (choice) {
            case 1:
                System.out.println("Files found, do you want to Delete/Save files or Ignore (D/S/I)?");
                break;
            case 2:
                System.out.println("Would you like to load a folder?");
                break;
            case 3:
                System.out.println("Please select folder to load");
                break;
            case 4:
                System.out.println("Which file would like like to edit?");
                break;
            case 5:
                System.out.println("Do you want to edit the Question/Options?");
                break;
            case 6:
                System.out.println("Do you want to edit the Question/Options/Answer? (Q/O/A)");
                break;
            case 7:
                System.out.println("You can't modify options for this question");
                break;
            case 8:
                System.out.println("Do you want to Delete/Add/");
            case 10:
                System.out.println("Please write the new question.");
                break;
            case 11:
                System.out.println("Edit saved" + newLine);
                break;
            case 12:
                System.out.println("Please write the");
        }
    }
}
