package com.phodal.shire.demo.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * FileUtil 类包含用于文件处理的实用方法。
 *
 * <p>该类中包含以下 public 静态方法：</p>
 *
 * <ul>
 *     <li>{@link #readFile(String)}：读取指定路径的文件内容，并将其逐行输出到控制台。</li>
 *     <li>{@link #processFile(String)}：处理指定路径的文件，读取文件的第一行内容。</li>
 * </ul>
 *
 * @author xx
 */
public class FileUtil {
    /**
     * 读取指定路径的文件内容，并将其逐行输出到控制台。
     *
     * <pre>
     *    {@code
     *        try {
     *            FileUtil.readFile("/path/to/file.txt");
     *        } catch (Exception e) {
     *            // 适当的异常处理
     *        }
     *    }
     * </pre>
     *
     * @param filePath 要读取的文件的路径
     * @throws Exception 当读取文件过程中发生错误时抛出
     */
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

    /**
     * 处理指定路径的文件，读取文件的第一行内容。
     *
     * <pre>
     *    {@code
     *        String content = FileUtil.processFile("/path/to/file.txt");
     *        // content 包含了文件的第一行内容
     *    }
     * </pre>
     *
     * @param filePath 要处理的文件路径
     * @return 返回文件的第一行内容
     * @throws IOException 如果发生I/O错误
     */
    public static String processFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath)); // 没有使用 try-with-resources
        String content = reader.readLine();
        return content; // 资源未关闭
    }
}
