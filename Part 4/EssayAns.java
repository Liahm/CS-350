import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */

/**
 Summary:
 Create a users named file and question
 */
public class EssayAns {
    public static String voiceName = "kevin16";
    public static VoiceManager voiceManager = VoiceManager.getInstance();
    public static Voice voice = voiceManager.getVoice(voiceName);
    public static void EssayAns() //Working since 4/11/2017
    {
        voice.allocate();
        String[] blank = {};
        String tempSurvey = "tmpSurvey\\";

        voice.speak("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.'");
        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.'");
        voice.speak("Enter the name of the file: ");
        System.out.println("Enter the name of the file: ");
        Scanner Scan = new Scanner(System.in);
        String fileNameEssayAnsValue = Scan.nextLine();
        if(fileNameEssayAnsValue.equals("quit")) //Quit if user inputs quit
        {
            Create.CreateSurvey();
        }
        voice.speak("Enter the prompt for your essay answer question:");
        System.out.println("Enter the prompt for your essay answer question:");
        String questionEssayValue = Scan.nextLine(); //get question
        WriteToFile.CreateWrite(questionEssayValue, blank, blank, fileNameEssayAnsValue,"Essay",tempSurvey); //print to file
        voice.speak("question created.");
        System.out.println("question created.");
        Create.CreateSurvey(); //return
    }
    /**
     Summary:
     Create a users named file and question.
     */
    public static void TestEssayAns()
    {
        voice.allocate();
        String tempTest = "tmpTest\\";
        String[] blank = {};

        voice.speak("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.'");
        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.'");
        voice.speak("Enter the name of the file: ");
        System.out.println("Enter the name of the file: ");
        Scanner Scan = new Scanner(System.in);
        String fileNameValue = Scan.nextLine();
        if(fileNameValue.equals("quit"))
        {
            Create.CreateTest();
        }
        voice.speak("Enter the prompt for your essay answer question:");
        System.out.println("Enter the prompt for your essay answer question:");
        String questionEssayValue = Scan.nextLine();

        WriteToFile.CreateWrite(questionEssayValue, blank, blank, fileNameValue, "Essay",tempTest); //Essay has no answer or options
        voice.speak("question created.");
        System.out.println("question created.");
        Create.CreateTest();
    }
}
