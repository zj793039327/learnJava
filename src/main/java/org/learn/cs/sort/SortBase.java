/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.learn.cs.sort;

import java.util.Arrays;

import javax.print.attribute.standard.MediaSize;

import org.junit.Before;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by zhangjing56 on 19/4/22.
 */
@Slf4j
public abstract class SortBase implements ISort {
    private ThreadLocal<Integer> counter;

    public void init() {
        counter = new ThreadLocal<>();
        counter.set(0);
    }

    protected void swap(int[] data, int from, int to) {
        int tmp = data[from];
        data[from] = data[to];
        data[to] = tmp;
    }

    protected void printChange(int[] data, int from, int to) {
        int c = counter.get();
        c += 1;
        counter.set(c);
        log.info("{}: {} <----> {}", counter.get(), from, to);
        log.info(Arrays.toString(data));
    }
}
