cd %1
shift
:loop
if "%1"=="" goto endloop
set personName=%1
md %personName%\Strings
md %personName%\Doors
md %personName%\Toaster
md %personName%\Recursion
md %personName%\Lonely
md %personName%\Bonus
md %personName%\Trees
shift
goto loop
:endloop