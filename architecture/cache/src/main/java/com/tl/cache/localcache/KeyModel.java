package com.tl.cache.localcache;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by tianlei on 2019/9/3
 */
public class KeyModel {

    public String name;
    public Integer age;
    public List<String> values;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyModel keyModel = (KeyModel) o;
        return Objects.equals(name, keyModel.name) &&
                Objects.equals(age, keyModel.age) &&
                Objects.equals(values, keyModel.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, values);
    }


    public static void main(String[] args) {

        System.out.println(Objects.equals(Arrays.asList("1", "2"), Arrays.asList("1", "2")));


    }


}


