import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class Ranking {
    /**
        Summary:
        Create a users named file, question and ranking options
     */
    public static void Ranking()
    {
        String tempSurvey = "tmpSurvey\\";
        Scanner scan = new Scanner(System.in);
        List<String> optionRankList = new ArrayList<String>();
        String[] optionRankResult = new String[optionRankList.size()];
        String[] blank = {};
        char quit = 'Y';
        int i =0; //how many times a loop ran

        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.");
        System.out.println("Enter the name of the file: ");
        String fileNameRankValue = scan.nextLine();
        if(fileNameRankValue.equals("quit")) //go back.
        {
            Create.CreateSurvey();
        }

        System.out.println("Enter the prompt for your ranking question:");
        String questionRankValue = scan.nextLine();


        while(quit != 'N') //exit the loop so that the user can have as many options
        {
            System.out.println("Enter choices "+ (i+1) + "."); //Get choice options
            Scanner scan2 = new Scanner(System.in); //Another scanner so that it stops here every run.
            String optionRankValue = scan2.nextLine(); //gets user choice
            optionRankList.add(optionRankValue); //add to the list

            System.out.println("Enter another option? (Y/N)"); //It actually takes any inputs. If value starts with N, then that's another story.
            String word = scan.next(); //Get the next user input
            word = word.toUpperCase(); //change to uppercase if lowercase
            quit = word.charAt(0); //if it's N, then leave
            i++;
        }

        optionRankResult = optionRankList.toArray(optionRankResult); //populate array

        WriteToFile.CreateWrite(questionRankValue, optionRankResult, blank, fileNameRankValue,"Ranking", tempSurvey);

        System.out.println("Question created.");
        Create.CreateSurvey(); //go back to creating the survey.

    }
    /**
        Summary:
        Create a users named file, question and ranking options and correct order answer
     */
    public static void TestRanking() //Working as of 4/18/2017 - not tested yet.
    {
        String tempTest = "tmpTest\\";
        List<String> optionRankList = new ArrayList<String>();
        String[] optionRankResult = new String[optionRankList.size()];
        List<String> answarRankList = new ArrayList<String>();
        String[] answarRankResult = new String[optionRankList.size()];
        char quit = 'Y';
        int i =0; //how many times a loop ran

        System.out.println("Once you start creating your file Type \"quit\" to go back. You can't go back after starting a question.'");
        System.out.println("Enter the name of the file: ");
        Scanner scan = new Scanner(System.in);
        String fileNameValue = scan.nextLine();
        if(fileNameValue.equals("quit"))
        {
            Create.CreateTest();
        }

        System.out.println("Enter the prompt for your ranking question:");
        String questionRankValue = scan.nextLine();


        while(quit != 'N') //exit the loop so that the user can have as many options
        {
            System.out.println("Enter choices "+ (i+1) + "."); //Get choice options
            Scanner scan2 = new Scanner(System.in); //Another scanner so that it stops here every run.
            String optionRankValue = scan2.nextLine(); //gets user choice
            optionRankList.add(optionRankValue); //add to the list

            System.out.println("Enter another option? (Y/N)"); //It actually takes any inputs. If value starts with N, then that's another story.
            String word = scan.next(); //Get the next user input
            word = word.toUpperCase(); //change to uppercase if lowercase
            quit = word.charAt(0); //if it's N, then leave
            i++;
        }

        optionRankResult = optionRankList.toArray(optionRankResult); //populate array

        System.out.println("Enter the answer in order separated by a \">\"");
        Scanner scan2 = new Scanner(System.in); //Another scanner so that it stops here every run.
        String answer = scan2.nextLine();
        answarRankList.add(answer);

        answarRankResult = answarRankList.toArray(answarRankResult);

        WriteToFile.CreateWrite(questionRankValue, optionRankResult, answarRankResult, fileNameValue, "Ranking", tempTest);

        System.out.println("Question created.");
        Create.CreateTest(); //go back to creating the survey.
    }
}
