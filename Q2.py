######### Search in a Roatated Sorted Array ###########

# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# compute the mid if the mid is greater than the last element we know the pivot lies to the right and left is sorted
# and if the mid is less than the last element the pivot lies to the left of the mid and right is sorted
# we can then check if the element is in the sorted part or no and adjust left and right and keep performing binary search.

def search(nums, target):
    l = 0
    r = len(nums)-1
    while l <= r:
        mid = (l+r)//2

        if nums[mid]==target:
            return mid
            
        elif nums[mid] >= nums[r]:
            # left half is sorted
            if nums[l] <= target < nums[mid]:
                r = mid - 1
            else:
                l = mid + 1
            
        else:
            # right half is sorted 
            if nums[mid] < target <= nums[r]:
                l = mid + 1
            else:
                r = mid -1
    return -1

print(search([3,4,5,7,0,1,2],5))
