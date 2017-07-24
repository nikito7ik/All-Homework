import java.io.*;
import java.util.StringTokenizer;

/**
 * Consider the sum of the numbers from the file
 */
public class Ex31 {

    public static void main(final String... args) throws FileNotFoundException, IOException {
        File f = new File("Text31.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String str = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(str, " ;:!@#$%^&*()+=_.,-");
        int sum = 0;
        while (tokenizer.hasMoreTokens()) {
            try {
                sum += Integer.parseInt(tokenizer.nextToken());
            } catch (NumberFormatException ex) {
                continue;
            }
        }
        System.out.println("Sum=" + sum);
    }
}
