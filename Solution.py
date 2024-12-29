######### Search in a 2-D Matrix ###########

# Time Complexity : O(log(m*n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Initially made mistake in the index computation.

# Similar to performing normal binary search except compute indexes based on the grid to get element at mid.

def matrix_search(matrix):
    if not matrix or len(matrix)==0:
        return False
            
    n = len(matrix)
    m = len(matrix[0])
    l = 0
    r = (m*n) - 1
        
    while l <= r:
        mid = (l+r)//2
        r = mid / m
        c = mid % m
        if matrix[r][c] == target:
            return True
        elif matrix[r][c] > target:
            r = mid - 1
        else:
            l = mid + 1
    return False


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
