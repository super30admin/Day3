# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No
class Solution:
    def search(self, reader, target):
        low = 0
        high = 1
        while target > reader[high]:
            low = high
            high = 2 * high
        
        while low<=high:
            mid = low +(high -low) //2
            if reader.get(mid) == target:
                return mid
            elif target > reader.get(mid):
                low = mid+1
            else:
                high = mid-1
        return -1

        