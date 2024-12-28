#  Time Complexity: O(log(n))
#  Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach 
# Search in Infinite sorted array: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

# Approach
#  First I am finding the range where the target element is present.
#  Then I am using the binary search approach to find the range.

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        if reader.get(0) == target:
            return 0
        
        left = 0 
        right = 1 
        while reader.get(right) < target:
            left = right
            right = right * 2
        
        while left <= right:
            mid = left + (right - left) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                right = mid - 1
            
            else:
                left = mid + 1
        
        return -1