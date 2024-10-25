// Time Complexity : O(log n) where n is the position of target or end of array. The subsequent binary search within these bounds takt O(log n
// so overall time complexity takes  O(log n) + O(log n) = O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No since it eas a leetcode Premuim problem
// Any problem you faced while coding this : No


public class SearchUnknownSizeArray {
    // method to access an array of unknown size
    public int getElement(int index) {
        // This method will return element at index if it exists or return max value
        // or throw an exception if index is out of bounds
        int[] arr = {1, 3, 5, 7, 9, 11, 15, 18, 21, 25, 30};// Example Array
        if (index < 0 || index >= arr.length) return Integer.MAX_VALUE;
        return arr[index];
    }

    public int search(int target){
        // find the search range
        int  low = 0;
        int high = 1;

        //Expand the range until we find a high that is out of bounds or larger than the target
        while(getElement(high) < target && getElement(high) != Integer.MAX_VALUE){
            low = high ;
            high = high * 2;
        }
        // perform binary search within the range

        while (low <= high){
            int mid = low + (high - low) /2;
            int midValue = getElement(mid);
            // check if mid value is the target
            if (midValue == target) {
                return mid;
            } else if(midValue == Integer.MAX_VALUE || midValue > target){
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1; // if target is not found return -1
    }



    public static void main(String[] args) {
        SearchUnknownSizeArray searcher = new SearchUnknownSizeArray();
        int target = 18;
        int result = searcher.search(target);
        System.out.println("Target found at index: " + result);
    }
}
