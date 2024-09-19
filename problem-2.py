from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        return self.binarySearch(nums, target, 0, len(nums) - 1)

    def binarySearch(self, nums, target, low, high):
        if (high - low) > 0:
            mid = int((low + high) / 2)
            if nums[mid] == target:
                return mid
            else:
                if nums[mid]>=nums[low]:
                    if target>=nums[low] and target<=nums[mid]:
                        return self.binarySearch(nums, target, low, mid-1)
                    else:
                        return self.binarySearch(nums, target, mid+1,high)
                else:

                    if target>nums[mid] and target<=nums[high]:
                        return self.binarySearch(nums, target, mid + 1, high)
                    else:
                        return self.binarySearch(nums, target, low, mid-1)



        else:
            if nums[high] == target:
                return high
            else:
                return -1

s= Solution()
#print(s.search([4,5,6,7,8,1,2,3],8))
print(s.search([3,1],1))
print(s.search([5,1,3],5))
print(s.search([3,5,1],5))
print(s.search([1,3,5],5))
print("-----------------")
print(s.search([5,1,3],3))
print(s.search([3,5,1],3))
print(s.search([1,3,5],3))
print("-----------------")
print(s.search([4,5,6,7,0,1,2],0))
print(s.search([6,7,0,1,2,3,4],0))
print(s.search([6,7,0,1,2,3,4],5))
print(s.search([6,7,0,1,2,3,4],2))
#[3,4,5,6,7,1,2]

