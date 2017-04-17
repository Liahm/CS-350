import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class Display {
    public static void DisplaySurvey() //HW2 - show to the screen
    {
        System.out.println("Please enter the name of the survey file that you are looking for. \n");
        Scanner displayingSurvey = new Scanner(System.in); //get the file name
        String displayingSurveyValue = displayingSurvey.nextLine();
        //Find a way to get the display the survey using that name.
        //It can be a text file!... now, if it is a txt file how would I look for "Question" and "Answer"?
        //Maybe print Question, then write whatever you want under question and when searching just return the line under question.
        //Kinda the same for XML since they are classes.
        //Open XML file that was called
        //read XML
        //Loop it.
        //End loop is displayingSurveyValue == "quit"
    }
    public static void DisplayTest() //HW2
    {
        System.out.println("Please enter the name of the test file that you are looking for. \n");
        Scanner displayingTest = new Scanner(System.in); //get the file name
        String displayingTestValue = displayingTest.nextLine();
    }
}
