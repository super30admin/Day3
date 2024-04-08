/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *      public int get(int index){}
 * }
*/

class Solution {
    public int search(ArrayReader reader, int target) {
        int slow = 0; 
        int fast = 1;

        while (reader.get(fast) < target) {
            slow = fast;
            fast = fast * 2;
        }

        while (slow <= fast) {
            int mid = slow + (fast - slow) / 2;

            if (reader.get(mid) == target)
                return mid;
            else if (reader.get(mid) < target)
                slow = mid - 1;
            else 
                fast = mid + 1;
        }

        return -1;
    }
};