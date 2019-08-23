# CheckStyle
## 简介
    - Checkstyle 是一款检查 Java 代码样式的工具. 它默认支持 Google 的代码风格规范和 Sun 的代码风格规范。
    - 特别适用于小组开发时彼此间的样式规范和统一。
    - Checkstyle 也是高度可定制的, 可以根据自己/公司/组织的情况进行配置.
## 主要检查内容
    Javadoc注释
    命名约定
    标题
    Import语句
    体积大小
    空白
    修饰符
    块
    代码问题
    类设计
    混合检查（包括一些有用的比如非必须的System.out和printstackTrace）
## 主要使用
    maven-site-plugin
    maven-checkstyle-plugin
    [!Google Style](https://github.com/google/styleguide)
    [!CheckStyle](https://github.com/checkstyle/checkstyle)

# 运行
## pom.xml编写
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-site-plugin</artifactId>
            <version>3.7</version>
            <dependencies>
                <dependency>
                    <groupId>org.apache.maven.doxia</groupId>
                    <artifactId>doxia-site-renderer</artifactId>
                    <version>1.8.1</version>
                </dependency>
                <dependency>
                    <groupId>org.apache.maven.doxia</groupId>
                    <artifactId>doxia-core</artifactId>
                    <version>1.8</version>
                </dependency>
            </dependencies>
        </plugin>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-checkstyle-plugin</artifactId>
            <version>3.0.0</version>
            <dependencies>
                <dependency>
                    <groupId>com.puppycrawl.tools</groupId>
                    <artifactId>checkstyle</artifactId>
                    <version>8.12</version>
                </dependency>
            </dependencies>
        </plugin>
    </plugins>
</build>

<reporting>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-checkstyle-plugin</artifactId>
            <configuration>
                <configLocation>my-checkstyle.xml</configLocation>
                <encoding>${encoding}</encoding>
                <consoleOutput>true</consoleOutput>
                <failsOnError>false</failsOnError>
            </configuration>
        </plugin>
    </plugins>
</reporting>
```
 
## 配置文件
    my-checkstyle.xml 基于 （https://github.com/checkstyle/checkstyle/blob/master/src/main/resources/google_checks.xml）改写，
    注销了JavaDoc的相应检测

## 命令
    mvn clean compile site
## 结果
    maven-site-plugin 插件会按照Reporting标签配置的插件在项目根目录的target/site/生成一个project-reports.html
    maven-pmd-plugin 插件

# Jenkins配置
    安装checkstyle插件
    配置命令：mvn -U clean compile site
    配置展示

# 原理
    CheckStyle配置是通过指定modules来应用到java文件
    modules是树状结构，以Checker的module作为root节点，一般的checker都会包括TreeWaler子目录
    可按照google_checks.xml，google的java语言规范
    配置文件中通过module的name属性来区分module
    module的properties可以控制如何去执行这个module
    每个property都有默认值
    所有的check都有一个severity属性，用它来指定check的level
    TreeWalker为每个java文件创建一个语法树，在节点之间调用submodules的Checks
    
