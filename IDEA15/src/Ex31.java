import java.io.*;

/**
 * Finds numbers in a file
 * Counts the sum
 * Removes all duplicate numbers
 */
public class Ex31 {

    static int sum = 0;
    static String stringNWR = ""; //NWR = Numbers without repeat
    static boolean contains = false;

    public static void main(final String... args) {

        try {
            readFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Sum: " + sum);
        System.out.println("Numbers without repeat: " + stringNWR);
    }

    public static void readFile() throws Exception {

        FileReader fileReader;
        String numbers = "0123456789";

        fileReader = new FileReader("Text31.txt");
        int symbol = fileReader.read();

        while (symbol != -1) {
            for (int i = 0; i < numbers.length(); i++) {
                char numberChar = numbers.charAt(i);
                if (numberChar == (char) symbol) {
                    System.out.print(numberChar);
                    sum += i;
                    sortNumbers(numberChar, i);
                    break;
                }
            }
            symbol = fileReader.read();
        }
        fileReader.close();
    }

    public static void sortNumbers(char numberChar, int i) {
        for (int b = 0; b < stringNWR.length(); b++) {
            char sortListNumber = stringNWR.charAt(b);
            contains = sortListNumber == numberChar;
            if (contains) {
                break;
            }
        }
        if (!contains) {
            stringNWR += i;
        }
    }

}
