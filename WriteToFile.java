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
    public static void CreateWrite(String question, String[] options, String[] answer, String fileName, String questionType,String directory) //This works for both test and Survey
    {
        try {
            new File(directory).mkdirs(); //Create temp folder
            List<String> quest = Arrays.asList("Question:", question, "Options:",  Arrays.toString(options), "Answer: ", Arrays.toString(answer)); //Create a list of questions and answers

            Path file = Paths.get(directory+ questionType +"-"+fileName + ".txt"); //get the file name
            System.out.println(file);
            Files.write(file, quest, Charset.forName("UTF-8")); //write all the strings in the list into the file.
        }
        catch(IOException e)
        {
            System.out.println("File Read Error: " + e.getMessage());
            if(directory == "tmpSurvey\\")
            {
                System.out.println("Returning to Survey options");
                Create.CreateSurvey();
            }
            else if(directory == "tmpTest\\")
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
