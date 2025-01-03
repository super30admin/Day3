"""
Time Complexity: 0(log n)
Space: 0(1)

Approach:
    1. One part of array will be sorted.
    2. Perform normal binary serach. If the tgt doesn't lie in the sorted area range, look into another side.
"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        low = 0
        high = len(nums)-1


        while low <= high:
            mid = (high-low)//2 + low

            if nums[mid] == target:
                return mid
            
            elif target < nums[mid]:

                # lhs is sorted and tgt isn't in sorted area  
                if nums[low] <= nums[mid] and target < nums[low]:
                    low = mid + 1
                else:
                    high = mid - 1

            elif target > nums[mid]:
                # rhs is sorted tgt isn't in sorted area
                if nums[mid] <= nums[high] and target > nums[high]:
                    high = mid - 1
                else:
                    low = mid + 1
                    
        # end of while loop

        return -1
