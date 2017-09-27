import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class Create {
    public static void CreateSurvey()
    {
        Output.create(1);

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
                Output.invalidInput();
                CreateSurvey();

        }
    }
    public static void CreateTest()
    {
        Output.create(2);

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
                Output.invalidInput();
                CreateTest();

        }
    }
}
