import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class SurveyC {
    public static void SurveyC()
    {
        String[] args={};
        Output.intro(2);

        Scanner input = new Scanner(System.in);
        String surveyValue = input.nextLine();
        switch(surveyValue)
        {
            case "1":
                Create.CreateSurvey();//HW2
                break;
            case "2":
                Display.Display("Survey", false);//HW2
                break;
            case "3":
                Load.Load("Survey", "tmpSurvey", true);//HW2
                break;
            case "4":
                Save.Save("Survey", "tmpSurvey", true);//HW2
                break;
            case "5":
                Edit.EditSurvey(true, "tmpSurvey", "Survey");//HW3
                break;
            case "6":
                Take.TakeSurvey("Survey", true);//HW3
                break;
            case "7":
                Grade.TabulateSurvey("Survey");//HW3
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
                Output.invalidInput();
                SurveyC();

        }
    }
}
