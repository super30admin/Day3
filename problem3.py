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

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        
        return -1