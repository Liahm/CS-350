import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

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
    public static String voiceName = "kevin16";
    public static VoiceManager voiceManager = VoiceManager.getInstance();
    public static Voice voice = voiceManager.getVoice(voiceName);
    public static String newLine = System.getProperty("line.separator");
    public static void EditSurvey(boolean survey, String tmpFile, String name) //HW3
    {
        voice.allocate();
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
                    Save.Save(name, tmpFile, survey); //save files and rerun to load
                    Output.EditPhrases(3);
                    EditSurvey(survey, tmpFile, name);
                }
                else if(qq == 'D')
                {
                    for (int i = 0; i < listOfFiles.length; i++) {
                        listOfFiles[i].delete();
                    }
                    Output.EditPhrases(3);
                    EditSurvey(survey, tmpFile, name);
                }
                else if(qq == 'I')
                {
                    break;
                }
            }while(qq != 'S' || qq != 'D' || qq != 'I');
        }
        if(count == 0)
            Load.Load(name, tmpFile, survey);

        //=================Check files in temp folder=====================
        Output.EditPhrases(4);
        for (int i = 0; i < listOfFiles.length; i++) { //Print files in the folder
            voice.speak(listOfFiles[i].getName());
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
                voice.speak(readLine);
                System.out.println(readLine);
                readLine = br.readLine();
            }
            br.close();
        }catch(IOException e)
        {
            System.out.println(e);
            SurveyC.SurveyC();
        }
        System.out.println("==============================================================");
        //================================================================

        //=============================Edit===============================
            try {
            char gg; //random char to get first character of a string
            do{
                Output.EditPhrases(6);
                Scanner scan3 = new Scanner(System.in);
                String loadDecision = scan3.nextLine(); //Get users decision (Question, option, answer
                loadDecision = loadDecision.toUpperCase();
                gg = loadDecision.charAt(0);
            }while(gg != 'Q' && gg != 'O' && gg != 'A');

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
                    String options = Files.readAllLines(Paths.get(fileValue.toString())).get(3);//get Option line
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

                    }while(op != 'D' && op != 'A');

                    if(op == 'D')
                    {
                        File temp = File.createTempFile("file", ".txt", fileValue.getParentFile()); //create temp file
                        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileValue),StandardCharsets.UTF_8 )); //read file
                        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), StandardCharsets.UTF_8 )); //create the writer

                        Output.EditPhrases(9); //get user choice of delete one or all
                        Scanner scan4 = new Scanner(System.in);
                        String deleteOption = scan4.nextLine();

                        while(!options.contains(deleteOption))
                        {
                            Output.EditPhrases(9); //get user choice of delete one or all
                            scan4 = new Scanner(System.in);
                            deleteOption = scan4.nextLine();

                        }
                        if(deleteOption.equals("All") || deleteOption.equals("all")) //delete everything in the option line
                        {
                            fileContent.set(3, "");
                            Files.write(fileValue.toPath(), fileContent, StandardCharsets.UTF_8); //write to file.
                            Output.EditPhrases(13);
                            break;
                        }

                        for (String line; (line = br.readLine()) != null; ) {
                            line = line.replace(deleteOption + ", ", ""); //find the line that I want to delete
                            line = line.replace(", " + deleteOption, ""); //If it's the last one, delete the comma before and the word
                            writer.println(line); //print everything to the temp file
                        }
                        br.close();
                        writer.close();
                        fileValue.delete();

                        temp.renameTo(fileValue);
                        Output.EditPhrases2(1, deleteOption);
                        break;

                    }
                    else if(op == 'A')
                    {
                        Output.EditPhrases(14);
                        Scanner scan3 = new Scanner(System.in);
                        String addingOption = scan3.nextLine();

                        File temp = File.createTempFile("file", ".txt", fileValue.getParentFile()); //create temp file
                        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileValue),StandardCharsets.UTF_8 )); //read file
                        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), StandardCharsets.UTF_8 )); //create the writer

                        for (String line; (line = br.readLine()) != null; ) {
                            line = line.replaceAll(options, options+", "+ addingOption);
                            writer.println(line); //print everything to the temp file
                        }
                        br.close();
                        writer.close();
                        fileValue.delete();
                        temp.renameTo(fileValue);

                        break;
                    }
                    break;
                case 'A':
                    if(!survey)
                    {

                        String answers = Files.readAllLines(Paths.get(fileValue.toString())).get(5);//get Answer line

                        fileContent = new ArrayList<>(Files.readAllLines(fileValue.toPath(), StandardCharsets.UTF_8));
                        if(fileContent.get(5).equals("") || fileContent.get(5).equals("T/F")) //Files with no options or t/f will not be able to change their option
                        {
                            Output.EditPhrases(7);
                            break;
                        }

                        char opgg; //random char to get first character of a string

                        String typeAnswer;
                        do { //Get the user's decision to delete or add an item to the array.
                            Output.EditPhrases(8);
                            Scanner scan3 = new Scanner(System.in);
                            typeAnswer = scan3.nextLine();
                            typeAnswer = typeAnswer.toUpperCase();
                            opgg = typeAnswer.charAt(0); //get either s or d

                        }while(opgg != 'D' && opgg != 'A');

                        if(opgg == 'D')
                        {
                            File temp = File.createTempFile("file", ".txt", fileValue.getParentFile()); //create temp file
                            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileValue),StandardCharsets.UTF_8 )); //read file
                            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), StandardCharsets.UTF_8 )); //create the writer

                            Output.EditPhrases(9); //get user choice of delete one or all
                            Scanner scan4 = new Scanner(System.in);
                            String deleteAnswer = scan4.nextLine();

                            while(!answers.contains(deleteAnswer))
                            {
                                Output.EditPhrases(9); //get user choice of delete one or all
                                scan4 = new Scanner(System.in);
                                deleteAnswer = scan4.nextLine();

                            }
                            if(deleteAnswer.equals("All") || deleteAnswer.equals("all")) //delete everything in the option line
                            {
                                fileContent.set(5, "");
                                Files.write(fileValue.toPath(), fileContent, StandardCharsets.UTF_8); //write to file.
                                Output.EditPhrases(13);
                                break;
                            }

                            for (String line; (line = br.readLine()) != null; ) {
                                if(line.equals(answers))
                                {
                
                                    line = line.replace(deleteAnswer + ", ", ""); //find the line that I want to delete
                                    line = line.replace(", " + deleteAnswer, ""); //If it's the last one, delete the comma before and the word
                                    //writer.println(line);
                                }
                                writer.println(line); //print everything to the temp file
                            }
                            br.close();
                            writer.close();
                            fileValue.delete();

                            temp.renameTo(fileValue);
                            Output.EditPhrases2(1, deleteAnswer);
                            break;

                        }
                        else if(opgg == 'A')
                        {
                            Output.EditPhrases(14);
                            Scanner scan3 = new Scanner(System.in);
                            String addingAnswer = scan3.nextLine();

                            File temp = File.createTempFile("file", ".txt", fileValue.getParentFile()); //create temp file
                            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileValue),StandardCharsets.UTF_8 )); //read file
                            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), StandardCharsets.UTF_8 )); //create the writer

                            for (String line; (line = br.readLine()) != null; ) {
                                line = line.replaceAll(answers, answers+", "+ addingAnswer);
                                writer.println(line); //print everything to the temp file
                            }
                            br.close();
                            writer.close();
                            fileValue.delete();
                            temp.renameTo(fileValue);

                            Output.EditPhrases2(3, addingAnswer);
                            break;
                        }
                    }
                    else
                        Output.EditPhrases(15);
                    break;
            }
            //String answer = Files.readAllLines(Paths.get(fileValue.toString())).get(5); //Get Answer
        }catch(IOException e)
        {
            System.out.println(e);
            if(survey)
                SurveyC.SurveyC();
            else
                Test.Test();
        }
        //================================================================

        if(survey)
            SurveyC.SurveyC();
        else
            Test.Test();
    }
}
