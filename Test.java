import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class Test {
    public static void Test()
    {
        String[] args={};

        Output.intro(3);

        Scanner input = new Scanner(System.in);
        String testValue = input.nextLine();
        switch(testValue)
        {
            case "1":
                Create.CreateTest();//HW2
                break;
            case "2":
                Display.Display("Test");//HW2
                break;
            case "3":
                Load.Load("Test","tmpTest", true);//HW2
                break;
            case "4":
                Save.Save("Test", "tmpTest", true);//HW2
                break;
            case "5":
                Edit.EditTest();//HW3
                break;
            case "6":
                Take.TakeTest();//HW3
                break;
            case "7":
                Grade.TabulateTest();//HW3
                break;
            case "8":
                Grade.GradeTest();//HW3
                break;
            case "9":
            case "back":
            case "b":
                Survey.main(args);
                break;
            case "0":
            case "e":
            case "E":
            case "exit":
            case "Exit":
                Exit.Exit();
                break;
            default :
                Output.invalidInput();
                Test();

        }
    }
}
