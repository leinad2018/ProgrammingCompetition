cd %1
shift
:loop
if "%1"=="" goto endloop
set personName=%1
md %personName%\hoo
md %personName%\fractal
md %personName%\fishytoo
md %personName%\flowers
md %personName%\sums
md %personName%\nurikabe
md %personName%\troll
md %personName%\dollar
md %personName%\bird
md %personName%\eggs
md %personName%\lobster
shift
goto loop
:endloop