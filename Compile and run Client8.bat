@echo off

set GLASSFISH=C:\glassfish4\glassfish
cd src\



copy pl\jrj\game\IGameRemote.java .
echo KOMPILACJA:
javac ^
-d . ^
-classpath ^
%GLASSFISH%\lib\javaee.jar;^
%GLASSFISH%\lib\sqljdbc4.jar; ^
Grade.java IGameRemote.java *.java ^
-Xlint

del IGameRemote.java

REM cls

echo Uruchomienie:
java -classpath ^
%GLASSFISH%\lib\appserv-rt.jar;^
%GLASSFISH%\lib\javaee.jar;^
%GLASSFISH%\lib\sqljdbc4.jar;. ^
Grade "wejscie.txt"

echo Clean
del *.class 

pause