/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.learn.cs.sort.impl;

import java.util.Arrays;

import org.learn.cs.sort.SortBase;

/**
 * 插入排序
 * 简直感人
 * Created by zhangjing56 on 19/4/23.
 */
public class InsertSort extends SortBase {
    @Override
    public int[] sort(int[] data) {
        int[] mData = Arrays.copyOf(data, data.length);
        for (int i = 0; i < data.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < data.length; j++) {
                if (mData[j] < mData[minIdx]) {
                    minIdx = j;
                }
            }
            int min = mData[minIdx];
            for (int k = minIdx; k > i; k--) {
                // 如果是个链表，还可以，这里是吧所有相连元素全都挪了位置，真是难受
                mData[k] = mData[k - 1];
            }
            mData[i] = min;
//            System.out.println(Arrays.toString(mData));
        }
        return mData;
    }
}
