import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Consider the number of punctuation marks and words in the text
 */

public class Ex30 {

    public static void main(final String... args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Text30.txt"))) {
            StringBuilder stringBuilder = new StringBuilder();

            String line = bufferedReader.readLine();

            while (line != null) {
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
            line = stringBuilder.toString();
            textTask(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void textTask(String symbol) {
        int allText = symbol.length();
        int onlyWords = symbol.replaceAll("[!?.,:;]", "").length();
        int punctuationMarks = allText - onlyWords;
        String[] words = symbol.split(" ");
        System.out.println(symbol);
        System.out.println("Amount of punctuation marks: " + punctuationMarks);
        System.out.println("Amount of words: " + words.length);
    }

}
