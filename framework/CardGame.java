package framework;

import java.util.Scanner;
import java.util.Queue;

public class CardGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two lines with 5 numbers at each (0-10). It will be cards for game");
        String line = in.nextLine();
        String[] numbers = line.split(" ");
        Queue <Integer> cards;
        for (int i =0; i < 5; i++){
            cards[i] = Integer.parseInt(numbers[i]);
        }
        Player first = new Player(cards);
        line = in.nextLine();
        numbers = line.split(" ");
        for (int i =0; i < 5; i++){
            cards[i] = Integer.parseInt(numbers[i]);
        }
       // Player second = new Player(cards);
    }
}
