## Problem3
# Search in Infinite sorted array: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

#Approach
# Set the low and high pointer to 0th and 1st index of array. Run a while loop till the high pointer is less than target. Once its greater, we would know that we have crossed the target.
# Each time, set low = high and high pointer by 2. We increment high by 2 to optimize the search space in the array.
# once the high and low pointer are set, run normal binary search of it by finding the mid each time and check if the mid matches the target.
# If yes, return mid else decrement high if target is less than mid and increment low if target is greater than mid

# Time Complexity : O(log n) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low, high = 0,1
        while(reader.get(high) < target):
            low = high
            high = high * 2
        
        while (low <= high):
            mid = low + (high-low)//2
            if reader.get(mid) == target:
                return mid
            if reader.get(mid) > target:
                high = mid -1
            else:
                low = mid + 1
        return -1