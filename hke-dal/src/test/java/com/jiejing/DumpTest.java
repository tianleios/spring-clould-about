package com.jiejing;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;

/**
 * Created by songben on 16/9/20.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath*:com/jiejing/spring/applicationContext*.xml")
public class DumpTest {

    public static void main(String[] args){
        String name = "a";
        String filePath = "/Users/songben/logs/" + name + ".sql";
        Runtime rt = Runtime.getRuntime();
        try {
            StringBuffer cmd = new StringBuffer();
            cmd.append("/usr/local/mysql-5.7.13-osx10.11-x86_64/bin/mysqldump");
            cmd.append(" --host=10.0.0.7");
            cmd.append(" -uroot -proot");
            cmd.append(" --databases xiaomai");
            cmd.append(" --no-tablespaces");
            cmd.append(" --skip-add-drop-table");
            cmd.append(" --no-create-info");
            cmd.append(" --quote-names");
            cmd.append(" --tables institution institution_student");
            cmd.append(" --where 'inst_id=20160309121062 or inst_id=20160314121071 or inst_id=20160314121073'");
            cmd.append(" --result-file /Users/songben/logs/b.sql");
            System.out.println(cmd.toString());
            Process child = rt.exec(cmd.toString());
//            InputStream in = child.getInputStream();
//            InputStreamReader ir = new InputStreamReader(in, "utf8");
//            // 输出文件
//            FileOutputStream fo = new FileOutputStream(filePath);
//            OutputStreamWriter os = new OutputStreamWriter(fo, "utf8");
//            // 开始读取数据
//            char[] temp = new char[1024000];
//            int len = 0;
//            while ((len = ir.read(temp)) > 0) {
//                os.write(temp, 0, len);
//                os.flush();
//            }
//            in.close();
//            ir.close();
//            os.close();
//            fo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
