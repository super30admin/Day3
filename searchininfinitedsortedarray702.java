// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Expand length until the target is in range and the binary search
 */

 class Solution {
    public int search(ArrayReader reader, int target) {
        int l  = 0;
        int h = 1;
        while(reader.get(h)<= 10000){
            if(target >= reader.get(l) && target <= reader.get(h)){
                break;
            }
            l = h;
            h = h*2;
        }

        while(l<=h){
            int mid = l + (h-l)/2;
            if(reader.get(mid) == target ) return mid;
            if(reader.get(mid)>target){
                h = mid - 1;
            }
            else{
                l = mid +1;
            }
        }
        return -1;
    }
}