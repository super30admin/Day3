/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * type ArrayReader struct {
 * }
 *
 * func (this *ArrayReader) get(index int) int {}
 */

// learning #golang #leetcode
// time complexity: O(log(n))
// space complexity: O(1)

package main

func search(reader ArrayReader, target int) int {
	low, high := 0, 1

	for reader.get(high) < target {
		low = high
		high = high * 2
	}

	for low <= high {
		mid := low + (high-low)/2

		if reader.get(mid) == target {
			return mid
		} else if reader.get(mid) < target {
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return -1
}
