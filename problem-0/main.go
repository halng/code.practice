package main

import (
	"fmt"
	"os"
	"strconv"
)

func sum(a, b int) int {
	return a + b
}

func main() {
	args := os.Args[1:]
	if len(args) < 2 {
		fmt.Println("Please provide two integer arguments.")
		return
	}

	a, err := strconv.Atoi(args[0])
	if err != nil {
		fmt.Println("Invalid argument:", args[0])
		return
	}

	b, err := strconv.Atoi(args[1])
	if err != nil {
		fmt.Println("Invalid argument:", args[1])
		return
	}

	result := sum(a, b)

	fmt.Println(result)
}