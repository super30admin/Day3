public class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while (reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = reader.get(mid);
            
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
    }
}
