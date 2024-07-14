# !/bin/bash

# get a first line of a file and convert to number and add 1 to it
first_line=$(head -n 1 INDEX)
number=$((first_line + 1))

# update the first line of the file
sed -i "1s/.*/$number/" INDEX

# create a new file with the number
mkdir problem-$number
cp -r template/* problem-$number

echo "Created problem-$number"