FROM hub.c.163.com/bingohuang/jdk8:latest
COPY target/tl-1.0.jar /app.jar
## 在容器启动时默认执行启动命令 java -jar /app.jar
## 只允许有一个 ENTRYPOINT 多个 ENTRYPOINT 执行最后一个
## 可以有多个cmd

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]

#项目根目录下执行jav
# 1. docker build -t tl-spring-boot-first-docker:1.0.0 .
# 2. docker run -p 8080:8080 -t tl-spring-boot-first-docker:1.0.0