// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We dont have the length of the array, finding the high is the main thing in this problem
// initially setting low to 0 and high to 1, until high <= target,  updating high to high *2
class SortedRotatedArray {

    public int search(ArrayReader reader, int target) {

         int low = 0;
         int high = 1;

         while(reader.get(high) <= target) {
             low = high;
             high = high * 2;
         }

         while(low <= high) {
            int mid = low + (high-low)/2;
            // check if mid is the target
            if(reader.get(mid) == target) {
                return mid;
            }

            if(reader.get(mid) > target) {
                high = mid -1;
            }else {
                low = mid +1;
            }

         }
         return -1;
        }

}