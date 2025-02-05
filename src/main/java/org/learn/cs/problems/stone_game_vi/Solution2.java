/*
 * Copyright (C) 2024 Baidu, Inc. All Rights Reserved.
 */
package org.learn.cs.problems.stone_game_vi;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution2 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int size = aliceValues.length;

        int aliceTotal = 0;
        int bobTotal = 0;
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(aliceValues));
            System.out.println(Arrays.toString(bobValues));
            int[] test = minus(aliceValues, bobValues);
            System.out.println(Arrays.toString(test));

            aliceTotal += makeChoice("alice", aliceValues, bobValues);
            bobTotal += makeChoice("bob", bobValues, aliceValues);
            System.out.printf(" alice score: %s, bob score %s%n", aliceTotal, bobTotal);
        }
        if (aliceTotal > bobTotal) {
            return 1;
        } else if (aliceTotal < bobTotal) {
            return -1;
        } else {
            return 0;
        }

    }

    private int makeChoice(String name, int[] values, int[] otherValues) {
        long sumMy = sum(values);
        long sumOther = sum(otherValues);
        int choice;
        if (sumMy > sumOther) {
            choice = maxIdx(values);
            choice = secondChoice(CHOICE.MAX, choice, values, otherValues);
            System.out.printf("%s begin, this %s > other %s, get my [%s]=%s, got [%s]，make lost [%s] %n", name, sumMy,
                    sumOther,
                    choice, values[choice], values[choice], otherValues[choice]);
        } else {
            choice = maxIdx(otherValues);
            choice = secondChoice(CHOICE.MAX, choice, otherValues, values);
            System.out.printf("%s begin，this %s < other %s, get other [%s]=%s, got [%s]，make lost [%s] %n", name, sumMy,
                    sumOther,
                    choice, otherValues[choice], values[choice], otherValues[choice]);
        }
        int choiceVal = values[choice];
        values[choice] = 0;
        otherValues[choice] = 0;
        return choiceVal;
    }

    private int[] minus(int[] values, int[] otherValues) {
        int[] t = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            t[i] = values[i] - otherValues[i];
        }
        return t;
    }

    private int secondChoice(CHOICE target, int choice, int[] value, int[] otherValue) {
        int choiceVal = value[choice];
        int count = 0;
        for (int i : value) {
            if (i == choice) {
                count += 1;
            }
        }
        if (count == 1) {
            return choice;
        } else {
            if (target.equals(CHOICE.MAX)) {
                int maxVal = otherValue[choice];
                int changeChoice = choice;
                for (int i = 0; i < value.length; i++) {
                    if (value[i] == choiceVal) {
                        if (otherValue[i] > maxVal) {
                            maxVal = otherValue[i];
                            changeChoice = i;
                        }
                    }
                }
                if (choice != changeChoice) {
                    System.out.println("做了二次选择，选择了" + choice + "->" + changeChoice);
                }
                return changeChoice;
            } else {
                int minVal = otherValue[choice];
                int changeChoice = choice;
                for (int i = 0; i < value.length; i++) {
                    if (value[i] == choiceVal) {
                        if (otherValue[i] < minVal) {
                            minVal = otherValue[i];
                            changeChoice = i;
                        }
                    }
                }
                if (choice != changeChoice) {
                    System.out.println("做了二次选择，选择了" + choice + "->" + changeChoice);
                }
                return changeChoice;
            }
        }

    }

    enum CHOICE {
        MAX, MIN;
    }

    private long sum(int[] array) {
        long sum = 0;
        for (int val : array) {
            sum += val;
        }
        return sum;
    }

    private int maxIdx(int[] array) {
        int val = 0;
        int idx = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > val) {
                val = array[j];
                idx = j;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] a = {2, 9, 1, 1, 1, 3, 5, 8, 8, 6, 8, 6, 2, 4};
        int[] b = {1, 9, 7, 8, 3, 4, 2, 7, 8, 10, 1, 7, 10, 4};
        int val = new Solution2().stoneGameVI(a, b);
        System.out.println(val);
    }
}