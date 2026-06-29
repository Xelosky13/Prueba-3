@echo off
title Iniciando Proyecto Spring Boot
echo =======================================================
echo Levantando el sistema de Pedidos y Despachos...
echo =======================================================

:: Limpia archivos viejos y levanta el servidor usando Maven
call mvnw.cmd clean spring-boot:run

echo.
echo =======================================================
echo El servidor se ha detenido o ha ocurrido un error.
echo Revisa los mensajes de arriba.
echo =======================================================
pause