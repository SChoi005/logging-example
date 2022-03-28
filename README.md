# Logging (Logback)

## Why to use logging?
> We can diagnose unexpected problems with applications during developing or after developing and collect much information.
In cases of user's log, those can be used as analyzed data.

## Logback has five log levels
1. Erorr : In cases of occuring seriously unexpected problems, level to handle immediately.
2. Warn : Parts of checking validation of logic, exceptional handling of thinkable problems and not affecting service operation right now but looking out. 
3. Info : Notes for operation, critical bussiness processes completed.
4. Debug : It is used at developing stage and can do SQL logging.
5. Trace: Because tracing about all levels, It is used at developing stage .

## Log printing
> There is spring-boot-starter-logging in springboot. it uses Logback. it is common process of log printing to print both start and end of fuction required. Logback can improve traceability putting information of user ID or request ID through using MDC(mapped diagnostic context).

## Set custom log
> customization of Logback is logback-spring.xml, logback-spring.groovy, logback.xml, or logback.groovy.

## How to use Logback
> write logging.config like "logging.config=classpath:logback/logback-spring.xml" in application.properties. logback-spring.xml must be situated at src/main/java/resources.

## Log rotation
> If the size of log file is over upper limit, rotation would happen. we can divide log file through changing setting by date.

## caution
> Because debug and trace levels stack lots of logs, we cannot to handle volume of them. so it is better that unimportant information is set under debug level and not to do logging.
Use debug and trace levels only at developing stage and do not use at deployment stage.

interceptor 이해 및 로그 저장되도록하기


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