package framework;

import java.util.ArrayDeque;

public class Player {
    ArrayDeque <Integer> cards;
    public Player(ArrayDeque <Integer> cards){
        this.cards = new ArrayDeque<Integer>(cards);
    }
}