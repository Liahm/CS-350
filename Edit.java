import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class Edit {
    /**
     * Summary
     * Check if the tmp folder contains files
     * if yes - ask user if he/she wants to delete those files or save and load new file
     * if yes to delete - delete and ask to load a new file
     * Load the desired directory
     * ask the user which file he/she wants to edit/delete
     * Ask the user if he/she wants to edit the question/options/answer
     * Load the array that pertains to that
     * ask if he/she wants to delete/add to the array.
     * Question - Will always have to write the full question again
     * Option - If add, then add(shouldn't work for T/F questions) - array.add(user input)
     *      If Matching, then load both arrays
     *      If replace, ask the user which one they want to replace, then delete and add the new on in that array position.
     *      If delete, delete. If empty, ask the user to add something if they want.
     * Answer - Modify the correct answer, same as above
     */
    public static String newLine = System.getProperty("line.separator");
    public static void EditSurvey() //HW3
    {
        String tmpFile = "tmpSurvey";
        char qq;
        int count = 0;
        File out = new File("./"+tmpFile); //Check files in tmp folder
        File[] listOfFiles = out.listFiles();
        if(!out.exists())
        {
            out.mkdir();
        }

        count = listOfFiles.length; //Number of files in the tmp folder
        if(count > 0) //if files exist
        {

            do{
                Output.EditPhrases(1); //ask for delete/save
                Scanner scan = new Scanner(System.in); //get the file name
                String answer = scan.nextLine();
                answer = answer.toUpperCase();
                qq = answer.charAt(0); //get either s or d
                if(qq == 'S')
                {
                    Save.Save("Survey", tmpFile, false); //save files and rerun to load
                    Output.EditPhrases(3);
                    EditSurvey();
                }
                else if(qq == 'D')
                {
                    for (int i = 0; i < listOfFiles.length; i++) {
                        listOfFiles[i].delete();
                    }
                    Output.EditPhrases(3);
                    EditSurvey();
                }
                else if(qq == 'I')
                {
                    break;
                }
            }while(qq != 'S' || qq != 'D' || qq != 'I');
        }
        if(count == 0)
            Load.Load("Survey", "tmpSurvey", false);

        //=================Check files in temp folder=====================
        Output.EditPhrases(4);
        for (int i = 0; i < listOfFiles.length; i++) { //Print files in the folder
            System.out.println(listOfFiles[i].getName());
        }
        //================================================================

        //=======================Choose file==============================

        Scanner scan = new Scanner(System.in);
        String loadFile = scan.nextLine();
        File fileValue = new File(out +"/"+ loadFile);

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileValue));
            String readLine = br.readLine();
            System.out.println("==============================================================");
            while(readLine !=null)
            {
                System.out.println(readLine);
                readLine = br.readLine();
            }
        }catch(IOException e)
        {
            System.out.println(e);
            SurveyC.SurveyC();
        }
        System.out.println("==============================================================");
        //================================================================

        //=============================Edit=============================== //Things to do here - actually edit it
        try {
            char gg; //random char to get first character of a string
            Output.EditPhrases(5);
            Scanner scan2 = new Scanner(System.in);
            String loadDecision = scan2.nextLine(); //Get users decision (Question, option, answer
            loadDecision = loadDecision.toUpperCase();
            gg = loadDecision.charAt(0);

            switch (gg){
                case 'Q': //Edit questions
                    try {
                        Output.EditPhrases(10);
                        Scanner scan3 = new Scanner(System.in);
                        String newQuestion = scan3.nextLine(); //get new edited question

                        String question = Files.readAllLines(Paths.get(fileValue.toString())).get(1); //get question line

                        List<String> fileContent = new ArrayList<>(Files.readAllLines(fileValue.toPath(), StandardCharsets.UTF_8));
                        for(int i = 0; i< fileContent.size(); i++) //read line by line
                        {
                            if(fileContent.get(i).equals(question)) //If the line is the same as the question line, then change it.
                            {
                                fileContent.set(i, newQuestion);
                                break;
                            }
                        }
                        Files.write(fileValue.toPath(), fileContent, StandardCharsets.UTF_8); //write to file.
                    }catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    Output.EditPhrases(11);
                    break;
                case 'O': // Edit options
                    String options = Files.readAllLines(Paths.get(fileValue.toString())).get(3);
                    List<String> fileContent = new ArrayList<>(Files.readAllLines(fileValue.toPath(), StandardCharsets.UTF_8));
                    if(fileContent.get(3).equals("") || fileContent.get(3).equals("T/F")) //Files with no options or t/f will not be able to change their option
                    {
                        Output.EditPhrases(7);
                        break;
                    }
                    String typeOption;
                    char op; //random char to get first character of a string
                    do { //Get the user's decision to delete or add an item to the array.
                        Output.EditPhrases(8);
                        Scanner scan3 = new Scanner(System.in);
                        typeOption = scan3.nextLine();
                        typeOption = typeOption.toUpperCase();
                        op = typeOption.charAt(0); //get either s or d
                    }while(op != 'D' || op != 'A');

                    if(op == 'D')
                    {

                    }
                    else if(op == 'A')
                    {

                    }
                    Scanner scan3 = new Scanner(System.in);
                    String newOption = scan3.nextLine(); //get new edited question

                    String question = Files.readAllLines(Paths.get(fileValue.toString())).get(3); //get Option line

                    for(int i = 0; i< fileContent.size(); i++) //read line by line
                    {
                        if(fileContent.get(i).equals(question)) //If the line is the same as the question line, then change it.
                        {
                            fileContent.set(i, newOption);
                            break;
                        }
                    }
                    Files.write(fileValue.toPath(), fileContent, StandardCharsets.UTF_8); //write to file.
                    String Option1 = Files.readAllLines(Paths.get(fileValue.toString())).get(3); //separate by tab
                    break;

            }


            //String answer = Files.readAllLines(Paths.get(fileValue.toString())).get(5); //Get Answer
        }catch(IOException e)
        {
            System.out.println(e);
            SurveyC.SurveyC();
        }
        //================================================================

        System.out.println("potato patata end everything");
        SurveyC.SurveyC();
    }

    public static void EditTest() //HW3
    {
        Load.Load("Test", "tmpTest", false);
        System.out.println("Not ready until Homework 3");
        //choose file
        //choose either question or answer
        Test.Test();
    }
}
