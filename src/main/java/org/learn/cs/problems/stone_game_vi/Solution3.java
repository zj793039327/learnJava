/*
 * Copyright (C) 2024 Baidu, Inc. All Rights Reserved.
 */
package org.learn.cs.problems.stone_game_vi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.learn.tools.IOUtils;

public class Solution3 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int size = aliceValues.length;
        int[] totalValues = new int[size];
        for (int i = 0; i < size; i++) {
            totalValues[i] = aliceValues[i] + bobValues[i];
        }

        int aliceTotal = 0;
        int bobTotal = 0;
        for (int i = 0; i < size; i++) {
            //            System.out.println(Arrays.toString(aliceValues));
            //            System.out.println(Arrays.toString(bobValues));

            aliceTotal += makeChoice("alice", totalValues, aliceValues, bobValues);
            bobTotal += makeChoice("bob", totalValues, bobValues, aliceValues);
            if (totalValues[maxIdx(totalValues)] == 0) {
                break;
            }
            //            System.out.printf(" alice score: %s, bob score %s%n", aliceTotal, bobTotal);
        }
        if (aliceTotal > bobTotal) {
            return 1;
        } else if (aliceTotal < bobTotal) {
            return -1;
        } else {
            return 0;
        }

    }

    private int makeChoice(String name, int[] totalValues, int[] values, int[] otherValues) {
        int choice = maxIdx(totalValues);
        int choiceVal = values[choice];
        totalValues[choice] = 0;
        values[choice] = 0;
        otherValues[choice] = 0;
        return choiceVal;
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

    public static void main(String[] args) throws IOException {
        //        int[] a = {2, 9, 1, 1, 1, 3, 5, 8, 8, 6, 8, 6, 2, 4};
        //        int[] b = {1, 9, 7, 8, 3, 4, 2, 7, 8, 10, 1, 7, 10, 4};
        InputStream is = Solution3.class.getClassLoader().getResourceAsStream("stone_game_vi_case_91.txt");
        String caseData = IOUtils.readFully(is);
        String[] caseDataObj = caseData.split("\n");
        //        System.out.println(caseDataObj);
        String[] aStr = caseDataObj[0].split(",");
        String[] bStr = caseDataObj[1].split(",");
        int[] a = new int[aStr.length];
        for (int i = 0; i < aStr.length; i++) {
            a[i] = Integer.parseInt(aStr[i]);
        }

        int[] b = new int[bStr.length];
        for (int i = 0; i < bStr.length; i++) {
            b[i] = Integer.parseInt(bStr[i]);
        }
        int val = new Solution3().stoneGameVI(a, b);
        System.out.println(val);
    }
}