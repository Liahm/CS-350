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
    public static void Choices() //Working as of 4/12/2017
    {
        String tempSurvey = "tmpSurvey\\";
        Scanner scan = new Scanner(System.in);
        List<String> optionChoiceList = new ArrayList<String>();
        String[] optionChoiceResult = new String[optionChoiceList.size()];
        String[] blank = {};
        char quit = 'Y';
        int i =0; //how many times a loop ran

        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.");
        System.out.println("Enter the name of the file: ");
        String fileNameChoicesValue = scan.nextLine();
        if(fileNameChoicesValue.equals("quit")) //go back.
        {
            Create.CreateSurvey();
        }
        System.out.println("Enter the prompt for your multiple choice question:"); //Get choice question
        String questionChoiceValue = scan.nextLine();


        while(quit != 'N') //exit the loop so that the user can have as many options
        {
            System.out.println("Enter choices "+ i + "."); //Get choice options
            String optionChoiceValue = scan.nextLine(); //gets user choice
            optionChoiceList.add(optionChoiceValue); //add to the list

            System.out.println("Enter another option? (Y/N)"); //It actually takes any inputs. If value starts with N, then that's another story.
            String word = scan.next(); //Get the next user input
            word = word.toUpperCase(); //change to uppercase if lowercase
            quit = word.charAt(0); //if it's N, then leave
            i++;
        }
        while(i > 0) {
            optionChoiceResult = optionChoiceList.toArray(optionChoiceResult); //populate the array
            i--;
        }

        WriteToFile.CreateWrite(questionChoiceValue, optionChoiceResult, blank, fileNameChoicesValue, tempSurvey);

        System.out.println("question created.");
        Create.CreateSurvey(); //go back to creating the survey.
    }

    /**
     Summary:
     Create a question with users named file, question, choices and answers
     */
    public static void TestChoices()
    {
        String tempTest = "tmpTest\\";
        Scanner scan = new Scanner(System.in);
        List<String> optionChoiceList = new ArrayList<String>();
        String[] optionChoiceResult = new String[optionChoiceList.size()];
        List<String> answerChoiceList = new ArrayList<String>();
        String[] answerChoiceResult = {};

        char quit = 'Y';
        int i =0;

        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.");
        System.out.println("Enter the name of the file: ");
        String fileNameValue = scan.nextLine();
        if(fileNameValue.equals("quit"))
        {
            Create.CreateTest();
        }
        System.out.println("Enter the prompt for your multiple choice question:"); //Get choice question
        String questionChoiceValue = scan.nextLine();


        while(quit != 'N') //exit the loop so that the user can have as many options
        {
            System.out.println("Enter choices "+ i+1 + "."); //Get choice options
            String optionChoiceValue = scan.nextLine(); //gets user choice
            optionChoiceList.add(optionChoiceValue); //add to the list

            System.out.println("Enter another option? (Y/N)"); //It actually takes any inputs. If value starts with N, then that's another story.
            String word = scan.next(); //Get the next user input
            word = word.toUpperCase(); //change to uppercase if lowercase
            quit = word.charAt(0); //if it's N, then leave
            i++;
        }
        while(i > 0) {
            optionChoiceResult = optionChoiceList.toArray(optionChoiceResult); //populate the array
            i--;
        }
        while(quit != 'N')
        {
            System.out.println("Enter answer/s " + i+1 +"."); //Get choice answers
            String answerChoiceValue = scan.nextLine();
            answerChoiceList.add(answerChoiceValue);
            //ISSUE HERE - - - - - - - FIX LATER - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - -
            //Check if the answer choice is part of the options.
            if(!answerChoiceValue.equals(optionChoiceResult))
            { //possible bug when comparing. If answer isn't one of the options, then error. This will not fix it.
                System.out.println("That answer is outside of the scope, please input a correct one.");
                //Add something that will delete that newest input.
                //Debug line before and after that change just to check if it deleted the correct one.
                //Then this will fix it.
            }

            System.out.println("Enter another option? (Y/N)"); //It actually takes any inputs. If value starts with N, then that's another story.
            String word = scan.next(); //Get the next user input
            word = word.toUpperCase(); //change to uppercase if lowercase
            quit = word.charAt(0); //if it's N, then leave
            i++;
        }
        while(i > 0) {
            answerChoiceResult = answerChoiceList.toArray(answerChoiceResult); //populate the array
            i--;
        }

        WriteToFile.CreateWrite(questionChoiceValue, optionChoiceResult, answerChoiceResult, fileNameValue, tempTest);

        System.out.println("question created.");
        Create.CreateTest();
    }
}
