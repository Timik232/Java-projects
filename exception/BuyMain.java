package exception;
import java.util.Scanner;

public class BuyMain {
    public static void main(String[] args) {
        System.out.println("Enter your surname and INN into different lines");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        try {

            String INN = in.nextLine();
            if (INN.length() != 12)
                throw new WrongNumberINNException("Amount of number");
            String regex = "//d+";
            if (!INN.matches(regex))
                throw new WrongNumberINNException("Wrong symbols");
        }
        catch (WrongNumberINNException numb){
            System.out.println(numb.getMessage());
        }

    }
}
