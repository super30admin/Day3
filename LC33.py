class Solution(object):
    def search(self, nums, k):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low = 0
        high = len(nums)-1
        while low<=high:
            mid = (low+high)//2
            if nums[mid] == k:
                return mid
            if nums[mid]<=nums[high]: #lright part is sorted
                if nums[mid] <= k and nums[high] >= k:
                    low = mid+1
                else:
                    high = mid-1
            else:
                if nums[low]<=k and nums[mid]>=k:
                    high=mid-1
                else:
                    low=mid+1
        return -1
