/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.learn.cs.sort.impl;

import java.util.Arrays;

import org.learn.cs.sort.ISort;
import org.learn.cs.sort.SortBase;

import lombok.extern.slf4j.Slf4j;

/**
 * 冒泡排序
 * 冒泡排序本质上是模拟泡泡
 * Created by zhangjing56 on 19/4/22.
 */
@Slf4j
public class BubbleSort extends SortBase implements ISort {

    @Override
    public int[] sort(int[] data) {
        int[] myData = Arrays.copyOf(data, data.length);

        for (int i = myData.length - 1; i >= 0; i--) {
            //            log.info(i + "");
            for (int j = 0; j < i; j++) {
                if (myData[j] > myData[j + 1]) {
                    swap(myData, j, j + 1);
                    //                    printChange(myData, j, j + 1);
                }
            }
        }
        return myData;
    }

}
