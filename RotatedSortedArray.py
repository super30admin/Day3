# Time Complexity : O(logn)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Trying to understand how the sorted sub arrays work


# Your code here along with comments explaining your approach in three sentences only
# -> Calculate mid in each iteration
# -> Check which subarray is sorted i.e, left or right or both
# -> Find the index of target by changing the low and high accordingly

from typing import List
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        #Initialising low and high index variables
        low = 0
        high = len(nums)-1
        while(low<=high):
            #Calculating mid
            mid = low + (high-low) // 2
            #If target is the mid then return the index of mid
            if(nums[mid]==target):
                return mid
            #To check if the left array is sorted or not
            elif(nums[low]<=nums[mid]):
                #To check if the target is present between low and mid, Accordingly update high or low value
                if(nums[low]<=target and target<=nums[mid]):
                    high = mid - 1
                else:
                    low = mid + 1
            #To check if the right array is sorted or not
            else:
                #To check if the target is present between mid and high, Accordingly update high or low value
                if(nums[mid]<=target and target <=nums[high]):
                    low = mid + 1
                else:
                    high = mid - 1
        return -1


