"""
// Time Complexity :
Problem 1 - O(log(m*n)) depending on the rows and columns
Problem 2 - O(log n) as we traverse by decreasing the size of the array
Problem 3 - O(log n) as we traverse by decreasing the size of BIG array
// Space Complexity :
Problem 1 - O(1) as the lookup for my element is just one operation
Problem 2 = O(1og n) at the start and recursively reach to O(1) since the size is decreasing by 2
and ultimately to the last element 
Problem 3 - O(log n) at the start and recursively reach to O(1)
// Did this code successfully run on Leetcode :
Yes the code submission ran successfully.
// Any problem you faced while coding this :
"""

'''// Your code here along with comments explaining your approach in three sentences only'''
#Problem 1 - Search a 2D Matrix
# Imagine the 2D matrix as an 1D array and getting the row and column indices we compare the target
# element. If the element is not at the mid then we either look higher order elements or lower
# order elements of the matrix. If it fails return 'False'
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        m, n = len(matrix), len(matrix[0]) #Get rows and columns of the matrix
        low  = 0
        high = m*n - 1
        
        while(low <= high):
            mid = low + (high - low) // 2
            r = mid//n
            c = mid%n
            if matrix[r][c] == target: #If my first element is equal to target return "True"
                return True
            if matrix[r][c] > target: 
                high = mid - 1 #if the value is greater than target we explore lower order of matrix
            else:
                low = mid + 1 #if value is less than target we explore higher order of matrix
        return False #element is not found we return "False"

#Problem 2 - Search in a Rotated Sorted Array
# For a rotated array the array will have some elements sorted and the other elements will be unsorted
# If the mid element is equal to target we return the mid index or search the element in the unsorted
# elements either the left / right array
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low = 0
        high = len(nums) - 1 #Get the first and last index of the array
        
        while(low <= high):
            mid = low + (high - low) // 2 #Get the middle element using mod function
            #We add 'low' to avoid integer overflow
            if nums[mid] == target: #Optimal scenario where mid element is the target
                return mid
            if nums[low] <= nums[mid]: #Check for the left part of the array
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            else: #Check the right part of the array       
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1   
        return -1 #If target does not exist return -1

#Problem 3 - Search in an infinite sorted array
# Since the array reader is sorted and the maximum size is unknown we will take the upper limit of
# 10^4 as per the constraints. We will search the element in this array, if the mid element is target
# return the index else look at the left or right part of the array
class Solution(object):
    def search(self, reader, target):
        low = 0
        high = 10000
        # Edge case since the array is sorted, if the first element is less than target
        # then return -1 as the array does not have the target  
        if reader.get[0] < target: return -1
        # Split the big array into halves
        # If the mid element is the target return mid or else look for the left array
        # or the right side of the array
        while(low <= high):
            mid = low + (high - low) // 2
            if reader.get[mid] == target: return mid
            if reader.get[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        # if the element does not exist return -1        
        return -1
