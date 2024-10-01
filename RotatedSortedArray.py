class Solution:
    def search(self, nums, target) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                print(mid)
                return mid 
            
            #left Sorted
            elif nums[low] <= nums[mid]:
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            #right sorted
            else:
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        print(-1)   
        return -1
    
s = Solution()
s.search([-2,-1,0,1,3,7,9], 9)

