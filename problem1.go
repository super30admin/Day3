// learning #golang #leetcode
// time complexity: O(log(m*n))
// space complexity: O(1)
package main

func searchMatrix(matrix [][]int, target int) bool {
	m := len(matrix)
	n := len(matrix[0])

	low, high := 0, (m*n)-1

	for low <= high {
		mid := low + (high-low)/2

		r := mid / n
		c := mid % n

		if target == matrix[r][c] {
			return true
		} else if target < matrix[r][c] {
			high = mid - 1
		} else {
			low = mid + 1
		}
	}
	return false
}
