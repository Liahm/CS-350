import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by elee on 4/17/2017.
 */
public class Grade {
    public static String voiceName = "kevin16";
    public static VoiceManager voiceManager = VoiceManager.getInstance();
    public static Voice voice = voiceManager.getVoice(voiceName);
    public static String newLine = System.getProperty("line.separator");
    public static void TabulateSurvey(String name) //HW3
    {
        voice.allocate();
        int count = 0;
        File out = new File("./"+name+"/Scores"); //Check files in Scores folder
        File[] listOfFiles = out.listFiles();

        try {
            if (!out.exists()) {
                out.mkdir();
            }


            count = listOfFiles.length; //Number of files in the tmp folder

            if (count > 0) //if files exist
            {
                //Show files from name
                File x = new File("./"+name); //Path to survey folder
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

                Scanner scan = new Scanner(System.in);
                Output.gradeTabulate(3, name);
                String gradeFolder = scan.nextLine();

                File loadingFile = new File(x+"/"+gradeFolder); //./survey/Survey#
                if(!loadingFile.exists())
                {
                    Output.noFolder(1);
                    Grade.TabulateSurvey(name);
                }

                Output.gradeTabulate(4, (gradeFolder+".txt"));


                File fileTabulation = new File(loadingFile+"/"+gradeFolder+".txt"); //./Survey/Survey#/file.txt

                BufferedReader br = new BufferedReader(new FileReader(fileTabulation));
                String readLine = br.readLine(); //reader

                while(readLine != null) { //read all lines of file
                    if (readLine.contains("Question")) {
                        for (int i = 0; i < 4; i++) //Print 4 lines
                        {
                            if(readLine.equals(""))
                                break;
                            voice.speak(readLine);
                            System.out.println(readLine);
                            readLine = br.readLine();
                        }
                        System.out.println("=========-----=========");
                    }
                    readLine = br.readLine();
                }
                Output.gradeTabulate(2,"");
                String questionNumber = scan.nextLine();

                String sCurrentLine;
                int fileLine =1;
                File tabulated = new File(out+"/"+gradeFolder+"-all-tabulated.txt"); //Temp file to compare
                FileOutputStream is = new FileOutputStream(tabulated);
                OutputStreamWriter osw = new OutputStreamWriter(is);
                Writer w = new BufferedWriter(osw);

                for(int i =0; i<listOfFiles.length; i++) //Check the list of files in ./scores
                {
                    if(listOfFiles[i].getName().startsWith(name))
                    {
                        i++;
                        break;
                    }
                    BufferedReader br2 = new BufferedReader(new FileReader(out+"/"+listOfFiles[i].getName())); //read each file
                    while((sCurrentLine = br2.readLine())!= null) //Read until eof
                    {
                        if(sCurrentLine.contains(gradeFolder+".txt"+" - Question "+fileLine)) { //Get all the questions that matches, which should be all of them.
                            w.write(sCurrentLine + newLine); //set temp file
                            fileLine++;
                        }
                    }
                    fileLine =1;
                }

                if(questionNumber.equals("All") || questionNumber.equals("all") || questionNumber.equals("ALL")) //User wants ALL questions tabulated
                {
                    //=========Tabulate==================
                    FileInputStream fis = null;
                    DataInputStream dis = null;
                    BufferedReader br3 = null;
                    int repeat = 1;
                    Map<String, Integer> wordMap = new HashMap<String, Integer>();
                    fis = new FileInputStream(tabulated);
                    dis = new DataInputStream(fis);
                    br3 = new BufferedReader(new InputStreamReader(dis));
                    String line = null;
                    while((line = br3.readLine()) != null){
                        if(wordMap.containsKey(line)){
                            wordMap.put(line, repeat+1);
                        } else {
                            wordMap.put(line, 1);
                        }
                    }

                    for(Map.Entry entry : wordMap.entrySet()) {
                        voice.speak(entry.getKey() + ":  " + entry.getValue());
                        System.out.println(entry.getKey() + ":  " + entry.getValue());
                    }
                }
                else
                {
                    int a=0, b=0, c=0, d=0, e=0, f=0, g=0, h=0, ii=0, j=0, k=0, l=0, m=0, n=0, o=0, p=0, q=0, r=0, s=0, t=0, u=0, v=0, ww=0, xx=0, y=0, z = 0;
                    int tru =0;
                    int fals = 0;
                    String sCurrentMainLine; //Line from the name.txt file
                    BufferedReader br2 = new BufferedReader(new FileReader(fileTabulation));

                    List<String> outputList = new ArrayList<String>();
                    while((sCurrentMainLine = br2.readLine())!= null) //Read until eof
                    {
                        //True/false only
                        if ((sCurrentMainLine.startsWith(questionNumber))) //get the question number and the question line
                        {
                            //Loop for all users
                            //check if they have question with #)Question questionType
                            Output.gradeTabulate(5, "");
                            for (int i = 0; i < listOfFiles.length; i++) //Check the list of files in ./scores
                            {
                                if(listOfFiles[i].getName().startsWith(name))
                                {
                                    i++;
                                    break;
                                }
                                BufferedReader br3 = new BufferedReader(new FileReader(out + "/" + listOfFiles[i].getName())); //read each file
                                while ((sCurrentLine = br3.readLine()) != null) //Read until eof
                                {
                                    //Print the results
                                    if (sCurrentLine.contains("Question " + questionNumber) && sCurrentMainLine.endsWith("T-F:")) {
                                        voice.speak(sCurrentLine);
                                        System.out.println(sCurrentLine);
                                        if (sCurrentLine.endsWith("true")|| sCurrentLine.endsWith("t") || sCurrentLine.endsWith("T"))
                                            tru++;
                                        else if (sCurrentLine.endsWith("false") || sCurrentLine.endsWith("f") || sCurrentLine.endsWith("F"))
                                            fals++;
                                    }
                                    else if (sCurrentLine.contains("Question " + questionNumber) && sCurrentMainLine.endsWith("Short-Answer:")) {
                                        voice.speak(sCurrentLine);
                                        System.out.println(sCurrentLine);
                                        outputList.add(sCurrentLine);
                                    }
                                    else if (sCurrentLine.contains("Question " + questionNumber) && sCurrentMainLine.endsWith("Essay:")) {
                                        voice.speak(sCurrentLine);
                                        System.out.println(sCurrentLine);
                                        outputList.add(sCurrentLine);
                                    }
                                    else if(sCurrentLine.contains("Question " + questionNumber) && sCurrentMainLine.endsWith("Multiple-Choices:"))
                                    {
                                        voice.speak(sCurrentLine);
                                        System.out.println(sCurrentLine);
                                        String lastWord = sCurrentLine.substring(sCurrentLine.lastIndexOf(" ")+1); //get the last word

                                        //yea, running out of time and was desperate
                                        if(lastWord.equals("a."))
                                            a++;
                                        if(lastWord.equals("b."))
                                            b++;
                                        if(lastWord.equals("c."))
                                            c++;
                                        if(lastWord.equals("d."))
                                            d++;
                                        if(lastWord.equals("e."))
                                            e++;
                                        if(lastWord.equals("f."))
                                            f++;
                                        if(lastWord.equals("g."))
                                            g++;
                                        if(lastWord.equals("h."))
                                            h++;
                                        if(lastWord.equals("i."))
                                            ii++;
                                    }
                                    else if(sCurrentLine.contains("Question " + questionNumber) && sCurrentMainLine.endsWith("Matching:")) {
                                        voice.speak(sCurrentLine);
                                        System.out.println(sCurrentLine);
                                        String[] arr = sCurrentLine.split(" - ");
                                        String temp = arr[2];
                                        String[] arw = temp.split(", ");
                                        for(int tak = 0; tak < arw.length; tak++)
                                        {
                                            String garsh = arw[r];
                                            outputList.add(garsh);
                                            ww++;
                                            r++;
                                        }
                                        r=0;

                                    }
                                    else if(sCurrentLine.contains("Question " + questionNumber) && sCurrentMainLine.endsWith("Ranking:"))
                                    {
                                        voice.speak(sCurrentLine);
                                        System.out.println(sCurrentLine);
                                        String[] arr = sCurrentLine.split(" - ");
                                        String temp = arr[2];
                                        outputList.add(temp);
                                        z++;
                                    }
                                }
                            }
                            if(sCurrentMainLine.endsWith("T-F:"))
                            {
                                Output.gradeTabulate(6, "");
                                Output.gradeTabulateValue(1, tru);
                                Output.gradeTabulateValue(2, fals);
                                break;
                            }
                            else if(sCurrentMainLine.endsWith("Short-Answer:"))
                            {
                                Output.gradeTabulate(6, "");
                                outputList.stream().forEach(System.out::println);
                                break;
                            }
                            else if(sCurrentMainLine.endsWith("Essay:"))
                            {
                                Output.gradeTabulate(6, "");
                                outputList.stream().forEach(System.out::println);
                                break;
                            }
                            else if(sCurrentMainLine.endsWith("Multiple-Choices:"))
                            {
                                Output.gradeTabulate(6, "");
                                //yea, running out of time and was desperate
                                Output.gradeTabulate2(1, "a", a);
                                Output.gradeTabulate2(1, "b", b);
                                Output.gradeTabulate2(1, "c", c);
                                Output.gradeTabulate2(1, "d", d);
                                Output.gradeTabulate2(1, "e", e);
                                Output.gradeTabulate2(1, "f", f);
                                Output.gradeTabulate2(1, "g", g);
                                Output.gradeTabulate2(1, "h", h);
                                Output.gradeTabulate2(1, "i", ii);
                            }
                            else if(sCurrentMainLine.endsWith("Matching:"))
                            {
                                Output.gradeTabulate(6, "");
                                Set<String> uniqueWords = new HashSet<String>(outputList);

                                for (String word : uniqueWords) {
                                    voice.speak(word + ": " + Collections.frequency(outputList, word));
                                    System.out.println(word + ": " + Collections.frequency(outputList, word));
                                }
                            }
                            else if(sCurrentMainLine.endsWith("Ranking:"))
                            {
                                Output.gradeTabulate(6, "");
                                Set<String> uniqueWords = new HashSet<String>(outputList);
                                for (String word : uniqueWords) {
                                    voice.speak(word + ": " + Collections.frequency(outputList, word));
                                    System.out.println(word + ": " + Collections.frequency(outputList, word));
                                }
                            }
                        }
                    }
                }
                w.close();
                br.close();
            }
            if(count == 0)
            {
                Output.noFolder(2);
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        if(name.equals("Survey"))
            SurveyC.SurveyC();
        else
            Test.Test();
    }

    public static void GradeTest() //HW3
    {
        voice.allocate();
        File out = new File("./Test/Scores"); //Check files in Scores folder
        File[] listOfFolders = out.listFiles(); //List all the files from the directory
        Scanner scan = new Scanner(System.in);
        if(listOfFolders.length == 0)
        {
            Output.noFolder(3);
            Test.Test();
        }
        try {
            if (!out.exists()) {
                out.mkdir();
            }
            Output.displayFiles("", 2, "Test");
            for (int i = 0; i < listOfFolders.length; i++) { //Print files in the folder
                if(listOfFolders[i].getName().startsWith("Test")) {
                    i++;
                    break;
                }
                voice.speak(listOfFolders[i].getName());
                System.out.println(listOfFolders[i].getName());
            }
            System.out.println("==============================================");
            Output.loadInfo(2);
            String loadingValue = scan.nextLine();

            if(loadingValue.isEmpty())
            {
                Output.emptyInput();
                GradeTest();
            }
            File loadingFile = new File(out + "/" + loadingValue); //Add the user selected option to the File
            if (!loadingFile.exists()) //Check if the file exist
            {
                Output.noFolder(2);
                GradeTest();
            }

            String[] grah = loadingValue.split("-");
            String folder = grah[1]; //get folder
            int answer = 5;
            int xx =0;
            int grade = 0;
            int total =1;
            String sCurrentMainLine; //Line from the name.txt file
            String sCurrentLine;
            File testFile = new File("./Test/"+folder);
            File[] listOfFiles = testFile.listFiles();

            BufferedReader br2 = new BufferedReader(new FileReader(loadingFile));
            BufferedReader br = new BufferedReader(new FileReader(testFile + "/"+folder+".txt")); //Get files that have the answers
            while((sCurrentLine = br.readLine()) !=null) //Info from the test files
            {
                for(int i =0; i< listOfFiles.length; i++) {
                    if(listOfFiles[i].getName().startsWith("Test"))
                    {
                        i++;
                    }
                    if(listOfFiles[i].getName().startsWith("Essay") || listOfFiles[i].getName().startsWith("Short-Answer")) {
                        Output.gradeTest(1);
                        i++;
                    }

                    while((sCurrentMainLine = br2.readLine())!= null) //Read the score file until eof
                    {
                        String[] arr = sCurrentMainLine.split("\\r?\\n");
                        for(int index=0; index < arr.length; index = index + 7) {
                            String answers = Files.readAllLines(Paths.get(listOfFiles[xx].toString())).get(5);//get Answer line from list of files
                            xx++;
                            String important = arr[index];
                            String[] more = important.split(" - ");
                            String important2 = more[2];

                            if(important2.equals(answers))
                            {
                                Output.gradeTest(2);
                                grade++;
                                total++;

                            }
                            else if(!sCurrentMainLine.startsWith("Essay") || !sCurrentMainLine.startsWith("Short-Answer"))
                            {
                                if(answers.equals("")) {
                                    total++;
                                    break;
                                }
                                Output.gradingFail(total);
                                voice.speak("Your answer: "+important);
                                System.out.println("Your answer: "+important);
                                voice.speak("Correct answer: "+answers);
                                System.out.println("Correct answer: "+answers);
                                total++;
                            }
                        }
                    }
                    Output.grading(grade);
                }
            }
            br.close();
            br2.close();

        }catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("End of grading");

        Test.Test();
    }
}
