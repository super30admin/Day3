// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : determining the search criteria


// Your code here along with comments explaining your approach in three sentences only
/*
 * First figure out if mid is in right sorted or left sorted part, then binary search.
 */
class Solution {
    public int search(int[] arr, int target) {
        int l = 0;
        int h = arr.length-1;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(target == arr[mid]) return mid;
            if(arr[l]<=arr[mid]){
                if(arr[l] <= target && target <= arr[mid]){
                    h = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            else{
                if(arr[mid]<=target && target <= arr[h]){
                    l = mid+1;
                }
                else{
                    h = mid-1;
                }
            }
        }
        return -1;
    }
}