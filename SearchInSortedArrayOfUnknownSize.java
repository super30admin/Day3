
/**
 * Approach: Binary Search
 *
 * Working: Since the range of the array is unknown, and the default value of an integer array will be
 *          zero, so considering the last index of the array is the max length array 10000 in constraints
 *          and performing binary search.
 *
 * Time Complexity: O(long n)
 * Space Complexity: O(1)
 *
 *
 */

class SearchInSortedArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {

        int low = 0;
        int high = 10000;

        while(low<=high) {

            int mid = low+(high-low)/2;
            int midVal = reader.get(mid);

            if(midVal == target) {
                return mid;
            }
            else if(target < midVal) {
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return -1;

    }
}
