import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Dictonary {
    private static Object EOFException;
    private static final String wordAndMeaningSeperator = "–";
    private static final String allMeaningsSeperator = ",";
    private static String dictionaryrealtiveSuffixPath = File.separator + "resources" + File.separator + "Dictionary.txt";

    /* Method to verify if the file exists at that path or not */
    public static boolean doesFileExist(String path) {

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            System.exit(0);
        }
        return true;
    }

    /* Method to print the words and corresponding meanings from the input dictionary*/
    public static void printTheWordsandCorresMeanings(String dictionaryPath) throws IOException {
        FileInputStream inputStream = null;
        Scanner sc = null;

        try {
            inputStream = new FileInputStream(dictionaryPath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] wordMeaning = line.split(wordAndMeaningSeperator);
                System.out.println(wordMeaning[0].trim());
                String[] allMeanings = wordMeaning[1].split(allMeaningsSeperator);

                for (String eachMeaning : allMeanings)
                    System.out.println(eachMeaning.trim());
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
    }

    /* Main method to invoke the method to print the dictionary words and meanings */
    public static <LineIterator> void main(String[] args) throws IOException {

        //Building the relative path to Dictionary file
        Path paths = Paths.get(System.getProperty("user.dir"));
        String dictionaryrealtivePrefixPath = paths.getParent().toString();
        String dictionaryPath = dictionaryrealtivePrefixPath + dictionaryrealtiveSuffixPath;

        //Verifying the existence of file at the above path
        if (doesFileExist(dictionaryPath)) {
            System.out.println("The words and corresponding meanings are as follows ::\n");
            printTheWordsandCorresMeanings(dictionaryPath);
            System.out.println();
        }
    }
}