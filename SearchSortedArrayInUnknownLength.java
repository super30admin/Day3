// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three sentences only:
/*Start with an index (say 0), and double it until you find an index that exceeds the size of
 the array (or a boundary where you can stop).Perform binary search on a range*/

public class SearchSortedArrayInUnknownLength {

    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1; // Return -1 if the array is empty or null
        }

        // Step 1: Find the range using exponential search
        int low = 0;
        int high = 1;
        
        // Expand the range until the target is within the bounds
        while (high < arr.length && arr[high] < target) {
            low = high;
            high = Math.min(2 * high, arr.length - 1); // Avoid index out of bounds
        }

        return binarySearch(arr, target, low, high);
    }

    public static int binarySearch(int[] arr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == target) {
                return mid; 
            }
            if (arr[mid] < target) {
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 12, 15, 18, 25, 30, 35, 40};
        int target = 25;
        
        int result = search(arr, target);
        
        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
    
}
