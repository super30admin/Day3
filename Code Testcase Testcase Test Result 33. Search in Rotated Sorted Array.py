class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        left = 0
        right = len(nums) -1
        
        while(left <= right):
            midpoint = (left + right) // 2

            midVal = nums[midpoint]

            if(midVal == target):
                return midpoint


            # figure out if the left half of our array till midpoint is sorted
            if(midVal >= nums[left]):
                # check if target lies within this range
                if nums[left] <= target <= midVal:
                    right = midpoint -1
                else:
                    left = midpoint + 1
            
            # if target is in the right half of our sorted array
            else:
                if(midVal <= target <= nums[right]):
                    left = midpoint + 1
                else:
                    right = midpoint - 1

        return -1
            
# Using binary search, first find which half of the array our target lies in
# there's going to be moments during our search when the midpoint will not satisfy the condition of binary search ie. it will be greater than the right point
# assign the midpoint to either right or left depending on our pivot point

# Time complexity - O(log(n))
# Space Complexity - O(1)
