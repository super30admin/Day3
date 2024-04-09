/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 
 /**
 * if target > arr.get(high) increase range of low=high and high=high*2
 * perform Binary search for the range to find target
 
 Time Complexity - O(logN), Space Complexity O(1);
  */

  

  class Solution {
    public int search(ArrayReader reader, int target) {

        int low = 0;
        int high = 1;

        while(low<=high){
            if(target>reader.get(high)){
                low = high;
                high = high * 2;
            }
            int mid = low + (high -low)/2;

            if(reader.get(mid) == target) return mid;
            if(reader.get(mid) > target) high = mid - 1;
            else low = mid +1;
        }
        return -1;
        
    }
}