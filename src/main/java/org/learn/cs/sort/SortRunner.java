/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.learn.cs.sort;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.learn.cs.sort.impl.QuickSort;

/**
 * Created by zhangjing56 on 19/4/22.
 */
public class SortRunner {

    private int size = 20;
    private int[] dataRandom = new int[size];
    private SortBase sortImpl;

    @Before
    public void init() {
        Random rdm = new Random();
        for (int i = 0; i < dataRandom.length; i++) {
            dataRandom[i] = rdm.nextInt(size * 20);
        }
        sortImpl = new QuickSort();
        sortImpl.init();
    }

    @Test
    public void testR() {
        for (int j = 0; j < 100; j++) {
            init();
            System.out.println(Arrays.toString(dataRandom));
            //                System.out.println(Arrays.toString(
            sortImpl.sort(dataRandom);
            //                ));
        }

    }

    //    @FindLostPoke
    public void testTime() {
        long start = System.nanoTime();
        sortImpl.sort(dataRandom);
        long end = System.nanoTime();
        System.out.println((end - start) / 1000000);
    }

//    @FindLostPoke
    public void testError(){
        int[] errorWithQSort=new int[]{
                16, 338, 69, 11, 22, 291, 188, 208, 304, 278, 306, 278, 202, 291, 116, 11, 256, 82, 33, 385
        };
        sortImpl.sort(dataRandom);

    }
}
