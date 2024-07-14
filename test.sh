#!/usr/bin/bash

# get the first line of the file index
number=$(head -n 1 INDEX | tr -d '\r')
number=$((number))

# for each number from 1 to 10
for (( i=0; i<=$number; i++ ));
do
    # Run test for python file
    echo "Running test for problem-$i"
    python3 problem-$i/main.py
done