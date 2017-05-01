import java.util.Scanner;
import java.lang.String;

public class Survey {


    public static void main(String[] args) //initial procedure
    {
        Output.intro();

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
                System.out.println("Please enter a valid value \n"); //print this out if input is invalid and repeat.
                main(args);
        }
    }
}
