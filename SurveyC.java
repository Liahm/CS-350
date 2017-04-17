import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class SurveyC {
    public static void SurveyC()
    {
        String[] args={};
        System.out.println("1) Create a new Survey."); //HW2
        System.out.println("2) Display a Survey."); //HW2
        System.out.println("3) Load a Survey."); //HW2
        System.out.println("4) Save a Survey."); //HW2
        System.out.println("5) Edit a Survey."); //HW3
        System.out.println("6) Take a Survey."); //HW3
        System.out.println("7) Grade a Survey."); //HW3
        System.out.println("8) Back.");
        System.out.println("E) Exit."); //8, e, E, Exit, exit will work

        Scanner input = new Scanner(System.in);
        String surveyValue = input.nextLine();
        switch(surveyValue)
        {
            case "1":
                Create.CreateSurvey();//HW2
                break;
            case "2":
                Display.DisplaySurvey();//HW2
                break;
            case "3":
                Load.LoadSurvey();//HW2
                break;
            case "4":
                Save.SaveSurvey();//HW2
                break;
            case "5":
                Edit.EditSurvey();//HW3
                break;
            case "6":
                Take.TakeSurvey();//HW3
                break;
            case "7":
                Grade.GradeSurvey();//HW3
                break;
            case "8":
            case "back":
            case "b":
                Survey.main(args);
                break;
            case "9":
            case "e":
            case "E":
            case "exit":
            case "Exit":
                Exit.Exit();
                break;
            default :
                System.out.println("Please enter a valid value \n");
                Survey.main(args);

        }
    }
}
