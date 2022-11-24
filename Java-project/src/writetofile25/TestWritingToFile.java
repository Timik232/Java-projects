package writetofile25;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.io.File;
//25
public class TestWritingToFile {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file: ");
        String s = scanner.nextLine();
        File file = new File("src/writetofile25/" + s);
        PrintWriter writer = new PrintWriter(s, "UTF-8");
        System.out.println("Enter the text: ");
        String text = scanner.nextLine();
        writer.println(text);
        writer.close();
    }
}
