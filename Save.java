import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.nio.file.StandardCopyOption;
/**
 * Created by elee on 4/17/2017.
 */
public class Save { //I STILL REQUIRE TO FINISH THIS - LOOK INTO THE COPY FILES PART
    /**
     * Summary:
     * Create a folder that will not be overwritten and a new file that isn't overwritten either.
     * Get all files from the temp file.
     * Order them by creation time
     * Copy file by file into the end of a new file named Survey #.
     * Put this file inside a folder named Survey #
     * Delete temp file.
     */
    public static long count = 0; //Make it "count" how many folders exist and then +1 it.
    public static void SaveSurvey() //HW2
    {
        String name = "Survey";
        char yn = 'Y';
        File x = new File(".\\"+name);
        File[] xs =x.listFiles(new FileFilter() { //Getting the directories number
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        count = xs.length; //Count = the amount of direectories in the current directory
        if(count <= 0)
            count = 0;
        new File(name).mkdirs();
        new File(name+"\\"+name+count).mkdirs();
        File f;
        File in;
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Do you want to save the file?(Y/N)");
            String input = scan.nextLine();
            input = input.toUpperCase(); //Make whatever the input was into a capitalized word
            if(!input.equals(""))
                yn = input.charAt(0); //Get the first letter
            else {
                System.out.println("Incorrect Input, \"Empty String\" detected.");
                SaveSurvey(); //Repeat
            }

            if (yn == 'Y') {
                f = new File(".\\"+name+"\\"+name+count+"\\"+name+count+".txt");
                in = new File(".\\tmpSurvey\\checking out scanner.txt");//Insert the first .txt file or find a way to copy all in 1
                if (!f.exists()) {
                    //Loop around here to cat all files
                    //===================Copy files to another directory==================
                    File fileCopy = new File(".\\"+name+"\\"+name+count+"\\");
                    //====================================================================
                    Files.copy(in.toPath(), f.toPath()); //Currently copying one file and one file only
                    //====================================================================
                    f.createNewFile();
                     //Everything goes into f
                    count++;

                } else {
                    //Loop around here to parse all files, literally the same as above
                    f = new File(".\\"+name+"\\"+name+count+"\\"+name+count+".txt");
                    f.createNewFile();
                    count++;
                }

            }
            else if(yn != 'N' && yn != 'Y')
            {
                System.out.println("Incorrect Input, please retry.");
                SaveSurvey(); //Input was incorrect, retry
            }
            else //This deletes the folder that I created at the start of the method
            {//It should only happen if the first character input was N
                //System.out.println("It went in here to delete");
                String[]entries = x.list();
                for(String s: entries){
                    File currentFile = new File(x.getPath(),s);
                    currentFile.delete(); //Delete the currentFile.
                }
                SurveyC.SurveyC(); //End it.
            }
            SurveyC.SurveyC(); //End
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Returning to Survey options, please retry. \n");
            SurveyC.SurveyC();
        }

    }

    public static void SaveTest() //HW2
    {
        String name = "Test";
        new File(name).mkdirs();
        new File(name+"\\"+name+count).mkdirs();
        System.out.println(count);
        try {

            //File file3 = new File(".\\Survey\\Survey" + count + "\\" + name + count + ".txt");
            Scanner scan = new Scanner(System.in);

            System.out.println("Do you want to save the file?(Y/N)");
            String input = scan.nextLine();
            input.toUpperCase();
            File f;
            f = new File(".\\"+name+count);
            if (input.equals('Y')) {
                if (!f.exists()) {
                    //Loop around here

                    f.createNewFile();
                } else {
                    count++;
                    SaveSurvey();
                }
            }
            Test.Test();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Returning to Test options, please retry. \n");
            SurveyC.SurveyC();
        }

    }
}
