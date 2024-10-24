//702. Search in a Sorted Array of Unknown Length - https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
//Time Complexity: O(log(n))
//Space Complexity: O(1)

class Solution {

    private int binarySearch(ArrayReader reader, int target, int low, int high) {
        while(low <= high){
            int mid = low + (high-low)/2; //to avoid overflow
            if(reader.get(mid) == target){
                return mid;
            } else if (reader.get(mid) < target){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }

    public int search(ArrayReader reader, int target) {
        int low = 0; int high = 1;
        while(reader.get(high) < target){
            low = high;
            high = 2*high; //increase the search range by twice
            //we can use a high multiplication factor but search range will also increase
        }
        return binarySearch(reader, target, low, high);
    }
}