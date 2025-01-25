# Time Complexity : O(log (m * n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# My approach: Imagining two regions, left and half where left half is all nums greater than last indexed num
# and right half is all nums less than or equal to last num. Then, find where the target lies.
# do binary search and make the decisions of whether to exclude left or right half, by comparing mid value with last num.

if target > nums[-1]:
    target_region = "left"
else:
    if target == nums[-1]:
        return len(nums) - 1
    target_region = "right"

start, end = 0, len(nums) - 1

while start <= end:
    mid = start + ((end - start) // 2)
    if nums[mid] == target:
        return mid
    
    if nums[mid] <= nums[-1]:
        # i am in right half
        if target_region == "left" or target < nums[mid]:
            end = mid - 1
        else:
            start = mid + 1
    else:
        # i am in left half
        if target_region == "right" or target > nums[mid]:
            start = mid + 1
        else:
            end = mid - 1

return -1