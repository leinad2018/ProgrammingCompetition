cd %1
set homeDirectory=%CD%
set personName=%2
set programName=%3
set inputPath=%4
set fullPath=%homeDirectory%\%personName%\%programName%
call TestProgram.bat %homeDirectory% %personName% %programName% %inputPath% >> %fullPath%\Output.txt
call cscript CompareOut.vbs %fullPath%\Output.txt %homeDirectory%\OurPrograms\%programName%Out.txt %time% > %fullPath%\Answer.txt