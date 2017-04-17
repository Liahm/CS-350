import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class EssayAns {
    public static void EssayAns() //Working since 4/11/2017
    {
        String[] blank = {};
        String tempSurvey = "tmpSurvey\\";

        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after creating a question.'");
        System.out.println("Enter the name of the file: ");
        Scanner fileNameEssayAns = new Scanner(System.in);
        String fileNameEssayAnsValue = fileNameEssayAns.nextLine();
        if(fileNameEssayAnsValue.equals("quit"))
        {
            Create.CreateSurvey();
        }
        System.out.println("Enter the prompt for your essay answer question:");
        Scanner questionEssay = new Scanner(System.in);
        String questionEssayValue = questionEssay.nextLine();
        //if questionBoolValue == quit, then quit.
        /*
        System.out.println("Enter correct choice");
        Scanner answerEssay = new Scanner(System.in); //Find if there are matching words
        String answerEssayValue = answerEssay.nextLine();
        */
        WriteToFile.CreateWrite(questionEssayValue, blank, blank, fileNameEssayAnsValue, tempSurvey);
        System.out.println("question created.");
        Create.CreateSurvey();
    }

    public static void TestEssayAns()
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
