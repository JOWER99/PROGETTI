@echo off
cd /d "%~dp0"
echo ==============================
echo   CARICA - Invio modifiche su GitHub
echo ==============================

set /p msg=Scrivi il messaggio per il commit: 
echo Il messaggio sarà: "%msg%"
choice /m "Vuoi procedere?"

if errorlevel 2 (
    echo Operazione annullata.
    pause
    exit /b
)

git add .
git commit -m "%msg%"
git push origin main
pause
