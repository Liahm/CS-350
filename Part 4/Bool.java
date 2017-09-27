import java.util.Scanner;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
/**
 * Created by elee on 4/17/2017.
 */

/**
 *  Summary:
 *  Creates a file with users named file and question.
*/
public class Bool {
    public static String voiceName = "kevin16";
    public static VoiceManager voiceManager = VoiceManager.getInstance();
    public static Voice voice = voiceManager.getVoice(voiceName);
    public static void Bool() //Working as of 4/8/2017
    {
        voice.allocate();
        String[] tF = {"T/F"}; //What the user sees.
        String[] answerBoolValue = {}; //Blank
        String tempSurvey = "tmpSurvey\\";

        voice.speak("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.'");
        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.'");
        voice.speak("Enter the name of the file: ");
        System.out.println("Enter the name of the file: ");
        Scanner scan = new Scanner(System.in);
        String fileNameValue = scan.nextLine();
        if(fileNameValue.equals("quit"))
        {
            Create.CreateSurvey();
        }
        voice.speak("Enter the prompt for your True/False question:");
        System.out.println("Enter the prompt for your True/False question:"); //Replace prompt to question?
        String questionBoolValue = scan.nextLine(); //Are these supposed to be 1 question per file or multiple?

        WriteToFile.CreateWrite(questionBoolValue, tF, answerBoolValue, fileNameValue, "T-F",tempSurvey);
        voice.speak("question created.");
        System.out.println("question created.");
        Create.CreateSurvey(); //go back to creating the survey.
    }

    public static void TestBool() //True or false survey - Working as of 4/8/2017 -
    {
        voice.allocate();
        String[] tF = {"T/F"}; //What the user sees.
        String tempTest = "tmpTest\\";
        voice.speak("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.'");
        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.'");
        voice.speak("Enter the name of the file: ");
        System.out.println("Enter the name of the file: ");
        Scanner scan = new Scanner(System.in);
        String fileNameValue = scan.nextLine();
        if(fileNameValue.equals("quit"))
        {
            Create.CreateTest();
        }
        voice.speak("Enter the prompt for your True/False question:");
        System.out.println("Enter the prompt for your True/False question:"); //Replace prompt to question?

        String questionBoolValue = scan.nextLine(); //Are these supposed to be 1 question per file or multiple?

        voice.speak("Enter correct choice");
        System.out.println("Enter correct choice"); //get the answer.
        String[] answerBoolValue = {scan.nextLine()}; //one answer, true or false
        //It is an array because of the printing to file function requires an array - especially for future questions
        if(!answerBoolValue[0].equals("t") && !answerBoolValue[0].equals("T") && !answerBoolValue[0].equals("true") && !answerBoolValue[0].equals("True") && !answerBoolValue[0].equals("f") && !answerBoolValue[0].equals("F") && !answerBoolValue[0].equals("false") && !answerBoolValue[0].equals("False") && !answerBoolValue[0].equals("TRUE") && !answerBoolValue[0].equals("FALSE"))
        {
            //System.out.println(answerBoolValue[0]);//debugging. Had issue with != making it loop in here. fixed it by using .equals.
            do
            {
                voice.speak("Your input isn't valid, Please enter a correct value for a true/false question.");
                System.out.println("Your input isn't valid, Please enter a correct value for a true/false question.");
                answerBoolValue[0] = scan.nextLine();
                //System.out.println(answerBoolValue[0]);//debug
            }while(!answerBoolValue[0].equals("t") && !answerBoolValue[0].equals("T") && !answerBoolValue[0].equals("true") && !answerBoolValue[0].equals("True") && !answerBoolValue[0].equals("f") && !answerBoolValue[0].equals("F") && !answerBoolValue[0].equals("false") && !answerBoolValue[0].equals("False") && !answerBoolValue[0].equals("TRUE") && !answerBoolValue[0].equals("FALSE"));
            WriteToFile.CreateWrite(questionBoolValue, tF, answerBoolValue, fileNameValue, "T-F",tempTest); //write to file
        }
        else
            WriteToFile.CreateWrite(questionBoolValue, tF, answerBoolValue, fileNameValue,"T-F", tempTest);
        voice.speak("question created.");
        System.out.println("question created.");
        Create.CreateTest(); //go back to creating the Test.

    }
}
