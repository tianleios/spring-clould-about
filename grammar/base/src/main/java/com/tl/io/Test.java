package com.tl.io;

import java.util.Scanner;

/**
 * Created by tianlei on 2019/2/18
 */
public class Test {

//    public static void main(String[] args) throws Exception {
//
//            char c;
//            // 使用 System.in 创建 BufferedReader
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println("输入字符, 按下 'q' 键退出。");
//            // 读取字符
//            do {
//                c = (char) br.read();
//                System.out.println(c);
//            } while (c != 'q');
//
//    }

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            // 从键盘接收数据

            // next方式接收字符串
            System.out.println("next方式接收：");
            // 判断是否还有输入
            if (scan.hasNext()) {
                String str1 = scan.next();
                System.out.println("输入的数据为：" + str1);
            }
//            scan.close();
        }

}
