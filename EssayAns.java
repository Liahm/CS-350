import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */

/**
 Summary:
 Create a users named file and question
 */
public class EssayAns {
    public static void EssayAns() //Working since 4/11/2017
    {
        String[] blank = {};
        String tempSurvey = "tmpSurvey\\";

        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after creating a question.'");
        System.out.println("Enter the name of the file: ");
        Scanner Scan = new Scanner(System.in);
        String fileNameEssayAnsValue = Scan.nextLine();
        if(fileNameEssayAnsValue.equals("quit")) //Quit if user inputs quit
        {
            Create.CreateSurvey();
        }
        System.out.println("Enter the prompt for your essay answer question:");
        String questionEssayValue = Scan.nextLine(); //get question
        WriteToFile.CreateWrite(questionEssayValue, blank, blank, fileNameEssayAnsValue, tempSurvey); //print to file
        System.out.println("question created.");
        Create.CreateSurvey(); //return
    }
    /**
     Summary:
     Create a users named file and question.
     */
    public static void TestEssayAns()
    {
        String tempTest = "tmpTest\\";
        String[] blank = {};

        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.'");
        System.out.println("Enter the name of the file: ");
        Scanner Scan = new Scanner(System.in);
        String fileNameValue = Scan.nextLine();
        if(fileNameValue.equals("quit"))
        {
            Create.CreateTest();
        }
        System.out.println("Enter the prompt for your essay answer question:");
        String questionEssayValue = Scan.nextLine();

        WriteToFile.CreateWrite(questionEssayValue, blank, blank, fileNameValue, tempTest); //Essay has no answer or options
        System.out.println("question created.");
        Create.CreateTest();
    }
}
