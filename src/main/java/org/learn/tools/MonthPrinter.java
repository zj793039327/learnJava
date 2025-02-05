/*
 * Copyright (C) 2023 Baidu, Inc. All Rights Reserved.
 */
package org.learn.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class MonthPrinter {
    public static void main(String[] args) throws ParseException {
        String startMonth = "2016-12";
        String endMonth = "2023-12";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

        Date start = sdf.parse(startMonth);
        Date end = sdf.parse(endMonth);
        int counter = 1;
        while (start.before(end)) {
            counter += 1;
            System.out.println(sdf.format(start));
            start = DateUtils.addMonths(start, 1);
        }
        System.out.println(counter);
    }
}
