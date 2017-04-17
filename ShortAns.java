import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */

/**
 Summary:
 Create a users named file and question.
 */
public class ShortAns {
    public static void ShortAns() //Working since 4/11/2017
    {
        String[] blank = {};
        String tempSurvey = "tmpSurvey\\";
        //Ask user for file name
        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after creating a question.");
        System.out.println("Enter the name of the file: ");
        Scanner scan = new Scanner(System.in);
        String fileNameShortAnsValue = scan.nextLine();
        if(fileNameShortAnsValue.equals("quit"))
        {
            Create.CreateSurvey(); //Go back if the user desires
        }
        System.out.println("Enter the prompt for your short answer question:");
        String questionShortValue = scan.nextLine(); //Get user question

        WriteToFile.CreateWrite(questionShortValue, blank, blank, fileNameShortAnsValue, tempSurvey); //Print to file
        System.out.println("question created.");
        Create.CreateSurvey(); //Go back
    }
    /**
     Summary:
     Create a users named file and question and an answer.
     */
    public static void TestShortAns() //Working since 4/17/2017 - yea, took a break
    {
        String[] blank = {};
        String tempTest = "tmpTest\\";

        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.");
        System.out.println("Enter the name of the file: ");
        Scanner scan = new Scanner(System.in);
        String fileNameValue = scan.nextLine();
        if(fileNameValue.equals("quit"))
        {
            Create.CreateTest();
        }
        System.out.println("Enter the prompt for your short answer question:");
        String questionShortValue = scan.nextLine();

        System.out.println("Enter correct Answer");
        String[] answerShortValue = {scan.nextLine()}; //Get user answer

        WriteToFile.CreateWrite(questionShortValue, blank, answerShortValue, fileNameValue, tempTest);
        System.out.println("question created.");
        Create.CreateTest();
    }
}
