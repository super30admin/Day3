/*
    1. Time Complexity : O(logm + logn)
        O(logm) to find the range of the array
        O(logn) perform binary search on elements within range
    2. Space Complexity : O(1)   
    3. Did this code successfully run on Leetcode : Yes
    4. Any problem you faced while coding this : -
 */

/*
 * Perform modified binary search,
 * compare nums[high] and target to check whether the target is within the existing range.
 * If yes, then perform binary search within this range
 * If no, then double the range by moving high = 2 * high and low = high + 1
 * Repeat about steps until the target <= nums[high]
 */

import java.util.Random;

class ArrayReader {
    int[] arr;
    int size;
    Random r;
    ArrayReader() {
        r = new Random();
        size = r.nextInt(10001);
        arr = new int[size];
        generateValues();
    }

    private void generateValues() {
        int minValue = r.nextInt(10001) - r.nextInt(10001); // generate random starting value and add next consecutive elements to the array
        for (int i = 0; i < size; ++i){
            arr[i] = minValue++;
        }
    }

    public int get(int idx) {
        return (idx >= size) ?  Integer.MAX_VALUE : arr[idx];
    }

}
class SearchSortedArrayUnknownSize {
    public static int search(ArrayReader reader, int target) {
        int l = 0, mid = 1, h = 2, val;
        while (l <= h) {
            mid = l + (h - l) / 2;
            val = reader.get(mid);
            if (val == target) return mid;
            else if (reader.get(h) < target) {
                l = h + 1;
                h*=2;
            }
            else if (val > target)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
    public static void  main(String[] args) {
        ArrayReader reader = new ArrayReader();
        int target = 100;
        System.out.println("Found target " + target+ " at index " + search(reader, target));
    }
}
