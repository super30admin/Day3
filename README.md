# Binary-Search-1


## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length == 0) return false;
        if(matrix[0][0] == target) return true;

        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m*n - 1;

        while(low <= high) {
            int mid = low + (high-low)/2;
            int r = mid / n;
            int c = mid % n;
            if(matrix[r][c] == target) {
                return true;
            } else if(matrix[r][c] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}

## Problem2 
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

class Solution {
    public int search(int[] nums, int target) {
        
        if(nums.length == 0) return -1;

        int n = nums.length;
        int low = 0, high = n - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[low] <= nums[mid]) {
                // left sorted
                if(nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // right sorted
                if(nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}

## Problem3
Search in Infinite sorted array: 

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

public class Solution {

    public int search(ArrayReader reader, int target) {

        int low = 0, high = 1;

        while(reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(reader.get(mid) == target) {
                return mid;
            } else if(reader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
