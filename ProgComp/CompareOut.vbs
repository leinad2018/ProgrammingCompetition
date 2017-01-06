dim otherFilePath:otherFilePath = WScript.Arguments(0)
dim ourFilePath:ourFilePath = WScript.Arguments(1)
dim timeStamp:timeStamp = WScript.Arguments(2)
set FSO = CreateObject("Scripting.FileSystemObject")
set TestFile = FSO.OpenTextFile(otherFilePath,1)
set CorrectFile = FSO.OpenTextFile(ourFilePath,1)
output = TestFile.ReadAll
correct = CorrectFile.ReadAll
WScript.echo StrComp(output,correct)
if InStr(output,"Compile error") <> 0 then
	WScript.echo "Compile Error"
End if
if (InStr(output,"Runtime error") <> 0) then
	WScript.echo "Runtime Error"
End if
WScript.echo timeStamp