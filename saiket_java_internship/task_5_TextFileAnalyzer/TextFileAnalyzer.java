 import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String fileName = sc.nextLine();

        File file = new File(fileName);

        int lines = 0;
        int words = 0;
        int characters = 0;

        try {
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {

                String line = fileReader.nextLine();

                lines++;
                characters += line.length();

                if (!line.trim().isEmpty()) {
                    String[] wordList = line.trim().split("\\s+");
                    words += wordList.length;
                }
            }

            fileReader.close();

            System.out.println("\n--- File Analysis ---");
            System.out.println("Number of lines: " + lines);
            System.out.println("Number of words: " + words);
            System.out.println("Number of characters: " + characters);

            System.out.print("\nEnter a word to search: ");
            String searchWord = sc.nextLine();

            Scanner searchReader = new Scanner(file);

            int occurrences = 0;

            while (searchReader.hasNextLine()) {

                String line = searchReader.nextLine();

                String[] wordList = line.split("\\s+");

                for (String word : wordList) {

                    word = word.replaceAll("[^a-zA-Z0-9]", "");

                    if (word.equalsIgnoreCase(searchWord)) {
                        occurrences++;
                    }
                }
            }

            searchReader.close();

            System.out.println("The word \"" + searchWord +
                    "\" appears " + occurrences + " time(s).");

        } catch (FileNotFoundException e) {

            System.out.println("File not found. Please check the file name.");
        }

        sc.close();
    }
}