# **pom.xml-所需要依赖**

## 1. mybatis-plus（连接数据库）

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

## 2. thymeleaf（数据渲染到前端）

```xml
<!-- 引入thymeleaf的依赖-->
<dependency>
    <groupId>org.thymeleaf</groupId>
    <artifactId>thymeleaf-spring5</artifactId>
    <version>3.0.13.RELEASE</version>
</dependency>
```

## 3. freemarker（模板引擎）

FreeMarker 是一款 模板引擎： 即一种基于模板和要改变的数据， 并用来生成输出文本(HTML网页，电子邮件，配置文件，源代码等)的通用工具。 是一个Java类库。

```xml
<!--引入freemarker依赖-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-freemarker</artifactId>
</dependency>
```

​		freemarker（模板引擎）在application.yml中进行下列配置

```yml
#配置 freemarker
spring:
  freemarker:
    cache: false  #是否开启缓存
    charset: UTF-8  #字符集
    template-loader-path: "classpath:/templates/" #去哪里找视图
    suffix: .html #找已什么结尾的视图
```

