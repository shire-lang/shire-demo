package com.phodal.shire.demo.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
    public static void readFile(String filePath) throws Exception { // 不必要的 throws Exception
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // 直接输出到控制台，可能会提示不建议
            }
        } catch (IOException e) {
            e.printStackTrace(); // 不推荐直接打印堆栈跟踪
        } finally {
            // 忘记关闭资源
        }
    }

    public static String processFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath)); // 没有使用 try-with-resources
        String content = reader.readLine();
        return content; // 资源未关闭
    }
}
