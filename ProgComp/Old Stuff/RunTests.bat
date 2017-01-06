set filePath=%1
set personName=%2
set programName=%3
set inputFile=%4
set /p "inputText= < %inputFile%"
call WriteOutput.bat %filePath% %personName% %programName% %inputText%
cd %filePath%
cscript CompareOut.vbs %filePath%\%personName%\%programName%\Output.txt %filePath%\OurPrograms\%programName%Out.txt %time% > %filePath%\%personName%\%programName%\Answer.txt
pause