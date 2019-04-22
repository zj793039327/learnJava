/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package org.learn.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 第一个可以执行的web接口
 * 最原始的...
 * Created by zhangjing56 on 17/7/17.
 */
public class HelloWorldServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("WebAppServlet Executed");
        out.flush();
        out.close();
    }
}
