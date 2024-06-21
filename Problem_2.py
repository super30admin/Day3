# // Time Complexity : O(log(row))

# // Space Complexity : O(1)

# // Did this code successfully run on Leetcode : Yes

# // Any problem you faced while coding this : There were a lot of syntax errors since, 
# // I am using c++ after a very long time
# // Since I am building on top of the class lecture the logic worked out fine


#  // Your code here along with comments explaining your approach in three sentences only
#  // I am using finding the sorted array logic where I try to find the sorted array and if the target is 
#  // within the range then I apply binary sort

from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        h = len(nums) - 1
        while l <= h:
            mid = l + (h - l)//2
            if nums[mid] == target: return mid
            else:
                if nums[mid] >= nums[l]:
                    if nums[l] <= target < nums[mid]:
                        h = mid - 1
                    else: 
                        l = mid + 1
                else:
                    if nums[mid] < target <= nums[h]:
                        l = mid + 1
                    else:
                        h = mid - 1

        return -1

if __name__ == "__main__":
    row = 3
    matrix = [4, 5, 6, 0, 1, 2, 3]
    
    sol = Solution()
    res = sol.search(matrix, 6)
    print(f"True case result: {res}")

    res = sol.search(matrix, 400)
    print(f"False case result: {res}")
