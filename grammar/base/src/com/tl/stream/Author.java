package com.tl.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Author {

    public Long id;
    public String area;
    public Integer age;
    public String name;
    public List<Article> articles;

    public Long getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public String getArea() {
        return area;
    }

    public static void main(String[] args) {


        List<Author> authors = new ArrayList<>();

        {
            Map<String, List<Long>> areaIdsMap = authors.stream().collect(
                    Collectors.groupingBy(Author::getArea, Collectors.mapping(Author::getId, Collectors.toList()))
            );
        }

        {
//            Map<String, List<List<Article>>> areaIdsMap =
            authors.stream().collect(

                    Collectors.groupingBy(Author::getArea, Collectors.mapping(Author::getArticles, Collectors.toList()))

            );

        }


    }

}
