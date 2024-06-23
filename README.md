# Binary-Search-1


## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

We will image a matrix as a 2D matrix and then we will calculate mid index and accordingly calculate row index and col index. 
Then we will apply simple binary search on it where if the current mid element is less than target then go right otherwise go left.
This we can achieve by updating low and high pointers. 



## Problem2 
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

Main idea in this problem is always one side will be sorted and one side will unsorted in rotated sorted array. 
First we will check which side is sorted with checking low element is less than mid element.
Then first we will go to sorted side and check element lies in the sorted side or not and change the index accordingly.
If the second is sorted then again we will go to sorted side and check if the mid element is less than high element and change index accordingly. 




## Problem3
Search in Infinite sorted array: 

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

We will take pointer on first element first then will multiply it with 2 until we find a range the element lies in.
Once we find the range we will perform simple binary search on it.
If we do not find the element we will return -1.

