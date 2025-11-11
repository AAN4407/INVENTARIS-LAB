@echo off
echo ========================================
echo JavaFX MVC Template Application
echo ========================================
echo.

where mvn >nul 2>nul
if %ERRORLEVEL% NEQ 0 (
    echo ERROR: Maven tidak ditemukan!
    echo Pastikan Maven sudah terinstall dan ada di PATH
    echo.
    pause
    exit /b
)

echo Maven ditemukan! Menjalankan aplikasi...
echo.

call mvn javafx:run

echo.
echo ========================================
pause
