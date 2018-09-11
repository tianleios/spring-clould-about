package com.tl.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private static List<Author> create() {
        //
        Author author = new Author();
        author.name = "tian";
        author.age = 10;
        author.area = "zh";
        author.articles = new ArrayList<>();
        author.articles.add(new Article(10L));

        //
        Author author11 = new Author();
        author11.name = "zhang";
        author11.age = 11;
        author11.area = "zh";
        author11.articles = new ArrayList<>();
        author11.articles.add(new Article(11L));

        //
        Author author21 = new Author();
        author21.name = "sun";
        author21.age = 21;
        author21.area = "en";
        author21.articles = new ArrayList<>();
        author21.articles.add(new Article(21L));

        Author author22 = new Author();
        author22.name = "li";
        author22.age = 22;
        author22.area = "en";
        author22.articles = new ArrayList<>();
        author22.articles.add(new Article(22L));

        return new ArrayList<>(Arrays.asList(author, author11, author21, author22));
    }

    public static void main(String[] args) {


        List<Author> authors = create();

        {
            // 1.1
            Map<String, List<Author>> areaAuthorsMap = authors.stream().collect(
                    Collectors.groupingBy(Author::getArea, Collectors.toList())
            );

            // 1.2
            Map<String, List<Long>> areaAuthorIdsMap = authors.stream().collect(
                    Collectors.groupingBy(Author::getArea, Collectors.mapping(Author::getId, Collectors.toList()))
            );
        }

        {

            //3.1 同一个区域下，所有的文章
            Map<String, List<Article>> areaArticlesMap = authors.stream().collect(
                    Collectors.groupingBy(Author::getArea,
                            Collectors.collectingAndThen(
                                    Collectors.toList(),
                                    (r) -> r.stream().map(Author::getArticles).flatMap(List::stream).collect(Collectors.toList()))
                    )
            );

            //3.2 同一个区域下，所有的文章的id
            Map<String, List<Long>> areaIdsMap = authors.stream().collect(
                    Collectors.groupingBy(Author::getArea,
                            Collectors.collectingAndThen(
                                    Collectors.toList(),
                                    (r) -> r.stream().map(Author::getArticles)
                                            .flatMap(List::stream)
                                            .map(Article::getId)
                                            .collect(Collectors.toList()))
                    )
            );
            int a = 10;

        }


        {
            String s = Stream.of("tianlei", "lei").collect(Collectors.joining(",", "[", "]"));
            int sum = Stream.of(1,2,3).collect(Collectors.summingInt(t -> t));
            System.out.println(s);

        }


    }

}
