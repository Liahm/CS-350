import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;


/**
 * Created by elee on 4/17/2017.
 */
public class Save { //Completed on 5/3/2017 - Long hiatus
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
    public static int fileNumber = 1; //Count how many files exist. Starts at 1 so that question 1 would be named question 1.
    public static void Save(String name, String tempFolder) //HW2
    {
        String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
        char yn = 'Y';
        File x = new File(".\\"+name); //Path to survey folder
        if(!x.exists())
        {
            x.mkdir();
        }

        File[] xs =x.listFiles(new FileFilter() { //Getting the directories number
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        count = xs.length; //Count = the amount of directories in the current directory;
        if(count <= 0)
            count = 0;

        new File(name).mkdirs();
        new File(name+"\\"+name+count).mkdirs();
        File f;
        File in;

        File catName = new File(".\\"+name+"\\" +name+count+"\\"+name+count+".txt"); //cat file name

        try {
            Scanner scan = new Scanner(System.in);
            Output.saveFile();
            String input = scan.nextLine();
            input = input.toUpperCase(); //Make whatever the input was into a capitalized word

            if(!input.equals(""))
                yn = input.charAt(0); //Get the first letter
            else {
                Output.emptyInput();
                Save(name, tempFolder); //Repeat
            }

            if (yn == 'Y') {
                File folder = new File(".\\"+tempFolder); //Get the temp directory name
                File[] listOfFiles = folder.listFiles(); //List all the files from the directory
                try { //Try statement to check if there are any files still inside of the temp folder.
                    f = new File(".\\" + name + "\\" + name + count + "\\" + listOfFiles[0].getName()); //The current folder name
                    if (!f.exists()) {
                        //==========This section move files from point A to B=====================
                        for (int i = 0; i < listOfFiles.length; i++)
                        {
                            if(listOfFiles[i].getName().startsWith(name)) //This will delete the old Survey/Test concatenated file.
                            {
                                listOfFiles[i].delete();
                                i++;
                            }
                            f = new File(".\\" + name + "\\" + name + count + "\\" + listOfFiles[i].getName()); //output file
                            in = new File(".\\"+tempFolder+"\\" + listOfFiles[i].getName()); //tmp file
                            // first = new File(".\\tmpSurvey\\" + listOfFiles[0].getName());
                            Files.copy(in.toPath(), f.toPath()); //Copy to the new folder

                            //=====================This entire section Concats files===========================================
                            BufferedWriter bw = null;
                            FileWriter fw = null;
                            FileReader fr = null;
                            BufferedReader br = null;
                            try {
                                if (!catName.exists()) {
                                    catName.createNewFile();
                                }
                                // true = append file
                                fw = new FileWriter(catName.getAbsoluteFile(), true); //Get file write to and reading from
                                bw = new BufferedWriter(fw);
                                fr = new FileReader(in);
                                br = new BufferedReader(fr);

                                String sCurrentLine;
                                br = new BufferedReader(new FileReader(in));
                                bw.write(fileNumber+ ") "); //Writing the first question number
                                while((sCurrentLine = br.readLine())!= null)
                                    bw.write(sCurrentLine + newLine);//Printing line by line
                                fileNumber++;
                                bw.write(newLine); //Printing a new line at the end of the x file to make space
                            }finally { //Close all files
                                try {
                                    if (bw != null)
                                        bw.close();
                                    if (fw != null)
                                        fw.close();
                                    if (fr != null)
                                        fr.close();
                                    if (br != null)
                                        br.close();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            //=================================================================================================
                            listOfFiles[i].delete(); //Delete the current file.
                        }
                        //==========It also deletes the files from the original location=============
                        count++;

                    } else {
                        //This should create a new folder if the folder already exists
                        System.out.println("I actually don't think it ever comes in here. If it does, please tell me");
                        f = new File(".\\" + name + "\\" + name + count + "\\" + name + count + ".txt");
                        f.createNewFile();
                        count++;
                    }
                }
                catch (IndexOutOfBoundsException e) {
                    Output.saved();
                    String[]entries = x.list();
                    for(String s: entries){ //Delete the folder that was created because the class was initialized
                        File currentFile = new File(x.getPath(),s);
                        currentFile.delete(); //Delete the currentFile.
                    }
                    SurveyC.SurveyC();
                }

            }
            else if(yn != 'N' && yn != 'Y')
            {
                Output.incorrectInput();
                Save(name, tempFolder); //Input was incorrect, retry
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
            Output.returningOptions(name);
            SurveyC.SurveyC();
        }

    }
}
