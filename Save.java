import java.io.File;
import java.io.FileFilter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
/**
 * Created by elee on 4/17/2017.
 */
public class Save {
    /**
     * Summary:
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
        new File(name).mkdirs();
        new File(name+"\\"+name+count).mkdirs();
        System.out.println(count);
        try {

            //File file3 = new File(".\\Survey\\Survey" + count + "\\" + name + count + ".txt");
            Scanner scan = new Scanner(System.in);

            System.out.println("Do you want to save the file?(Y/N)");
            String input = scan.nextLine();
            input = input.toUpperCase();
            yn = input.charAt(0);
            File f;
            f = new File(".\\"+name+"\\"+name+count+"\\"+name+count+".txt");
            File x = new File(".\\"+name);
            if (yn == 'Y') {

                File[] xs =x.listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        return pathname.isDirectory();
                    }
                });
                if (!f.exists()) {
                    //Loop around here
                    f.createNewFile();
                    count++;
                } else {
                    count = xs.length;
                    f = new File(".\\"+name+"\\"+name+count+"\\"+name+count+".txt");
                    f.createNewFile();
                    count++;
                }
            }
            else
            {
                System.out.println("It went in here to delete");
                String[]entries = x.list();
                for(String s: entries){
                    File currentFile = new File(x.getPath(),s);
                    currentFile.delete();
                }
            }
            SurveyC.SurveyC();
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
