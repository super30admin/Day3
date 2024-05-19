// Time Complexity : O(logn)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

// 1. The code searches for a target value in a sorted array using an `ArrayReader` interface. It starts by expanding the search range exponentially until it finds a range where the target might be located.
// 2. Once the range is identified, it performs a binary search within that range. It adjusts the `low` and `high` pointers based on comparisons with the middle element.
// 3. If the target is found, the function returns its index; if not, it returns `-1`.

class Solution {
      public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(reader.get(high)<=target){
            low = high;
            high = 2*high; 
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(reader.get(mid) == target){
                return mid;
            }else if(reader.get(mid) < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
      return -1;
      }
}