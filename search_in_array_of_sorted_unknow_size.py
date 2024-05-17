"""
Binary-Search-1
Problem3
Search in Infinite sorted array:

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. 
Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. 
If it isn’t present, return -1.


Time Complexity : O(logn)
Space Complexity :  O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Idea behind this problem is to find the high, so to find the high, we iterage through the reader by checking if current target lies under the current high
by incrementing the high index twice to the current along with low to high since there's no point of keeping low at 0 if the target doesn't lie in that range.
Once the loop breaks, we'll find the high and now we apply the regular binary search, and we return the mid index. Only thing to note is we have to access the values 
using ArrayReader while performing the binary search.
"""

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low, high = 0, 1

        while(reader.get(high) < target):
            low = high
            high = high * 2

        while low <= high:
            mid = low + (high - low) // 2

            if reader.get(mid) == target:
                return mid
            elif target > reader.get(mid):
                low = mid + 1
            else:
                high = mid - 1

        return -1 