@echo off
rem This batch script runs a Python script that converts text files to audio using pyttsx3.

rem Set the path to your Python script
set PYTHON_SCRIPT=notes_to_audio.py

rem Check if the Python script file exists
if not exist %PYTHON_SCRIPT% (
    echo Python script not found: %PYTHON_SCRIPT%
    pause
    exit /b
)

rem Run the Python script
echo Running the Python script...
python %PYTHON_SCRIPT%

rem Pause to keep the command prompt window open after script execution
pause
