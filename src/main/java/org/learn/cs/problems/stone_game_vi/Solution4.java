/*
 * Copyright (C) 2024 Baidu, Inc. All Rights Reserved.
 */
package org.learn.cs.problems.stone_game_vi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

import org.learn.tools.IOUtils;

public class Solution4 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int size = aliceValues.length;
        int[][] totalValues = new int[size][3];
        for (int i = 0; i < size; i++) {
            totalValues[i][0] = aliceValues[i] + bobValues[i];
            totalValues[i][1] = aliceValues[i];
            totalValues[i][2] = bobValues[i];
        }
        Arrays.sort(totalValues, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        int aliceTotal = 0;
        int bobTotal = 0;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                aliceTotal += totalValues[i][1];
            } else {
                bobTotal += totalValues[i][2];
            }
        }
        if (aliceTotal > bobTotal) {
            return 1;
        } else if (aliceTotal < bobTotal) {
            return -1;
        } else {
            return 0;
        }

    }

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        //        int[] a = {2, 9, 1, 1, 1, 3, 5, 8, 8, 6, 8, 6, 2, 4};
        //        int[] b = {1, 9, 7, 8, 3, 4, 2, 7, 8, 10, 1, 7, 10, 4};
        InputStream is = Solution4.class.getClassLoader().getResourceAsStream("stone_game_vi_case_91.txt");
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
        int val = new Solution4().stoneGameVI(a, b);
        System.out.println(val);
        long end = System.currentTimeMillis();
        System.out.printf("%s ms\n", end - start);
    }
}