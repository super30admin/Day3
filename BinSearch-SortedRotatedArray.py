#Time complexity: O(logn)
#Space complexity: O(1)
#Leetcode: Yes

class Solution:
    def search(self, nums: List[int], target: int) -> int:

        def binarySearch(arr,target,low,high):
                while low<=high:
                    mid=(low+high)//2
                    if arr[mid]==target:
                        return mid
                    elif target>arr[mid]:
                        low = mid+1
                    elif target<arr[mid]:
                        high = mid-1
                if low>high:
                    return -1

        if len(nums)==0:
            return -1
        else:
            low = 0
            high = len(nums)-1

            def findPivot(nums,low,high):
                while low<high:
                    mid=(low+high)//2
                    if nums[mid]>nums[high]:
                        low = mid+1
                    else:
                        high = mid
                return low

            pivotIndex = findPivot(nums,low,high)

        if target == nums[pivotIndex]:
            return pivotIndex
        elif target <= nums[high]:
            result = binarySearch(nums, target, pivotIndex, len(nums)-1)
        else:
            result = binarySearch(nums, target, 0, pivotIndex-1)
            
        return result
