# // Time Complexity : O(log(mn))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        def helperCol(l,r):
            if l>r:
                return False
            else:
                mid=(l+r)//2
                if matrix[mid][0]<=target and matrix[mid][-1]>=target:
                    print("Inside the first if block")
                    return helperRow(0,len(matrix[0])-1,mid)
                elif matrix[mid][0]>target:
                    return helperCol(l,mid-1)
                else:
                    return helperCol(mid+1,r)
        def helperRow(l,r,c):
            if l>r:
                return False
            else:
                mid=(l+r)//2
                if matrix[c][mid]==target:
                    return True
                elif matrix[c][mid]>target:
                    return helperRow(l,mid-1,c)
                else:
                    return helperRow(mid+1,r,c)
        return helperCol(0,len(matrix)-1)

# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        left, right = 0, n - 1

        # Find the index of the pivot element (the smallest element)
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] > nums[-1]:
                left = mid + 1
            else:
                right = mid - 1

        # Binary search over an inclusive range [left_boundary ~ right_boundary]
        def binarySearch(left_boundary, right_boundary, target):
            left, right = left_boundary, right_boundary
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    return mid
                elif nums[mid] > target:
                    right = mid - 1
                else:
                    left = mid + 1
            return -1

        # Binary search over elements on the pivot element's left
        if (answer := binarySearch(0, left - 1, target)) != -1:
            return answer

        # Binary search over elements on the pivot element's right
        return binarySearch(left, n - 1, target)