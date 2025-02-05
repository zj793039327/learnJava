/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.learn.cs.sort.impl;

import java.util.Arrays;

import org.learn.cs.sort.SortBase;

/**
 * Created by zhangjing56 on 19/4/22.
 */
public class QuickSort extends SortBase {
    @Override
    public int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        //        return quickSort(arr, 0, arr.length - 1);
//        arr[0]=1;
        return quickSort2(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private int[] quickSort2(int[] arr, int left, int right) {
        if(left>=right){
            return arr;
        }
        int pivot = arr[left];
        int i = left, j = right;
        while (i < j) {
            while ((i<j) && arr[j] > pivot) {
                j--;
            }
            while ((i<j) && arr[i] < pivot) {
                i++;
            }
            if(arr[i]==arr[j] && i<j){
                i++;
            }else{
                swap(arr, i, j);
            }
        }
        quickSort2(arr,left,i);
        quickSort(arr,i+1,right);
        return arr;
    }

}
