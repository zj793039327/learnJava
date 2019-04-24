/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.learn.cs.sort.impl;

import java.util.Arrays;

import org.learn.cs.sort.ISort;
import org.learn.cs.sort.SortBase;

import lombok.extern.slf4j.Slf4j;

/**
 * 选择排序
 * Created by zhangjing56 on 19/4/22.
 */
@Slf4j
public class SelectionSort extends SortBase implements ISort {

    boolean printKeyStep = true;

    /**
     * 这是最基础的排序算法，可以看到输出，循环次数为 length^2
     * 时间复杂度为 O(n^2)
     * 还有一个很大的问题，在于每次多余的替换位置，比如第一轮替换
     * 最终其实是0-9的替换，但是中间多余的替换了这么多次
     * 0 <----> 1
     * [74, 91, 154, 71, 163, 59, 36, 128, 75, 0]
     * 0 <----> 3
     * [71, 91, 154, 74, 163, 59, 36, 128, 75, 0]
     * 0 <----> 5
     * [59, 91, 154, 74, 163, 71, 36, 128, 75, 0]
     * 0 <----> 6
     * [36, 91, 154, 74, 163, 71, 59, 128, 75, 0]
     * 0 <----> 9
     * [0, 91, 154, 74, 163, 71, 59, 128, 75, 36]
     * 1 <----> 3
     * [0, 74, 154, 91, 163, 71, 59, 128, 75, 36]
     * 1 <----> 5
     * [0, 71, 154, 91, 163, 74, 59, 128, 75, 36]
     * 1 <----> 6
     * [0, 59, 154, 91, 163, 74, 71, 128, 75, 36]
     * 1 <----> 9
     * [0, 36, 154, 91, 163, 74, 71, 128, 75, 59]
     * 2 <----> 3
     * [0, 36, 91, 154, 163, 74, 71, 128, 75, 59]
     * 2 <----> 5
     * [0, 36, 74, 154, 163, 91, 71, 128, 75, 59]
     * 2 <----> 6
     * [0, 36, 71, 154, 163, 91, 74, 128, 75, 59]
     * 2 <----> 9
     * [0, 36, 59, 154, 163, 91, 74, 128, 75, 71]
     * 3 <----> 5
     * [0, 36, 59, 91, 163, 154, 74, 128, 75, 71]
     * 3 <----> 6
     * [0, 36, 59, 74, 163, 154, 91, 128, 75, 71]
     * 3 <----> 9
     * [0, 36, 59, 71, 163, 154, 91, 128, 75, 74]
     * 4 <----> 5
     * [0, 36, 59, 71, 154, 163, 91, 128, 75, 74]
     * 4 <----> 6
     * [0, 36, 59, 71, 91, 163, 154, 128, 75, 74]
     * 4 <----> 8
     * [0, 36, 59, 71, 75, 163, 154, 128, 91, 74]
     * 4 <----> 9
     * [0, 36, 59, 71, 74, 163, 154, 128, 91, 75]
     * 5 <----> 6
     * [0, 36, 59, 71, 74, 154, 163, 128, 91, 75]
     * 5 <----> 7
     * [0, 36, 59, 71, 74, 128, 163, 154, 91, 75]
     * 5 <----> 8
     * [0, 36, 59, 71, 74, 91, 163, 154, 128, 75]
     * 5 <----> 9
     * [0, 36, 59, 71, 74, 75, 163, 154, 128, 91]
     * 6 <----> 7
     * [0, 36, 59, 71, 74, 75, 154, 163, 128, 91]
     * 6 <----> 8
     * [0, 36, 59, 71, 74, 75, 128, 163, 154, 91]
     * 6 <----> 9
     * [0, 36, 59, 71, 74, 75, 91, 163, 154, 128]
     * 7 <----> 8
     * [0, 36, 59, 71, 74, 75, 91, 154, 163, 128]
     * 7 <----> 9
     * [0, 36, 59, 71, 74, 75, 91, 128, 163, 154]
     * 8 <----> 9
     * [0, 36, 59, 71, 74, 75, 91, 128, 154, 163]
     *
     * @param data
     *
     * @return
     */

    public int[] sort_org1(int[] data) {
        int[] myData = new int[data.length];
        System.arraycopy(data, 0, myData, 0, data.length - 1);

        for (int i = 0; i < myData.length; i++) {
            for (int j = i + 1; j < myData.length; j++) {
                if (myData[i] > myData[j]) {
                    swap(myData, i, j);
                    if (printKeyStep) {
                        System.out.println(String.format("%s <----> %s", i, j));
                        System.out.println(Arrays.toString(myData));
                    }
                }

            }
        }
        return myData;
    }

    /**
     * 替换的轮次减少，通过minIdx记录最小的，需要替换的值
     *
     * @param data
     *
     * @return
     */
    @Override
    public int[] sort(int[] data) {
        int[] myData = new int[data.length];
        System.arraycopy(data, 0, myData, 0, data.length - 1);

        log.info(Arrays.toString(myData));
        for (int i = 0; i < myData.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < myData.length; j++) {
                if (myData[minIdx] > myData[j]) {
                    minIdx = j;
                }
            }
            swap(myData, i, minIdx);
        }
        return myData;
    }

}
