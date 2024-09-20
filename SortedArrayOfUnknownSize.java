// Time Complexity : O(logn)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Trying to understand how the range is found


// Your code here along with comments explaining your approach in three sentences only
// -> Initilise low and high 
// -> Finding the range between low and high where the target is present
// -> Executing binary search on that range

class Solution {
    public int search(ArrayReader reader, int target) {
        //Initilise low and high as 0 and 1 initially
        int low = 0;
        int high = 1;
        //When target is greater than high we update low and high
        while(reader.get(high)<target){ 
            low = high;
            high = 2 * high;
        }
        //Once the range is confirmed, Execute regular binary search
        while(low<=high){
            int mid = low+(high-low) / 2;
            if (reader.get(mid) == target){
                return mid;
            }
            else if (reader.get(low) <= target && target <= reader.get(mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
    return -1;
    }
}