@echo off
set homeDirectory=%1
set personName=%2
set programName=%3
set inputPath=%4
set fullPath=%homeDirectory%\%personName%\%programName%
cd %fullPath%
javac %programName%.java || echo Compile error
java %programName% < %inputPath% || echo Runtime error
cd %homeDirectory%
