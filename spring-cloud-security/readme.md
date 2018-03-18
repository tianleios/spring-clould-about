spring-security-demo 事比较单独的，用来学习spring-security 和 整个工程没有直接联系。spring-security-demo 只是一个spring-boot项目


discovery 为公用模块

## 1. dicovery 和 以jwt开头的项目，可以组成一组，使用jwt做token存储

主要包括 `jwt-auth-service` 和 `jwt-resource-service`

## 2. dicovery 和 不以jwt开头的项目，可以组成一组，进行测试，使用Redis 作为token存储
