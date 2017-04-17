import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class Load {
    /**
     * Summary:
     * Ask the user to select a file to open.
     * Load said file folder information into the temp folder.
     * That's it.
     */
    public static void LoadSurvey() //HW2 - load to memory
    {
        System.out.println("Please enter the name of the file that you want to load. Only the name, no txt required. \n");
        Scanner scan = new Scanner(System.in); //get the file name
        String loadingSurveyValue = scan.nextLine() + ".txt";
    }

    public static void LoadTest() //HW2
    {
        System.out.println("Please enter the name of the file that you want to load. \n");
        Scanner scan = new Scanner(System.in); //get the file name
        String loadingSurveyValue = scan.nextLine();
    }

}
