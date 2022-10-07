package framework;

import java.util.Scanner;
import java.util.ArrayDeque;

public class CardGame {

    public static void game(Player first, Player second, int count){
        if (first.cards.isEmpty()){
            System.out.println( "second " +  count);
        }
        else if (second.cards.isEmpty()){
            System.out.println( "first " + count);
        }
        else {
            int a1 = first.cards.remove();
            int a2 = second.cards.remove();
            if (a1 > a2 && !(a2 == 0 && a1 == 9)) {
                first.cards.addLast(a1);
                first.cards.addLast(a2);
            }
            else {
                second.cards.addLast(a2);
                second.cards.addLast(a1);
            }
            count++;
            if (count == 106)
                System.out.println("botva");
            game(first, second, count);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two lines with 5 numbers at each (0-10). It will be cards for game");
        String line = in.nextLine();
        String[] numbers = line.split(" ");
        ArrayDeque <Integer> cards = new ArrayDeque<Integer>();
        for (int i =0; i < 5; i++){
            cards.add(Integer.parseInt(numbers[i]));
        }
        Player first = new Player(cards);
        line = in.nextLine();
        numbers = line.split(" ");
        cards.clear();
        for (int i =0; i < 5; i++){
            cards.add(Integer.parseInt(numbers[i]));
        }
        Player second = new Player(cards);
        int count = 0;
        game(first,second,count);
    }
}
