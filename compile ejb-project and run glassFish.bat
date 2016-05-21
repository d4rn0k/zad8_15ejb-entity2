@echo on

set GLASSFISH=C:\glassfish4\glassfish
cd ejb-project\

echo Delete all ejb-project *.class files
del GameManager.class pl\jrj\game\IGameRemote.class

echo Compile project: [IGameRemote GameManager] files
javac ^
-d . ^
-classpath %GLASSFISH%\lib\javaee.jar;^
%GLASSFISH%\lib\gf-grade.jar;. ^
pl\jrj\game\IGameRemote.java GameManager.java ^
-Xlint
REM %GLASSFISH%\lib\gf-grade.jar;.^
REM %GLASSFISH%\lib\;^
REM %GLASSFISH%\modules\;. ^


echo Start glassfish Server
call %GLASSFISH%\bin\asadmin.bat stop-domain
call %GLASSFISH%\bin\asadmin.bat start-domain


echo [AUTODEPLOY] Create .jar from .class and move to glassfish domain1 catalog
jar cvf %GLASSFISH%\domains\domain1\autodeploy\ejb-project.jar pl\jrj\game\IGameRemote.class GameManager.class

pause