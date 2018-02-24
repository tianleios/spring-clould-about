#!/usr/local/bin

##1.打包jar
mvn clean package  -Dmaven.test.skip=true

##2.构建镜像
docker build -t tl-spring-boot-first-docker:1.0.0 .

##3.运行
docker run -p 8080:8080 -t tl-spring-boot-first-docker:1.0.0
