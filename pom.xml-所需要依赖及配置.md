# **pom.xml-所需要依赖**

## 🍓1. mybatis-plus（连接数据库）

```xml
<!--连接数据库-->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.2</version>
</dependency>
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-generator</artifactId>
    <version>3.5.2</version>
</dependency>
<dependency>
    <groupId>org.apache.velocity</groupId>
    <artifactId>velocity-engine-core</artifactId>
    <version>2.2</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
</dependency>
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
```

Mybatis-plus在application.yml中进行下列配置

```yml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.zaxxer.hikari.HikariDataSource
    url: jdbc:mysql://localhost:3306/stu_score?serverTimezone=Asia/Shanghai&characterEncoding=utf-8&useSSL=false
    #    jdbc:mysql://address=(protocol=tcp)(host=fe80::a00:27ff:fec3:87c7)(port=3306)/database
    username: root
    password: 123456
  servlet:
    multipart:
      enabled: true
      max-file-size: 20MB
      max-request-size: 200MB
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl

    # 如果是放在src/main/java目录下 classpath:/com/*/*/mapper/*Mapper.xml
    # 如果是放在resource目录 classpath:/mapper/**.xml
  mapper-locations: classpath:/mapper/**.xml
#spring.servlet.multipart.enabled=true
#spring.servlet.multipart.max-file-size=20MB
#spring.servlet.multipart.max-request-size=200MB
```

## 🍓2. thymeleaf（数据渲染到前端）

```xml
<!-- 引入thymeleaf的依赖-->
<dependency>
    <groupId>org.thymeleaf</groupId>
    <artifactId>thymeleaf-spring5</artifactId>
    <version>3.0.13.RELEASE</version>
</dependency>
```

前端 .html中需要加上一个标签

```html
<!--<html lang="en" xmlns:th="http://www.thymeleaf.org">-->
```

## 🍓3. freemarker（视图解析-模板引擎）

FreeMarker 是一款 模板引擎： 即一种基于模板和要改变的数据， 并用来生成输出文本(HTML网页，电子邮件，配置文件，源代码等)的通用工具。 是一个Java类库。

```xml
<!--引入freemarker依赖-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-freemarker</artifactId>
</dependency>
```

​		freemarker（视图解析-模板引擎）在application.yml中进行下列配置

```yml
#配置 freemarker
spring:
  freemarker:
    cache: false  #是否开启缓存
    charset: UTF-8  #字符集
    template-loader-path: "classpath:/templates/" #去哪里找视图
    suffix: .html #找已什么结尾的视图
```

## 🍓4. Mybatis（连接数据库）

```xml
<!--Mybatis数据库-->
        <!--mybatis启动器-->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>3.0.0</version>
        </dependency>
        <!--数据库连接的依赖-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.25</version>
            <scope>runtime</scope>
        </dependency>
```

Mybatis在application.yml中进行下列配置

```yml
#连接数据库
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/java_practice?serverTimezone=Asia/Shanghai&characterEncoding=utf-8&useSSL=false
    driver-class-name: com.mysql.jdbc.Driver
    username: root 
    password: 123456
```

​		当mysql查询语句是使用xml配置的形式（在resources下的mapper包下的xxx-Mapper.xml）时，需要在application.yml中配置路径

```yml
mybatis:
  mapper-locations: classpath:/mapper/**.xml
```

