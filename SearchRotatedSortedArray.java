/**
 * Approach: Binary search
 *
 * Working: Any one part of the array will be sorted and contains the target within range, move to that part
 *          or the target might be in the unsorted part do a binary search with the above conditions till the
 *          lower bound does not cross the higher bound and return the search element index else -1
 *
 * Time Complexity: O(long n)
 * Space Complexity: O(1)
 */
class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {

        if(nums == null || nums.length == 0) {
            return -1;
        }

        int low=0;
        int high = nums.length-1;

        while(low<=high){

            int mid = low+(high-low)/2; //subracting low from hight to prevent integer overflow
            int midVal = nums[mid];
            if(midVal == target)
            {
                return mid;
            }
            if(nums[low] <= midVal) { // to check if the left part is sorted
                if(target >= nums[low] && target < midVal ) // the target lie b/w low and midVal
                {
                    high = mid-1;
                }
                else {  //if value not present in the sorted left part move to right part to check
                    low = mid+1;
                }
            }
            else {   //right side sorted
                if(target > midVal && target<= nums[high]) { //  target lies b/w midVal and high
                    low = mid+1;                             // move to the right part search space
                }
                else{
                    high = mid-1; // if not the target migh lie in the left part, move to left part
                }
            }
        }

        return -1;
    }
}
