# !/bin/bash

# get a first line of a file and convert to number and add 1 to it
first_line=$(head -n 1 INDEX)
number=$((first_line + 1))

# update the first line of the file
sed -i "1s/.*/$number/" INDEX

# create a new file with the number
mkdir problem-$number
touch problem-$number/main.cpp problem-$number/main.rs problem-$number/main.py problem-$number/README.md problem-$number/main.go problem-$number/main.java

echo "Created problem-$number"