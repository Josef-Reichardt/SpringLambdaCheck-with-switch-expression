Demo application to demonstrate an issue using the spring-javaformat checkstyle rules with `switch` expressions.

## Issue

The default spring-javaformat checkstyle rules includes the `SpringLambdaCheck` which throws the following exception if
the source code contains a `switch` expression.

## Example source code

```java
String message = switch (args.length) {
case 0 -> "No arg";
case 1 -> "One arg";
default -> getText.apply(args.length);
};
```

A full code example could be found in this repository:
* POM: [`pom.xml`](pom.xml)
* Checkstyle config: [`checkstyle.xml`](checkstyle.xml)
* Example Java class: [`SampleApplication.java`](src/main/java/sample/SampleApplication.java)

## Exception

```shell
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-checkstyle-plugin:3.1.2:check (default-cli) on project spring-javaformat-maven-sample: Failed during checkstyle configuration: Exception was thrown while processing /home/reichardt/Projects/_github/SpringLambdaCheck-with-switch-expression/src/main/java/sample/SampleApplication.java: Cannot invoke "com.puppycrawl.tools.checkstyle.api.DetailAST.getChildCount(int)" because "ast" is null -> [Help 1]
```

## How to reproduce

1. Clone this repo
2. Run `mvn checkstyle:check`  
   &rarr; The error occurs

## Workaround

Exclude the `SpringLambdaCheck`, see comment in [`checkstyle.xml`](checkstyle.xml).
