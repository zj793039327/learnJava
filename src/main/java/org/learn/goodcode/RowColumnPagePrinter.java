/*
 * Copyright (C) 2023 Baidu, Inc. All Rights Reserved.
 */
package org.learn.goodcode;

import java.io.PrintStream;
import java.util.Date;
import java.util.List;

public class RowColumnPagePrinter {
    private int rowsPerPage;
    private int columnsPerPage;
    private int numbersPerPage;
    private String pageHeader;
    private PrintStream printStream;

    public RowColumnPagePrinter(int rowsPerPage,
                                int columnsPerPage,
                                String pageHeader) {
        this.rowsPerPage = rowsPerPage;
        this.columnsPerPage = columnsPerPage;
        this.pageHeader = pageHeader;
        numbersPerPage = rowsPerPage * columnsPerPage;
        printStream = System.out;
    }

    public void print(int data[]) {
        int pageNumber = 1;
        for (int firstIndexOnPage = 0;
             firstIndexOnPage < data.length;
             firstIndexOnPage += numbersPerPage) {
            int lastIndexOnPage =
                    Math.min(firstIndexOnPage + numbersPerPage - 1,
                            data.length - 1);
            printPageHeader(pageHeader, pageNumber);
            printPage(firstIndexOnPage, lastIndexOnPage, data);
            printStream.println("\f");
            pageNumber++;
        }
    }

    private void printPage(int firstIndexOnPage,
                           int lastIndexOnPage,
                           int[] data) {
        int firstIndexOfLastRowOnPage =
                firstIndexOnPage + rowsPerPage - 1;
        for (int firstIndexInRow = firstIndexOnPage;
             firstIndexInRow <= firstIndexOfLastRowOnPage;
             firstIndexInRow++) {
            printRow(firstIndexInRow, lastIndexOnPage, data);
            printStream.println("");
        }
    }

    private void printRow(int firstIndexInRow,
                          int lastIndexOnPage,
                          int[] data) {
        for (int column = 0; column < columnsPerPage; column++) {
            int index = firstIndexInRow + column * rowsPerPage;
            if (index <= lastIndexOnPage) {
                printStream.format("%10d", data[index]);
            }
        }
    }

    private void printPageHeader(String pageHeader,
                                 int pageNumber) {
        printStream.println(pageHeader + " --- Page " + pageNumber);
        printStream.println("");
    }

//    public void tigerEat() {
    //        this.printStream = printStream;
    //
    //        while (it.hasNext()) {
    //            Tiger tiger = (Tiger) it.next();
    //            if (!tiger.a()) {
    //                append(error1);
    //            } else {
    //                if (!tiger.b()) {
    //                    append(error2);
    //                } else {
    //                    if (!tiger.c()) {
    //                        append(error3);
    //                    } else {
    //                        if (!tiger.d()) {
    //                            append(error4);
    //                        } else {
    //                            tiger.eat();
    //                        }
    //                    }
    //                }
    //            }
    //        }
    //    }

}