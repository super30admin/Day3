# Approach : Atleast one half is always sorted
# Time Complexity : O(logn)


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        #first check if list is empty or not, if empty then return -1
        if nums is None or len(nums)==0:
            return -1
        #take two pointer one from beginning and another from last
        low=0
        high=len(nums)-1
        # keep iterating until low <=high ( can also do while(low<high))
        while(low<=high):
            #Instead to mid=low+high/2 we did mid=low+(high-low)//2 because it avoids integer overflow error
            mid=low+(high-low)//2
            # Now first check if the given target is at middle element if yes then work done else look for the half i.e sorted
            if (nums[mid]==target):
                return mid
            # [4,5,6,7,0,1,2] here we know left half is sorted (condition to check left half is sorted is left should be less than mid)
            if nums[low]<=nums[mid]:
                #if left half is sorted then check if target lies in the half condition for that is target should be greater than and equal to low 
                # and also target should be less than middle. If this condition satifies then shift high to mid -1 else (means target does not lie in left half then shift low to mid +1 (i.e right half will contain target))
                if nums[low]<=target and nums[mid]>target:
                    high=mid-1
                else:
                    low=mid+1
            #else for right half (if above left half condition not met then right half is sorted)
            else:
                #Condition to check if target lies in right half (target should be greater than middle and less than= high)
                if nums[mid]<target and nums[high]>=target:
                    #if this condition satifies then shift low to mid +1 else shift high 
                    low=mid+1
                else:
                    high=mid-1
        #if unable to find element return -1
        return -1
