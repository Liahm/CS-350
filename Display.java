import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class Display {
    /**
     * Get Survey/test name from the user
     * Print entire survey/test into console
     */
    public static void DisplaySurvey() //HW2 - show to the screen
    {
        System.out.println("Please enter the name of the survey file that you are looking for. \n");
        Scanner displayingSurvey = new Scanner(System.in); //get the file name
        String displayingSurveyValue = displayingSurvey.nextLine();
    }
    public static void DisplayTest() //HW2
    {
        System.out.println("Please enter the name of the test file that you are looking for. \n");
        Scanner displayingTest = new Scanner(System.in); //get the file name
        String displayingTestValue = displayingTest.nextLine();
    }
}
