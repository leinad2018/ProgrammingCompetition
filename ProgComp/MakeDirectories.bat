cd %1
shift
:loop
if "%1"=="" goto endloop
set personName=%1
md %personName%\Strings
md %personName%\Doors
md %personName%\HelloWorld
shift
goto loop
:endloop