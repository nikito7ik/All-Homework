import java.io.*;
import java.util.Random;

/**
 * Write 20 numbers in the file, read them, and find the average
 */
public class Ex32 {

    public static void main(final String... args) throws IOException {

        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Text32.txt")));
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("Text32.txt")));
        Random r = new Random(20);
        int number = 0;
        int average = 0;

        try {
            for (int i = 0; i < 20; i++) {
                dos.writeInt(r.nextInt(100));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
            return;
        }

        dos.close();

        while (dis.available() > 0) {
            number = dis.readInt();
            average += number;
            System.out.println("Number " + number);
        }
        average = average / 20;
        System.out.println("Average: " + average);
    }
}
