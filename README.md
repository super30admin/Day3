# Binary-Search-1


## Problem1 Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
# Imagine the 2D matrix as an 1D array and getting the row and column indices we compare the target
# element. If the element is not at the mid then we either look higher order elements or lower
# order elements of the matrix. If it fails return 'False'

## Problem2 Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
# For a rotated array the array will have some elements sorted and the other elements will be unsorted
# If the mid element is equal to target we return the mid index or search the element in the unsorted
# elements either the left / right array

## Problem3 Search in Infinite sorted array: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
## Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.
# Since the array reader is sorted and the maximum size is unknown we will take the upper limit of
# 10^4 as per the constraints. We will search the element in this array, if the mid element is target
# return the index else look at the left or right part of the array
