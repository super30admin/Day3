# Time Complexity : O(logN)
#Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Approach: Since we dnt know the array size, we can't calculate mid. But we can start doubling the array size until we reach a point
# where target is greater the array value. 
# Once we have the upper bound index, we can take one step back and define that as left part of the array. After that we use the same
# binary search approach to find the target

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        right_idx = 1
        while (target > reader.get(right_idx)):
            right_idx *= 2
        left_idx = int(right_idx/2)
        while (left_idx <= right_idx):
            mid = left_idx + int((right_idx - left_idx)/2)
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                right_idx = mid-1
            else:
                left_idx = mid + 1
        return -1