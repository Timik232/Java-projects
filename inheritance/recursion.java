package rekurs; //12 вариант
import java.util.Scanner;
public class current {
    public static void recursion(){
        Scanner in = new Scanner(System.in);     
        int num = in.nextInt();
        in.nextLine();
        if (num % 2 == 1){
            System.out.println(num);
        }
        if (num!=0)
            recursion();

    }
    public static void main(String[] args){
        System.out.println("Input a sequence of natural numbers: ");
        recursion();
    }
}