import java.io.*;
import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class Display { //Completed 5/3/2017
    /**
     * Get Survey/test name from the user
     * Print entire survey/test into console
     */
    public static void Display(String name) //HW2 - show to the screen
    {
        Scanner scan = new Scanner(System.in); //get the file name
        File loadingFile;
        File x = new File(".\\"+name); //Path to survey folder
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
            System.out.println(listOfFolders[i].getName());
        }
        System.out.println("==============================================");


        Output.loadInfo(1);
        String loadingValue = scan.nextLine();
        if(loadingValue.isEmpty())
        {
            Output.emptyInput();
            Display(name);
        }

        loadingFile = new File(x + ".\\" + loadingValue); //Add the user selected option to the File
        if (!loadingFile.exists()) //Check if the folder exist
        {
            Output.noFolder(1);
            Display(name);
        }

        File[] listOfFiles = loadingFile.listFiles(); //List all the files from the directory

        Output.displayFiles(loadingValue, 1, "");
        for (int i = 0; i < listOfFiles.length; i++) { //Print files in the folder
            System.out.println(listOfFiles[i].getName());
        }

        Output.loadInfo(2);
        String fileValue = scan.nextLine();
        if(fileValue.isEmpty())
        {
            Output.emptyInput();
            Display(name);
        }
        File valueFile = new File(loadingFile+"\\"+fileValue);
        while(!valueFile.exists())
        {
            Output.noFolder(2);
            Output.loadInfo(2);
            fileValue = scan.nextLine();
            valueFile = new File(loadingFile+"\\"+fileValue);
        }
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(valueFile));
            String readLine = br.readLine();
            System.out.println("==============================================");
            while(readLine !=null)
            {
                System.out.println(readLine);
                readLine = br.readLine();
            }
        }catch(IOException e)
        {
            System.out.println(e);
            if(name == "Survey")
                SurveyC.SurveyC();
            else if(name == "Test")
                Test.Test();
        }
        System.out.println("==============================================");

        //Go back to the menu
        if(name == "Survey")
            SurveyC.SurveyC();
        else if(name == "Test")
            Test.Test();
        else
        {
            String[] args = {};
            Output.noClue();
            Survey.main(args);
        }
    }
}
