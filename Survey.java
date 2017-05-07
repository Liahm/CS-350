import java.util.Scanner;
import java.lang.String;

public class Survey {
    public static void main(String[] args) //initial procedure
    {
        Output.intro(1);

        Scanner input = new Scanner(System.in);
        String firstValue = input.nextLine();
        switch (firstValue) {
            case "1":
                SurveyC.SurveyC();//HW2
                break;
            case "2":
                Test.Test();//HW2
                break;
            case "3":
            case "e":
            case "E":
            case "exit":
            case "Exit":
                Exit.Exit();
                break;
            default:
                Output.invalidInput();
                main(args);
        }
    }
}
