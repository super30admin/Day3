// Time Complexity : O(logT)+O(logT)=O(logT)
// Space Complexity : O(1) -- no extra space used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// First starting from the left and trying to find the index for which the value is greater than target value
// after we have found the high then doing binary search on this range

public class Problem3 {

    /**
     * Dummy code to avoid the errors.
     */
    class ArrayReader
    {
        int get(int input)
        {
            return 1;
        }
    }
     public static void main(String[] args) {

         Problem3 p = new Problem3();
     }

    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while (reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (reader.get(mid) == target) {
                return mid;
            }
            else if(reader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
