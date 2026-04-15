package main

import (
	"fmt"
)

func main() {
	// Example test case
	words := []string{"hello", "i", "am", "leetcode", "hello"}
	fmt.Println(closestTarget(words, "hello", 1))
}

// closestTarget finds the shortest distance to a target string in a circular array.
// It returns -1 if the target is not found.
func closestTarget(words []string, target string, startIndex int) int {
	n := len(words)
	res := -1

	for i, word := range words {
		if word == target {
			// Calculate linear distance between current index and start
			dist := abs(i - startIndex)
			// Calculate wrap-around distance
			wrapDist := n - dist
			// Get the minimum of the two distances
			currDist := min(dist, wrapDist)
			// Update the result if the current distance is smaller than the previous result
			if res == -1 || currDist < res {
				res = currDist
			}
		}
	}
	return res
}

// abs is a helper to return the absolute value of an integer.
func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
