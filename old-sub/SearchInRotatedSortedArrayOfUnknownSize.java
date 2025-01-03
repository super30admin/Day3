class Solution {
    /*
    Time Complexity : 0(log n)
    Space Complexity: 0(1)
    Approach: Perform binary search approach in reverse way i.e. find the potential mid
    by adjusting low and high values conditionally. Check the code approach for more.
     */
    public int search(ArrayReader reader, int target) {
        // set initially low and high value
        int low = 0;
        int high = 0;
        int mid = 0;

        while (low <= high){
            mid = (high-low)/2 + low;

            if (reader.get(mid) == target){
                // found index
                return mid;
            }
            else if(reader.get(mid) < target){
                // check on rhs
                low = mid + 1;
                high = 2 * low;
            }
            else if (reader.get(mid) > target) {
                // check on lhs
                high = mid - 1;
            }
        }
        return -1;
    }
}