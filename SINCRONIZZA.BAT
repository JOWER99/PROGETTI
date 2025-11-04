@echo off
cd /d "%~dp0"
echo ==============================
echo   SINCRONIZZA - Scarico da GitHub
echo ==============================
git pull origin main
pause
