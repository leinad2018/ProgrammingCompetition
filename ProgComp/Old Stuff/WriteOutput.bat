set filePath=%1
set personName=%2
set programName=%3
set inputText=%4
set fullFilePath=%filePath%\%personName%\%programName%
javac %fullFilePath%\%programName%.java
cd %fullFilePath%
java %programName% %inputText% >> Output.txt