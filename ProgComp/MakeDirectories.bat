cd C:\Users\Daniel\Desktop\ProgComp
:loop
if "%1"=="" goto endloop
set personName=%1
md %personName%\Strings
md %personName%\Doors
md %personName%\Toaster
shift
goto loop
:endloop