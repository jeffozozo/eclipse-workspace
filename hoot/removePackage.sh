for f in *.java; do 
echo "Processing $f file..";
sed '/package*/d' ./$f > $f.tmp 
mv $f.tmp $f
done
