#// Time Complexity : O(log(N)) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.
class Solution:
    def search(self, arr: List[int], target: int) -> int:
        ans=0
        l=0
        h=len(arr)-1

        while l<=h:
            mid=(l+h)//2
            if arr[mid]==target:
                return mid
            if arr[l]<=arr[mid]: # It is rotated
                if arr[l]>target or target>arr[mid]:
                    l=mid+1
                else:
                    h=mid-1 
            else:
                if arr[h]<target or target<arr[mid]:
                    h=mid-1
                else:
                    l=mid+1
        return -1
    
# Approach:
# The problem is asking us to find the index of a target element in a rotated sorted array. The
# array is sorted in ascending order and then rotated (rotated sorted array). We can solve this problem
# by using a modified binary search algorithm.
# The idea is to find the pivot element in the array. The pivot element is the element that is
# greater than all the elements on its left and smaller than all the elements on its right. We can
# find the pivot element by comparing the middle element with the first and last elements of the array.
# If the middle element is greater than the first element, then the pivot element is on the right side
# of the middle element. If the middle element is smaller than the first element, then the pivot element
# is on the left side of the middle element.
# Once we find the pivot element, we can use a binary search algorithm to find the target element.

        