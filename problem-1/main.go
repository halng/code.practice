package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func sub(a, b int) int {
	return a - b
}

func main() {
	file, err := os.Open("./problem-1/INPUT")
	if err != nil {
		fmt.Println("Failed to open file:", err)
		return
	}
	defer file.Close()

	scanner := bufio.NewScanner(file)
	scanner.Split(bufio.ScanWords)

	var a, b int
	if scanner.Scan() {
		a, err = strconv.Atoi(scanner.Text())
		if err != nil {
			fmt.Println("Invalid argument:", scanner.Text())
			return
		}
	} else {
		fmt.Println("Failed to read argument a from file")
		return
	}

	if scanner.Scan() {
		b, err = strconv.Atoi(scanner.Text())
		if err != nil {
			fmt.Println("Invalid argument:", scanner.Text())
			return
		}
	} else {
		fmt.Println("Failed to read argument b from file")
		return
	}

	result := sub(a, b)

	fmt.Println(result)
}