# Time Complexity : O(logn) - binary search
# Space Complexity : O(1) - constant
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach in three sentences only

#in the rotated sorted array get the middle and then check it with the low index
# see if the value in low index is < mid, if yes the left array is sorted and then perform bs on it to find target
# otherwise go the right part of the array and continue doing BS on it until we find the target
# if target is not found then return -1


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        if n == 0: # if list is empty
            return -1 #return -1

        l = 0
        h = n -1
        while l<=h:
            mid = l + (h-l)//2
            if nums[mid] == target: # if the target is at mid return mid
                return mid
            
            # if left sorted
            elif nums[l] <= nums[mid]: #if the left side of the array is sorted
                if nums[l] <= target and nums[mid] > target: # if the target is on the left itself set h and l accordingly.
                    h = mid - 1 
                else:
                    l = mid + 1
            
            else: # if right side array is sorted and
                if nums[mid] < target and nums[h] >= target: # check if target is on that side and set h and l accordingly
                    l = mid + 1
                else: 
                    h = mid - 1
        

        return -1 # return -1 if target not found


        
        