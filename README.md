# Logging

## Why to use logging?
> We can diagnose unexpected problems with applications during developing or after developing and collect much information.
In cases of user's log, those can be used as analyzed data.

## Logback has five log levels
1. Erorr : In cases of occuring seriously unexpected problems, level to handle immediately.
2. Warn : Parts of checking validation of logic, exceptional handling of thinkable problems and not affecting service operation right now but looking out. 
3. Info : Notes for operation, critical bussiness processes completed.
4. Debug : It is used at developing stage and can do SQL logging.
5. Trace: Because tracing about all levels, It is used at developing stage .

## caution
> Because debug and trace levels stack lots of logs, we cannot to handle volume of them. so it is better that unimportant information is set under debug level and not to do logging.
Use debug and trace levels only at developing stage and do not use at deployment stage.