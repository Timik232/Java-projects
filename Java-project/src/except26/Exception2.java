package except26;
//26
import java.lang.Throwable;
import java.util.Scanner;

public class Exception2 {
    public void exceptionDemo() {
        Scanner myScanner = new Scanner( System.in );
        System.out.print( "Enter an integer ");
        String intString = myScanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        }
        /*catch (Exception e) {
            System.out.println("Error");
        }*/
        catch (ArithmeticException e) {
            System.out.println("Trying to divide by zero");
        }
        catch (NumberFormatException e) {
            System.out.println("Not an integer");
        }
        finally {
            System.out.println("Finally");
        }
    }

    public static void main(String[] args) {
        Exception2 exception2 = new Exception2();
        exception2.exceptionDemo();
    }
}

