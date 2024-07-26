# Binary-Search-1


## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

The 1D matrix indices can be equated to row and col values in a 2D matrix as follows
row = index/row.size
col = index%row.size

## Problem2 
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

In a rotated sorted array, upon considering the mid point we notice that either side of the mid point is always sorted.
We identify which side of the array is sorted by checking if either low <= mid or mid <= high
We leverage these facts to our advantage and apply binary search.



## Problem3
Search in Infinite sorted array: 

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

