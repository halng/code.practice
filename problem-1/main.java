import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException; // Add this line

public class main {
    public static int sub(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        try {
            File file = new File("./problem-1/INPUT");
            Scanner scanner = new Scanner(file);
            int a = Integer.parseInt(scanner.nextLine());
            int b =  Integer.parseInt(scanner.nextLine());
            scanner.close();
            System.out.println(sub(a, b));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}