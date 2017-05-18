import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/**
 * Created by elee on 4/17/2017.
 */
public class Load {
    /**
     * Summary:
     * Ask the user to select a file to open.
     * Load said file folder information into the temp folder.
     * You could also say, load files from espcified folder
     * That's it.
     */

    public static void Load(String name, String tmpFile,boolean turnOn) //HW2 - load to memory
    {
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
            System.out.println(listOfFolders[i].getName());
        }
        System.out.println("==============================================");

        Output.loadInfo(1);
        Scanner scan = new Scanner(System.in); //get the file name
        String loadingValue = scan.nextLine();

        File loadingFile = new File(x+"/"+loadingValue);

        if(!loadingFile.exists())
        {
            Output.noFolder(1);
            if(name == "Survey")
                SurveyC.SurveyC();
            else if(name == "Test")
                Test.Test();
        }

        File[] listOfFiles = loadingFile.listFiles();
        try {
            for (int i = 0; i < listOfFiles.length; i++) {
                File in = new File(loadingFile + "/" + listOfFiles[i].getName()); //input file
                File out = new File("./"+tmpFile+"/"+ listOfFiles[i].getName()); //output file
                Files.copy(in.toPath(), out.toPath(), StandardCopyOption.REPLACE_EXISTING);

            }
            Output.loadInfo(3);
        }catch(IOException e)
        {
            System.out.println(e);
            if(name == "Survey")
                SurveyC.SurveyC();
            else if(name == "Test")
                Test.Test();
        }

        if(turnOn) {
            if (name == "Survey")
                SurveyC.SurveyC();
            else if (name == "Test")
                Test.Test();
            else {
                String[] args = {};
                Output.noClue();
                Survey.main(args);
            }
        }
    }

}
