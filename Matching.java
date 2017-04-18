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
    public static void Matching() //Working as of 4/18/2017
    {
        String tempSurvey = "tmpSurvey\\";
        Scanner scan = new Scanner(System.in);
        String[] blank = {};
        int i =0;
        int all = 0;
        char quit = 'Y';
        List<String> optionMatchList1 = new ArrayList<String>();
        List<String> optionMatchList2 = new ArrayList<String>();
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
            System.out.println("Enter First section choices "+ (i+1) + "."); //Get choice options
            Scanner scan2 = new Scanner(System.in); //Another scanner so that it stops here every run.
            String optionChoiceValue = scan2.nextLine(); //gets user choice
            optionMatchList1.add(optionChoiceValue); //add to the list

            System.out.println("Enter another option? (Y/N)"); //It actually takes any inputs. If value starts with N, then that's another story.
            String word = scan.next(); //Get the next user input
            word = word.toUpperCase(); //change to uppercase if lowercase
            quit = word.charAt(0); //if it's N, then leave
            i++;
            all++;
        }
        //optionMatchResult1 = optionMatchList1.toArray(optionMatchResult1); //populate the array

        quit = 'Y'; //Reuse quit variable
        i = 0;
        //Gather all the Second choices
        //Second choice can have as many as it pleases.
        while(quit != 'N') //exit the loop so that the user can have as many options
        {
            System.out.println("Enter Second section choices "+ (i+1) + "."); //Get choice options
            Scanner scan2 = new Scanner(System.in);
            String optionChoiceValue = scan2.nextLine(); //gets user choice
            optionMatchList2.add(optionChoiceValue); //add to the list

            System.out.println("Enter another option? (Y/N)"); //It actually takes any inputs. If value starts with N, then that's another story.
            String word = scan.next(); //Get the next user input
            word = word.toUpperCase(); //change to uppercase if lowercase
            quit = word.charAt(0); //if it's N, then leave
            i++;
        }


        if(all >= i) //Check which one of the two has more values
            optionMatchList.add(optionMatchList1 + "\t" + optionMatchList2);
        else
            optionMatchList.add(optionMatchList1 + "\t" + optionMatchList2);

        optionMatchResult = optionMatchList.toArray(optionMatchResult);


        WriteToFile.CreateWrite(questionMatchValue, optionMatchResult, blank, fileNameChoicesValue, tempSurvey);

        System.out.println("question created.");
        Create.CreateSurvey(); //go back to creating the survey.

    }
    /**
        Summary:
        Create a users named file, question and matching options and correct answers
     */
    public static void TestMatching() //Working as of 4/18/2017
    {
        String tempTest = "tmpTest\\";
        Scanner scan = new Scanner(System.in);
        int i =0;
        int all = 0;
        char quit = 'Y';
        List<String> optionMatchList1 = new ArrayList<String>();
        List<String> optionMatchList2 = new ArrayList<String>();
        List<String> optionMatchList = new ArrayList<String>();
        String[] optionMatchResult = new String[optionMatchList.size()];
        List<String> AnswerList = new ArrayList<String>();
        String[] Answers = new String[optionMatchList.size()];


        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.");
        System.out.println("Enter the name of the file: ");
        String fileNameChoicesValue = scan.nextLine();
        if(fileNameChoicesValue.equals("quit")) //go back.
        {
            Create.CreateTest();
        }
        System.out.println("Enter the prompt for your matching question:");
        String questionMatchValue = scan.nextLine();

        //----------------------Choices---------------------------------------------
        //Gather all the first choices
        while(quit != 'N') //exit the loop so that the user can have as many options
        {
            System.out.println("Enter First section choices "+ (i+1) + "."); //Get choice options
            Scanner scan2 = new Scanner(System.in); //Another scanner so that it stops here every run.
            String optionChoiceValue = scan2.nextLine(); //gets user choice
            optionMatchList1.add(optionChoiceValue); //add to the list

            System.out.println("Enter another option? (Y/N)"); //It actually takes any inputs. If value starts with N, then that's another story.
            String word = scan.next(); //Get the next user input
            word = word.toUpperCase(); //change to uppercase if lowercase
            quit = word.charAt(0); //if it's N, then leave
            i++;
            all++;
        }

        quit = 'Y'; //Reuse quit variable
        i = 0;
        //Gather all the Second choices
        //Second choice can have as many as it pleases.
        while(quit != 'N') //exit the loop so that the user can have as many options
        {
            System.out.println("Enter Second section choices "+ (i+1) + "."); //Get choice options
            Scanner scan2 = new Scanner(System.in);
            String optionChoiceValue = scan2.nextLine(); //gets user choice
            optionMatchList2.add(optionChoiceValue); //add to the list

            System.out.println("Enter another option? (Y/N)"); //It actually takes any inputs. If value starts with N, then that's another story.
            String word = scan.next(); //Get the next user input
            word = word.toUpperCase(); //change to uppercase if lowercase
            quit = word.charAt(0); //if it's N, then leave
            i++;
        }

        if(all >= i) //Check which one of the two has more values
            optionMatchList.add(optionMatchList1 + "\t" + optionMatchList2);
        else
            optionMatchList.add(optionMatchList1 + "\t" + optionMatchList2);

        optionMatchResult = optionMatchList.toArray(optionMatchResult);

        //----------------------------Answer-------------------------------------- BUGGED
        /** This version gathers all the answers and forces the creator to only make 1 connection between each value
        int number = 0;
        if(all >= i) {
            while (all > 0) //exit the loop so that the user can have as many options
            {
                System.out.println("Enter Answers " + (number + 1) + "."); //Get choice options
                Scanner scan2 = new Scanner(System.in);
                String answerValue = scan2.nextLine();
                AnswerList.add(answerValue);
                all--;
                number++;
            }
        }
        else
        {
            while (i > 0) //exit the loop so that the user can have as many options
            {
                System.out.println("Enter Answers " + (number + 1) + "."); //Get choice options
                Scanner scan2 = new Scanner(System.in);
                String answerValue = scan2.nextLine();
                AnswerList.add(answerValue);
                i--;
                number++;
            }
        }
         */
        quit = 'Y'; //Reuse quit variable
        i = 0;
        //Gather all the answers, no matter how many times it's required to be connected.
        while(quit != 'N') //exit the loop so that the user can have as many options
        {
            System.out.println("Enter Answers " + (i + 1) + "."); //Get choice options
            Scanner scan2 = new Scanner(System.in);
            String answerValue = scan2.nextLine();
            AnswerList.add(answerValue);

            System.out.println("Enter another option? (Y/N)"); //It actually takes any inputs. If value starts with N, then that's another story.
            String word = scan.next(); //Get the next user input
            word = word.toUpperCase(); //change to uppercase if lowercase
            quit = word.charAt(0); //if it's N, then leave
            i++;
        }

        Answers = AnswerList.toArray(Answers);
        //----------------------------Printing------------------------------------
        WriteToFile.CreateWrite(questionMatchValue, optionMatchResult, Answers, fileNameChoicesValue, tempTest);

        System.out.println("question created.");
        Create.CreateSurvey(); //go back to creating the survey.


    }

}
