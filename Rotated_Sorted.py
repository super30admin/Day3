#TIme complexity O(logn)..since finding pivot takes logn and searching both divided arrays take logn. Constant*logn is O(logn)
#Space is O(1)
#Yes this code worked in Leetcode



class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        first,last = 0,n-1
        while first<=last:
            mid = first + (last-first)//2
            if nums[mid] > nums[-1]:
                first = mid + 1
            else:
                last = mid - 1
        def binarySearch(left,right,target):
            while left <= right:
                mid = (left+right)//2
                if nums[mid] == target:
                    return mid
                elif nums[mid] > target:
                    right = mid - 1
                else:
                    left = mid + 1
            return -1
        if (answer := binarySearch(0,first-1,target)) != -1:
            return answer
        return binarySearch(first,n-1,target)