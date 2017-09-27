import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import sun.misc.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

/**
 * Created by elee on 4/17/2017.
 */
public class Take {
    public static String voiceName = "kevin16";
    public static VoiceManager voiceManager = VoiceManager.getInstance();
    public static Voice voice = voiceManager.getVoice(voiceName);
    public static String newLine = System.getProperty("line.separator");
    public static void TakeSurvey(String name, boolean turnOn) //HW3
    {
        voice.allocate();
        Scanner scan = new Scanner(System.in); //get the file name
        File loadingFile;
        File x = new File("./"+name); //Path to survey folder
        if(!x.exists())
        {
            x.mkdir();
        }
        File[] listOfFolders = x.listFiles(); //List all the files from the directory
        if(listOfFolders.length == 0)
        {
            Output.noFolder(3);
            if(name == "Survey")
                SurveyC.SurveyC();
            else if(name == "Test")
                Test.Test();
        }
        Output.displayFiles("", 2, name);
        for (int i = 0; i < listOfFolders.length; i++) { //Print files in the folder
            voice.speak(listOfFolders[i].getName());
            System.out.println(listOfFolders[i].getName());
        }
        System.out.println("==============================================");


        Output.loadInfo(1);
        String loadingValue = scan.nextLine();
        if(loadingValue.isEmpty())
        {
            Output.emptyInput();
            TakeSurvey(name, turnOn);
        }

        loadingFile = new File(x + "/" + loadingValue); //Add the user selected option to the File
        if (!loadingFile.exists()) //Check if the folder exist
        {
            Output.noFolder(1);
            TakeSurvey(name, turnOn);
        }

        File[] listOfFiles = loadingFile.listFiles(); //List all the files from the directory

        Output.displayFiles(loadingValue, 1, "");
        for (int i = 0; i < listOfFiles.length; i++) { //Print files in the folder
            voice.speak(listOfFiles[i].getName());
            System.out.println(listOfFiles[i].getName());
        }

        Output.loadInfo(2);
        String fileValue = scan.nextLine();
        if(fileValue.isEmpty())
        {
            Output.emptyInput();
            TakeSurvey(name, turnOn);
        }
        File valueFile = new File(loadingFile+"/"+fileValue);
        while(!valueFile.exists())
        {
            Output.noFolder(2);
            Output.loadInfo(2);
            fileValue = scan.nextLine();
            valueFile = new File(loadingFile+"/"+fileValue);
        }
        //============================Take========================================
        Output.TakePhrases(3);
        Output.TakePhrases(1);
        Scanner scan3 = new Scanner(System.in);
        String userID = scan3.nextLine(); //Get user ID

        try {
            File xs = new File("./"+name+"/Scores"); //Path to survey folder
            Integer xx = 1;
            BufferedReader br = new BufferedReader(new FileReader(valueFile)); //reader
            if(!xs.exists()) //create folder if folder doesn't exist
            {
                xs.mkdir();
            }

            //<String> fileContent = new ArrayList<>(Files.readAllLines(valueFile.toPath(), StandardCharsets.UTF_8)); //content of the file
            File statText = new File(xs+"/"+userID+"-"+loadingValue+"-score.txt"); //Store the user new answer sheet

            FileOutputStream is = new FileOutputStream(statText); //output
            OutputStreamWriter osw = new OutputStreamWriter(is); //to write
            Writer w = new BufferedWriter(osw);
            String readLine = br.readLine(); //reader

            while(readLine != null){ //read all lines of file

                if (readLine.contains("Question")) {
                    for (int i = 0; i < 4; i++) //Print 2 lines
                    {
                        voice.speak(readLine);
                        System.out.println(readLine);
                        readLine = br.readLine();
                    }
                    if(readLine.contains("")) {
                        Scanner scan4 = new Scanner(System.in);
                        String userAnswer = scan4.nextLine();

                        System.out.println(newLine);
                        w.write(fileValue.toString() + " - Question " + xx + " - " + userAnswer + newLine);
                        xx++; //add 1 to the question
                    }
                }
                readLine = br.readLine();
            }
            //Write Answer to the score file
            //w.write(fileValue.toString()+" - ");
            w.close();
        } catch (IOException e) {
            System.err.println(e);
        }

        //Create a file in the current folder.
        //========================================================================

        if(turnOn)
            SurveyC.SurveyC();
        else
            Test.Test();



    }
}
