class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0 
        high = len(nums)-1

        while low<=high:
            mid = (low + high)//2
            if nums[mid] == target:
                return mid 
            if nums[low] <= nums[mid]: #first half of list is sorted
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else: 
                    low = mid + 1
            else: #second half of list is sorted #[9,10,11,1,2,3,4,5,6,7,8]
                if nums[mid] < target <= nums[high]: #not nums[mid] <= target <= nums[high, because if mid == target, it will get sorted in line 8 itself
                    low = mid +1
                else: 
                    high = mid - 1 

        return -1


#TC: log(N)
#SC: O(1)