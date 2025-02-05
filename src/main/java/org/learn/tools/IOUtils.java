/*
 * Copyright (C) 2024 Baidu, Inc. All Rights Reserved.
 */
package org.learn.tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class IOUtils {

    public static String readFully(InputStream is) throws IOException {
        byte[] buf = new byte[1024 * 8];
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while (true) {
            int size = is.read(buf);
            if (size == -1) {
                break;
            }
            bos.write(buf, 0, size);
        }
        return new String(bos.toByteArray(), Charset.defaultCharset());
    }

}
