package com.tl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Properties;

/**
 * Created by tianlei on 2019/8/25
 */
public class mall {



    private static Boolean queryExhibitionSwitch = true;

    private static Map<String, Field> keyFieldMap = Maps.newHashMap();


    static  {

        Field[] fields = mall.class.getDeclaredFields();

        for (Field field : fields) {
            boolean isStatic = Modifier.isStatic(field.getModifiers());
            if (!isStatic) {
                continue;
            }

            keyFieldMap.put(field.getName(), field);

        }

    }

    public static void load(Properties properties) {





            keyFieldMap.forEach((key, field) -> {

                try {

                    String value = properties.getProperty(key);
                    Class filedClass = field.getClass();
                if (filedClass.isAssignableFrom(Long.class)) {
                    field.set(null, Long.valueOf(value));
                } else if (filedClass.isAssignableFrom(Integer.class)) {
                    field.set(null, Integer.valueOf(value));
                } else if (filedClass.isAssignableFrom(String.class)) {
                    field.set(null, Integer.valueOf(value));
                }

            } catch (Exception e) {

            }
            });


    }

   public static void main() {


       Properties properties = new Properties();
       properties.put("queryExhibitionSwitch", "true");


   }

}


