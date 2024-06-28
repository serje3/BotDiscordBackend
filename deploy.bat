@echo off
set SERVER_USER=
set SERVER_IP=
set SERVER_PASSWORD=
set SERVER_SERVICE_NAME=

rem Собрать приложение
call :build
+
rem Выход
exit /b

:deploy
echo Deploying the application...
scp ./build/libs/java-discord-bot-backend-1.0.0.jar %SERVER_USER%@%SERVER_IP%:/java-discord-bot-backend-1.0.0.jar
goto :eof

:restart_service
echo Restarting the service on the server...
ssh %SERVER_USER%@%SERVER_IP% sudo systemctl restart %SERVER_SERVICE_NAME%
goto :eof