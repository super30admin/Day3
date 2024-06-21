// Time Complexity : O(Logn) - Binary Search
// Space Complexity :O(1) - No extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//1. Compute Mid
//2. Find sorted side of divided Array
//3. check if element exist in that side if not search in another side
//Repeat

// Search in Sorted Rotated Array

class Solution {
    public int search(int[] nums, int target) {
        int low = 0; // Initialize low pointer to the start of the array
        int high = nums.length - 1; // Initialize high pointer to the end of the array
        
        while (low <= high) { // Continue the loop while low pointer is less than or equal to high pointer
            int mid = low + (high - low) / 2; // Calculate mid index to avoid overflow
            
            // Check if the mid element is the target
            if (nums[mid] == target) return mid;
            
            // Determine which part of the array is sorted
            if (nums[mid] >= nums[low]) { // Left part is sorted
                // Check if the target is within the sorted left part
                if (nums[mid] >= target && target >= nums[low]) {
                    high = mid - 1; // Narrow down to the left part
                } else {
                    low = mid + 1; // Narrow down to the right part
                }
            } else { // Right part is sorted
                // Check if the target is within the sorted right part
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1; // Narrow down to the right part
                } else {
                    high = mid - 1; // Narrow down to the left part
                }
            }
        }
        
        return -1; // Return -1 if the target is not found
    }
}


// Time Complexity : O(Log(m*n)) - Binary Search
// Space Complexity :O(1) - No extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Search in Sorted 2d Matrix

//1. Illustrate 2d matrix as flattened 1d array.
//2. Calculate mid -> find index of that mid in 2d array
//3. Repeat steps as Normal binary search operations.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length; // Number of rows in the matrix
        int col = matrix[0].length; // Number of columns in the matrix
        int low = 0; // Initialize low pointer to the start of the matrix (as a flattened array)
        int high = (row * col) - 1; // Initialize high pointer to the end of the matrix (as a flattened array)
        
        while (low <= high) { // Continue the loop while low pointer is less than or equal to high pointer
            int mid = low + (high - low) / 2; // Calculate mid index to avoid overflow
            
            // Convert mid index to 2D matrix indices
            int midRowIdx = mid / col; // Calculate row index
            int midColIdx = mid % col; // Calculate column index
            
            // Check if the element at the mid position is the target
            if (matrix[midRowIdx][midColIdx] == target) return true;
            
            // If the element at the mid position is greater than the target
            else if (matrix[midRowIdx][midColIdx] > target) {
                high = mid - 1; // Narrow down to the left part
            }
            
            // If the element at the mid position is less than the target
            else {
                low = mid + 1; // Narrow down to the right part
            }
        }
        
        return false; // Return false if the target is not found
    }
}


// Time Complexity : (O(Log(T) where T is number of elements that we find out in that range - Binary Search
// Space Complexity :O(1) - No extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Search in array of unkown size
//1. In the first pass we find the boundries in which the element might lie using a slow pointer faster pointer approach
//2. Now we have a possible boundry upon which we do binary search

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0; // Initialize low pointer
        int high = 1; // Initialize high pointer
        
        // Expand the range [low, high] until the target is within the range
        while (reader.get(high) < target) {
            low = high; // Move low to high
            high = high * 2; // Double the high index
        }
        
        // Perform binary search within the determined range
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate mid index to avoid overflow
            
            // Check if the element at the mid position is the target
            if (reader.get(mid) == target) return mid;
            
            // If the element at the mid position is greater than the target
            else if (reader.get(mid) > target) {
                high = mid - 1; // Narrow down to the left part
            }
            
            // If the element at the mid position is less than the target
            else {
                low = mid + 1; // Narrow down to the right part
            }
        }
        
        return -1; // Return -1 if the target is not found
    }
}
