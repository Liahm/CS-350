import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */


public class Choices {
    /**
     Summary:
     Create a question with users named file, question, choices.
     */
    public static String voiceName = "kevin16";
    public static VoiceManager voiceManager = VoiceManager.getInstance();
    public static Voice voice = voiceManager.getVoice(voiceName);
    public static void Choices() //Working as of 4/12/2017
    {
        voice.allocate();
        String tempSurvey = "tmpSurvey\\";
        Scanner scan = new Scanner(System.in);
        List<String> optionChoiceList = new ArrayList<String>();
        String[] optionChoiceResult = new String[optionChoiceList.size()];
        String[] blank = {};
        char quit = 'Y';
        int i =0; //how many times a loop ran

        voice.speak("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.");
        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.");
        voice.speak("Enter the name of the file: ");
        System.out.println("Enter the name of the file: ");
        String fileNameChoicesValue = scan.nextLine();
        if(fileNameChoicesValue.equals("quit")) //go back.
        {
            Create.CreateSurvey();
        }
        voice.speak("Enter the prompt for your multiple choice question:");
        System.out.println("Enter the prompt for your multiple choice question:"); //Get choice question
        String questionChoiceValue = scan.nextLine();


        while(quit != 'N') //exit the loop so that the user can have as many options
        {
            voice.speak("Enter choices "+ (i+1) + ".");
            System.out.println("Enter choices "+ (i+1) + "."); //Get choice options
            Scanner scan2 = new Scanner(System.in); //Another scanner so that it stops here every run.
            String optionChoiceValue = scan2.nextLine(); //gets user choice
            optionChoiceList.add(optionChoiceValue); //add to the list
            voice.speak("Enter another option? (Y/N)");
            System.out.println("Enter another option? (Y/N)"); //It actually takes any inputs. If value starts with N, then that's another story.
            String word = scan.next(); //Get the next user input
            word = word.toUpperCase(); //change to uppercase if lowercase
            quit = word.charAt(0); //if it's N, then leave
            i++;
        }

        optionChoiceResult = optionChoiceList.toArray(optionChoiceResult); //populate the array


        WriteToFile.CreateWrite(questionChoiceValue, optionChoiceResult, blank, fileNameChoicesValue,"Multiple-Choices",tempSurvey);
        voice.speak("Question created.");
        System.out.println("Question created.");
        Create.CreateSurvey(); //go back to creating the survey.
    }

    /**
     Summary:
     Create a question with users named file, question, choices and answers
     */
    public static void TestChoices()
    {
        voice.allocate();
        String tempTest = "tmpTest\\";
        Scanner scan = new Scanner(System.in);
        List<String> optionChoiceList = new ArrayList<String>();
        String[] optionChoiceResult = new String[optionChoiceList.size()];
        List<String> answerChoiceList = new ArrayList<String>();
        String[] answerChoiceResult = {};

        char quit = 'Y';
        int i =0;
        voice.speak("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.");
        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.");
        voice.speak("Enter the name of the file: ");
        System.out.println("Enter the name of the file: ");
        String fileNameValue = scan.nextLine();
        if(fileNameValue.equals("quit"))
        {
            Create.CreateTest();
        }
        voice.speak("Enter the prompt for your multiple choice question:");
        System.out.println("Enter the prompt for your multiple choice question:"); //Get choice question
        String questionChoiceValue = scan.nextLine();


        while(quit != 'N') //exit the loop so that the user can have as many options
        {
            voice.speak("Enter choices " + (i+1) + ".");
            System.out.println("Enter choices " + (i+1) + "."); //Get choice options
            Scanner scan2 = new Scanner(System.in);
            String optionChoiceValue = scan2.nextLine(); //gets user choice
            optionChoiceList.add(optionChoiceValue); //add to the list
            voice.speak("Enter another option? (Y/N)");
            System.out.println("Enter another option? (Y/N)"); //It actually takes any inputs. If value starts with N, then that's another story.
            String word = scan.next(); //Get the next user input
            word = word.toUpperCase(); //change to uppercase if lowercase
            quit = word.charAt(0); //if it's N, then leave
            i++;
        }
        optionChoiceResult = optionChoiceList.toArray(optionChoiceResult); //populate the array

        quit = 'Y';
        i = 0;
        while(quit != 'N')
        {
            voice.speak("Enter answer/s " + (i+1) +".");
            System.out.println("Enter answer/s " + (i+1) +"."); //Get choice answers
            Scanner scan2 = new Scanner(System.in);
            String answerChoiceValue = scan2.nextLine();
            answerChoiceList.add(answerChoiceValue);
            voice.speak("Enter another option? (Y/N)");
            System.out.println("Enter another option? (Y/N)"); //It actually takes any inputs. If value starts with N, then that's another story.
            String word = scan.next(); //Get the next user input
            word = word.toUpperCase(); //change to uppercase if lowercase
            quit = word.charAt(0); //if it's N, then leave
            i++;
        }

        answerChoiceResult = answerChoiceList.toArray(answerChoiceResult); //populate the array


        WriteToFile.CreateWrite(questionChoiceValue, optionChoiceResult, answerChoiceResult, fileNameValue, "Multiple-Choices",tempTest);
        voice.speak("question created.");
        System.out.println("question created.");
        Create.CreateTest();
    }
}
