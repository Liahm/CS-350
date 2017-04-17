import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class Test {
    public static void Test()
    {
        String[] args={};

        System.out.println("1) Create a new Test.");
        System.out.println("2) Display a Test.");
        System.out.println("3) Load a Test.");
        System.out.println("4) Save a Test.");
        System.out.println("5) Edit a Test."); //HW3
        System.out.println("6) Take a Test."); //HW3
        System.out.println("7) Grade a Test."); //HW3
        System.out.println("8) Back.");
        System.out.println("E) Exit"); //8, e, E, Exit, exit will work

        Scanner input = new Scanner(System.in);
        String testValue = input.nextLine();
        switch(testValue)
        {
            case "1":
                Create.CreateTest();//HW2
                break;
            case "2":
                Display.DisplayTest();//HW2
                break;
            case "3":
                Load.LoadTest();//HW2
                break;
            case "4":
                Save.SaveTest();//HW2
                break;
            case "5":
                Edit.EditTest();//HW3
                break;
            case "6":
                Take.TakeTest();//HW3
                break;
            case "7":
                Grade.GradeTest();//HW3
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
                Test();

        }
    }
}
