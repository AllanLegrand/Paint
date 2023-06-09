if [ -d "bin" ];
then
    rm -r bin
fi
mkdir bin
echo $(find . -type f -iname "*.java") > compil.list 
javac -d bin @compil.list