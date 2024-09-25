""""
Question Description:
    You have a sorted array of unique elements and an unknown size. You do not have access to the array directly, but you can use an ArrayReader interface to access it. You can call ArrayReader.get(i) that:
        - Returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
        - Returns 2^31 - 1 if the i is out of the boundary of the array.
    You are also given an integer target. Return the index k of the hidden array where secret[k] == target or return -1 otherwise.
    You must write an algorithm with O(log n) runtime complexity.

Examples:
=========
Example 1:
    Input: secret = [-1,0,3,5,9,12], target = 9
    Output: 4
    Explanation: 9 exists in secret and its index is 4.
    
Example 2:
    Input: secret = [-1,0,3,5,9,12], target = 2
    Output: -1
    Explanation: 2 does not exist in secret so return -1.
"""

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:


# time complexity: O(log n)
# space complexity: O(1)
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        
        while (reader.get(high)<target):
            low = high
            high = high*2

        while low<=high:
            mid = low + (high-low)//2

            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid-1
            else:
                low = mid+1

        return -1

# Time Complexity: O(log n), where n is the index where the target is found
# Space Complexity: O(1)