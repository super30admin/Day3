# Time Complexity : O(logn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : I don't have premium so NO
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach in three sentences only

# since the size of the array is not known and we choose low = 0 and high = 1
# and with the reader.get(i) we can get the value in a particular index so we can compare it with target 
# to get low and high range. if the high goes beyond what exists in the array 
# then reader.get(high) of that will be 2^31 - 1 and we'll come out of while loop with the definite l and h
# once the low and high is fixed then we perform BS on it.


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while (reader.get(high) < target): # we're are getting the definite low and high here
            low = high
            high = 2* high
        
        # BS
        while(low <= high):
            mid = low + (high - low)//2
            if (reader.get(mid) == target):
                return mid
            elif reader.get(mid)< target:
                low = mid + 1
            else:
                high = mid - 1
        
        return -1    