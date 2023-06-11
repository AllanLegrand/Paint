#!/bin/bash
if [ -d "bin" ];
then
    rm -r bin
fi
mkdir bin
echo $(find . -type f -iname "*.java") > compil.list 
javac -d bin @compil.list
export CLASSPATH=$CLASSPATH:$(pwd)/bin
if [ "$#" -eq 0 ]; then
    java controleur.Controleur -cp "./bin"
else 
    java "$1" -cp "./bin"
fi