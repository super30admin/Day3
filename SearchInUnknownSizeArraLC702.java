// Time Complexity :O(log n + log m), n -Time taken to find array size, m - Time taken to do Binary search
// Space Complexity :O(log n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */
public class SearchInUnknownSizeArraLC702 {

    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while (reader.get[high] <= target) {
            low = high;
            high = high * 2;// everytime multiply high value by 2 so that we can find target location by min number of iterations.
            //eg: target is 15
            // low =0 high =1
            // low = 1 high =2
            // low =2 high =4
            // low = 4 high = 8...iterate until we find target.
            //low =8 and high = 16. Here we found reader.get[high] =15. so pass Index low =8 and high =16 for binary search
        }

        while (low <= high) {//Normal Binary search
            int mid = low + (high - low) / 2;
            if (reader.get[mid] == target)
                return mid;
            else if (reader.get[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
