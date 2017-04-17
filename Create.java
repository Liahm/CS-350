import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class Create {
    public static void CreateSurvey()
    {
        System.out.println("Please select the type of survey"); //HW2
        System.out.println("1) True/False"); //HW2
        System.out.println("2) Multiple Choice"); //HW2
        System.out.println("3) Short Answer"); //HW2
        System.out.println("4) Essay Answer"); //HW2
        System.out.println("5) Matching"); //HW2
        System.out.println("6) Rank the choices"); //HW2
        System.out.println("7) Back");
        System.out.println("E) Exit");

        Scanner input = new Scanner(System.in);
        String createSurveyValue = input.nextLine();
        switch(createSurveyValue)
        {
            case "1":
                Bool.Bool(); //done
                break;
            case "2":
                Choices.Choices();
                break;
            case "3":
                ShortAns.ShortAns(); //done
                break;
            case "4":
                EssayAns.EssayAns(); //done
                break;
            case "5":
                Matching.Matching();
                break;
            case "6":
                Ranking.Ranking();
                break;
            case "7":
                SurveyC.SurveyC();
                break;
            case "8":
            case "e":
            case "E":
            case "exit":
            case "Exit":
                Exit.Exit();
                break;
            default :
                System.out.println("Please enter a valid value \n");
                CreateSurvey();

        }
    }
    public static void CreateTest()
    {
        System.out.println("Please select the type of Test"); //HW2
        System.out.println("1) True/False"); //HW2
        System.out.println("2) Multiple Choice"); //HW2
        System.out.println("3) Short Answer"); //HW2
        System.out.println("4) Essay Answer"); //HW2
        System.out.println("5) Matching"); //HW2
        System.out.println("6) Rank the choices"); //HW2
        System.out.println("7) Back");
        System.out.println("E) Exit");

        Scanner input = new Scanner(System.in);
        String createSurveyValue = input.nextLine();
        switch(createSurveyValue)
        {
            case "1":
                Bool.TestBool();
                break;
            case "2":
                Choices.TestChoices();
                break;
            case "3":
                ShortAns.TestShortAns();
                break;
            case "4":
                EssayAns.TestEssayAns();
                break;
            case "5":
                Matching.TestMatching();
                break;
            case "6":
                Ranking.TestRanking();
                break;
            case "b":
            case "B":
            case "7":
                SurveyC.SurveyC();
                break;
            case "8":
            case "e":
            case "E":
            case "exit":
            case "Exit":
                Exit.Exit();
                break;
            default :
                System.out.println("Please enter a valid value \n");
                CreateTest();

        }
    }
}
