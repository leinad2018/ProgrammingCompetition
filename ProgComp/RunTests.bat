set homeDirectory=%1
set personName=%2
set programName=%3
set inputPath=%4
set fullPath=%homeDirectory%\%personName%\%programName%
call TestProgram.bat %homeDirectory% %personName% %programName% %inputPath% >> %fullPath%\Output.txt
cscript CompareOut.vbs %fullPath%\Output.txt %homeDirectory%\OurPrograms\%programName%Out.txt %time% >> %fullPath%\Answer.txt