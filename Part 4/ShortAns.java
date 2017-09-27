import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */

/**
 Summary:
 Create a users named file and question.
 */
public class ShortAns {
    public static String voiceName = "kevin16";
    public static VoiceManager voiceManager = VoiceManager.getInstance();
    public static Voice voice = voiceManager.getVoice(voiceName);
    public static void ShortAns() //Working since 4/11/2017
    {
        voice.allocate();
        String[] blank = {};
        String tempSurvey = "tmpSurvey\\";
        //Ask user for file name
        voice.speak("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.'");
        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.'");
        voice.speak("Enter the name of the file: ");
        System.out.println("Enter the name of the file: ");
        Scanner scan = new Scanner(System.in);
        String fileNameShortAnsValue = scan.nextLine();
        if(fileNameShortAnsValue.equals("quit"))
        {
            Create.CreateSurvey(); //Go back if the user desires
        }
        voice.speak("Enter the prompt for your short answer question:");
        System.out.println("Enter the prompt for your short answer question:");
        String questionShortValue = scan.nextLine(); //Get user question

        WriteToFile.CreateWrite(questionShortValue, blank, blank, fileNameShortAnsValue, "Short-Answer",tempSurvey); //Print to file
        voice.speak("question created.");
        System.out.println("question created.");
        Create.CreateSurvey(); //Go back
    }
    /**
     Summary:
     Create a users named file and question and an answer.
     */
    public static void TestShortAns() //Working since 4/17/2017 - yea, took a break
    {
        voice.allocate();
        String[] blank = {};
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
        voice.speak("Enter the prompt for your short answer question:");
        System.out.println("Enter the prompt for your short answer question:");
        String questionShortValue = scan.nextLine();

        WriteToFile.CreateWrite(questionShortValue, blank, blank, fileNameValue, "Short-Answer",tempTest);
        voice.speak("question created.");
        System.out.println("question created.");
        Create.CreateTest();
    }
}
