import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class Load {
    public static void LoadSurvey() //HW2 - load to memory
    {
        System.out.println("Please enter the name of the file that you want to load. Only the name, no txt required. \n");
        Scanner loadingSurvey = new Scanner(System.in); //get the file name
        String loadingSurveyValue = loadingSurvey.nextLine() + ".txt";
    }

    public static void LoadTest() //HW2
    {
        System.out.println("Please enter the name of the file that you want to load. \n");
        Scanner loadingSurvey = new Scanner(System.in); //get the file name
        String loadingSurveyValue = loadingSurvey.nextLine();
    }

}
