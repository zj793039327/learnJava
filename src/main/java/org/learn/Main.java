/*
 * Copyright (C) 2023 Baidu, Inc. All Rights Reserved.
 */
package org.learn;

import java.util.*;
import java.util.List;

public class Main {
    enum Shape {
        SPADE("黑桃"),
        HEART("红桃"),
        CLUB("梅花"),
        DIAMOND("方块");

        Shape(String name) {
            this.name = name;
        }

        private String name;
    }

    static class Card {
        Shape shape;
        Integer num;

        public Card(Shape shape, Integer num) {
            this.shape = shape;
            this.num = num;
        }

        public Card() {
            this.shape = shape;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "shape=" + shape +
                    ", num=" + num +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Card card = (Card) o;
            return shape == card.shape &&
                    Objects.equals(num, card.num);
        }

        @Override
        public int hashCode() {
            return Objects.hash(shape, num);
        }
    }

    public Card findTheOneLack(List<Card> cards) {
        // todo
        return null;

    }

    public List<Card> initCards() {
        List<Card> cards = new ArrayList<Card>();
        for (int i = 0; i < 13; i++) {
            for (Shape value : Shape.values()) {
                cards.add(new Card(value, i));
            }
        }
        Collections.shuffle(cards);
        Card removed = cards.remove(new Random().nextInt(52));
        System.out.println(removed);
        return cards;
    }

    public static void main(String[] args) {
        Main t = new Main();
        List<Card> cards = t.initCards();
        System.out.println(t.findTheOneLack(cards));
    }
}