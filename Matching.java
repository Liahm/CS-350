import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class Matching {
    public static void Matching()
    {

        System.out.println("Enter the prompt for your matching question:");
        Scanner questionMatch = new Scanner(System.in);
        String questionMatchValue = questionMatch.nextLine();
        //if questionBoolValue == quit, then quit.
        System.out.println("Enter correct choice");
        Scanner answerMatch = new Scanner(System.in);
        String answerMatchValue = answerMatch.nextLine();

    }

    public static void TestMatching()
    {
        String tempTest = "tmpTest\\";

        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.'");
        System.out.println("Enter the name of the file: ");
        Scanner fileNameBool = new Scanner(System.in);
        String fileNameValue = fileNameBool.nextLine();
        if(fileNameValue.equals("quit"))
        {
            Create.CreateTest();
        }
    }

}
