# Time Complexity :  O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low =0
        high= len(nums)-1
        while ( low <=high):
            mid= int(low + (high-low)/2)
            if(target == nums[mid]):
                return mid
            if (nums[low] <= nums[mid]):
                if ( target < nums[mid]) and (target >= nums[low]):
                    high=mid-1
                else:
                    low = mid + 1
            else:
                if( target <= nums[high]) and (target > nums[mid]):
                    low= mid +1
                else:
                    high = mid -1
            #     continue
        return -1
