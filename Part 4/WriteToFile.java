import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by elee on 4/17/2017.
 */
public class WriteToFile {
    public static String voiceName = "kevin16";
    public static VoiceManager voiceManager = VoiceManager.getInstance();
    public static Voice voice = voiceManager.getVoice(voiceName);
    public static void CreateWrite(String question, String[] options, String[] answer, String fileName, String questionType,String directory) //This works for both test and Survey
    {
        voice.allocate();
        try {
            new File(directory).mkdirs(); //Create temp folder
            if(questionType.equals("Essay") || questionType.equals("Short-Answer"))
            {
                List<String> quest = Arrays.asList("Question "+ questionType +":", question, "", "", "",""); //Create a list of questions and answers
                Path file = Paths.get(directory+ questionType +"-"+fileName + ".txt"); //get the file name
                voice.speak(file.toString());
                System.out.println(file);
                Files.write(file, quest, Charset.forName("UTF-8")); //write all the strings in the list into the file.

            }
            else {
                List<String> quest = Arrays.asList("Question " + questionType +":", question, "Options:", Arrays.toString(options).replace("[", "").replace("]", ""), "Answer: ", Arrays.toString(answer).replace("[", "").replace("]", "")); //Create a list of questions and answers

                Path file = Paths.get(directory + questionType + "-" + fileName + ".txt"); //get the file name
                voice.speak(file.toString());
                System.out.println(file);
                Files.write(file, quest, Charset.forName("UTF-8")); //write all the strings in the list into the file.
            }
        }
        catch(IOException e)
        {
            System.out.println("File Read Error: " + e.getMessage());
            if(directory == "tmpSurvey/")
            {
                System.out.println("Returning to Survey options");
                Create.CreateSurvey();
            }
            else if(directory == "tmpTest/")
            {
                System.out.println("Returning to Test options");
                Create.CreateSurvey();
            }
            else
            {
                String[] args={};
                System.out.println("Returning to Main menu");
                Survey.main(args);
            }

        }
    }
}
