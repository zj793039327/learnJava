/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.learn.cs.sort;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.learn.cs.sort.impl.BubbleSort;

/**
 * Created by zhangjing56 on 19/4/22.
 */
public class SortRunner {

    private int size = 10;
    private int[] dataRandom = new int[size];
    private SortBase sortImpl;

    @Before
    public void init() {
        Random rdm = new Random();
        for (int i = 0; i < dataRandom.length; i++) {
            dataRandom[i] = rdm.nextInt(200);
        }
        sortImpl = new BubbleSort();
        sortImpl.init();
    }

    @Test
    public void testR() {
        System.out.println(Arrays.toString(sortImpl.sort(dataRandom)));
    }
}
