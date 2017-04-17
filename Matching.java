import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */

public class Matching {
    /**
     Summary:
     Create a users named file, question and matching options
     */
    public static void Matching()
    {
        String tempSurvey = "tmpSurvey\\";
        Scanner scan = new Scanner(System.in);
        String[] blank = {};
        int i =0;
        char quit = 'Y';
        List<String> optionMatchList = new ArrayList<String>();
        String[] optionMatchResult = new String[optionMatchList.size()];

        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.");
        System.out.println("Enter the name of the file: ");
        String fileNameChoicesValue = scan.nextLine();
        if(fileNameChoicesValue.equals("quit")) //go back.
        {
            Create.CreateSurvey();
        }
        System.out.println("Enter the prompt for your matching question:");
        String questionMatchValue = scan.nextLine();


        //Gather all the first choices
        while(quit != 'N') //exit the loop so that the user can have as many options
        {
            System.out.println("Enter choices "+ i + "."); //Get choice options
            String optionChoiceValue = scan.nextLine(); //gets user choice
            optionMatchList.add(optionChoiceValue); //add to the list

            System.out.println("Enter another option? (Y/N)"); //It actually takes any inputs. If value starts with N, then that's another story.
            String word = scan.next(); //Get the next user input
            word = word.toUpperCase(); //change to uppercase if lowercase
            quit = word.charAt(0); //if it's N, then leave
            i++;
        }
        while(i > 0) {
            optionMatchResult = optionMatchList.toArray(optionMatchResult); //populate the array
            i--;
        }
        //Gather all the Second choices
        while(quit != 'N') //exit the loop so that the user can have as many options
        {
            System.out.println("Enter choices "+ i + "."); //Get choice options
            String optionChoiceValue = scan.nextLine(); //gets user choice
            optionMatchList.add(optionChoiceValue); //add to the list

            System.out.println("Enter another option? (Y/N)"); //It actually takes any inputs. If value starts with N, then that's another story.
            String word = scan.next(); //Get the next user input
            word = word.toUpperCase(); //change to uppercase if lowercase
            quit = word.charAt(0); //if it's N, then leave
            i++;
        }
        while(i > 0) {
            optionMatchResult = optionMatchList.toArray(optionMatchResult); //populate the array
            i--;
        }
        //Might have to do custom write to file.. MAYBE
        WriteToFile.CreateWrite(questionMatchValue, optionMatchResult, blank, fileNameChoicesValue, tempSurvey);

        System.out.println("question created.");
        Create.CreateSurvey(); //go back to creating the survey.

    }
    /**
        Summary:
        Create a users named file, question and matching options and correct answers
     */
    public static void TestMatching()
    {
        Scanner scan = new Scanner(System.in);

        String tempTest = "tmpTest\\";
        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.");
        System.out.println("Enter the name of the file: ");
        String fileNameChoicesValue = scan.nextLine();
        if(fileNameChoicesValue.equals("quit")) //go back.
        {
            Create.CreateTest();
        }

    }

}
