// Time Complexity :O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
import java.util.*;
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 class SearchUnknownSize {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right=1;
        while(reader.get(right)!=Integer.MAX_VALUE){
            right = right*2;
        }
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target==reader.get(mid))
                return mid;
            if(target>reader.get(mid)){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return -1;
    }
}