import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class Ranking {
    /**
        Summary:
        Create a users named file, question and ranking options
     */
    public static void Ranking()
    {

        System.out.println("Enter the prompt for your ranking question:");
        Scanner scan = new Scanner(System.in);
        String questionRankValue = scan.nextLine();
        //if questionBoolValue == quit, then quit.
        System.out.println("Enter correct choice");
        String answerRankValue = scan.nextLine();

    }
    /**
        Summary:
        Create a users named file, question and ranking options and correct order answer
     */
    public static void TestRanking()
    {
        String tempTest = "tmpTest\\";

        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.'");
        System.out.println("Enter the name of the file: ");
        Scanner scan = new Scanner(System.in);
        String fileNameValue = scan.nextLine();
        if(fileNameValue.equals("quit"))
        {
            Create.CreateTest();
        }
    }
}
