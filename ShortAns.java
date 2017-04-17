import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class ShortAns {
    public static void ShortAns() //Working since 4/11/2017
    {
        String[] blank = {};
        String tempSurvey = "tmpSurvey\\";

        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after creating a question.'");
        System.out.println("Enter the name of the file: ");
        Scanner fileNameShortAns = new Scanner(System.in);
        String fileNameShortAnsValue = fileNameShortAns.nextLine();
        if(fileNameShortAnsValue.equals("quit"))
        {
            Create.CreateSurvey();
        }
        System.out.println("Enter the prompt for your short answer question:");
        Scanner questionShort = new Scanner(System.in);
        String questionShortValue = questionShort.nextLine();
        //if questionBoolValue == quit, then quit.
        /*
        System.out.println("Enter correct choice");
        Scanner answerShort = new Scanner(System.in); //Find if there are matching words, so change this
        String[] answerShortValue = {answerShort.nextLine()};
        */
        WriteToFile.CreateWrite(questionShortValue, blank, blank, fileNameShortAnsValue, tempSurvey);
        System.out.println("question created.");
        Create.CreateSurvey();
    }

    public static void TestShortAns()
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
