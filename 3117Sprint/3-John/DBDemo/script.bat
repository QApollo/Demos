@echo off
echo [90mPatching cmd ...[0m

:: install custom user defined commands
DOSKEY ls = dir /B /O:GN $*
::DOSKEY np++ = notepad++.exe $*
DOSKEY np   = notepad++.exe $*

:: alias to build java program localy to build directory 
DOSKEY build = javac -Xlint:unchecked -d .\build *.java

:: alias to run java program from build directory.
:: expected prameter is name of class with main()
DOSKEY run = java -Dfile.encoding=UTF-8 -enableassertions -cp .\build $*
DOSKEY runDerby = java -ea -cp ".\build;%JAVA_HOME%\db\lib\derby.jar" $*