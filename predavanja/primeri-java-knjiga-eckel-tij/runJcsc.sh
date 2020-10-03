find . -name *.java -exec jcsc.sh -r c:/CVS/TIJ3/tij.jcsc {} \; | grep -v 'Ok' | grep -v 'NCSS count:'
