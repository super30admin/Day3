"""
This is an interactive problem.

You have a sorted array of unique elements and an unknown size. You do not have an access to the array but you can use the ArrayReader interface to access it. 
You can call ArrayReader.get(i) that: 
returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
returns 231 - 1 if the i is out of the boundary of the array.
You are also given an integer target.

Return the index k of the hidden array where secret[k] == target or return -1 otherwise.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: secret = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in secret and its index is 4.

Example 2:

Input: secret = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in secret so return -1.

Time Complexity : O(logT), where T is an index of target value.
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# The approach uses an exponential search strategy to determine the search boundaries, followed by binary search to efficiently locate the target. 
# First, checked if the target is at index 0; if not, we expand the search range exponentially until the value exceeds the target. 
# Finally, performed a binary search within the identified range to find the target index or return -1 if not found.

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:

        if reader.get(0) == target:
            return 0
        
        left, right = 0, 1
        while reader.get(right) < target:
            left = right
            right <<= 2
            
        while left <= right:
            mid = (left + right) // 2
            num = reader.get(mid)

            if num == target:
                return mid
            elif num > target:
                right = mid - 1
            elif num < target:
                left = mid + 1

        return -1
