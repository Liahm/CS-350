import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class Ranking {
    public static void Ranking()
    {

        System.out.println("Enter the prompt for your ranking question:");
        Scanner questionRank = new Scanner(System.in);
        String questionRankValue = questionRank.nextLine();
        //if questionBoolValue == quit, then quit.
        System.out.println("Enter correct choice");
        Scanner answerRank = new Scanner(System.in);
        String answerRankValue = answerRank.nextLine();

    }

    public static void TestRanking()
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
