package exception;
import java.util.Scanner;

public class BuyMain {
    public static void main(String[] args) {
        System.out.println("Enter your surname and INN into different lines");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        boolean isOk;
        try {

            String INN = in.nextLine();
            String regex = "[0-9]+";
            if (!INN.matches(regex))
                throw new WrongNumberINNException("Wrong symbols");
            if (INN.length() != 12)
                throw new WrongNumberINNException("Amount of number");
            isOk = true;
        }
        catch (WrongNumberINNException numb){
            System.out.println(numb.getMessage());
            isOk = false;
        }
    if (isOk)
        System.out.println("The data was entered");
    else System.out.println("Invalid input");
    }
}
