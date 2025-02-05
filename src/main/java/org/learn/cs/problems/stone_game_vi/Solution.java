/*
 * Copyright (C) 2024 Baidu, Inc. All Rights Reserved.
 */
package org.learn.cs.problems.stone_game_vi;

public class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int size = aliceValues.length;

        int aliceTotal = 0;
        int bobTotal = 0;
        for (int i = 0; i < size; i++) {
            aliceTotal += makeChoice("alice", aliceValues, bobValues);
            bobTotal += makeChoice("bob", bobValues, aliceValues);
            System.out.printf("此时 alice分数：%s, bob分数 %s%n", aliceTotal, bobTotal);
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
            System.out.printf("%s 开始选择，由于自己的总和%s > 对方的总和 %s, 因此选择拿自己的最大值[%s]=%s,自己获得%s分，对方损失%s分%n", name, sumMy,
                    sumOther,
                    choice, values[choice], values[choice], otherValues[choice]);
        } else {
            choice = maxIdx(otherValues);
            System.out.printf("%s 开始选择，由于自己的总和%s < 对方的总和 %s, 因此选择拿对方的最大值[%s]=%s,自己获得%s分，对方损失%s分%n", name, sumMy,
                    sumOther,
                    choice, otherValues[choice], values[choice], otherValues[choice]);
        }
        int choiceVal = values[choice];
        values[choice] = 0;
        otherValues[choice] = 0;
        return choiceVal;
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
        int val = new Solution().stoneGameVI(a, b);
        System.out.println(val);
    }
}