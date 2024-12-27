# Time Complexity = O(logn)
# Space Complexity = O(1)
# Leetcode - Yes
# approach -  declared pointers , calculated mid and then checked target in left sorted part and right sorted part
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l , r = 0 , len(nums)-1

        while l <= r:
            m = (l+r)//2
            if nums[m] ==target:
                return m

            #left sorted
            if nums[l]<nums[m]:
                if nums[l] <= target < nums[m]:
                    r= m- 1
                else:
                     l=m+1
            else:
                if nums[m] < target <=nums[r]:
                    l=m+1
                else:
                    r=m-1
        return -1
