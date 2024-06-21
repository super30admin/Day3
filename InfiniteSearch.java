// Time Complexity : O(1) (not considering the helper function get())
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : Took some time to design the helper class ArrayReader to mimic
// the background logic from LeetCode.

// Your code here along with comments explaining your approach in three sentences only
/*
Implemented binary search by starting with first two indices as low and high and checking the range of target value
and then changing low = high and high as double the current high until target comes into range.
 */


public class InfiniteSearch {

    // Implemented ArrayReader interface as an inner class to check testcases locally
    public static class ArrayReader {
        static int[] arr = {};
        public ArrayReader(int[] arr) {
           ArrayReader.arr = arr;
        }
        public int get(int k) {
            if (k < 0 || k >= arr.length) {
                return Integer.MAX_VALUE;
            }
            return arr[k];
        }
    }

    private static int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(reader.get(high) < target) {
            low = high;
            high *= 2;
        }

        while(low <= high) {
            int mid = low + ((high-low)/2);
            if(target == reader.get(mid)) return mid;
            else if(target > reader.get(mid)) low = mid + 1;
            else high = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        ArrayReader arrayReader = new ArrayReader(arr);
        int search1 = search(arrayReader, 5);
        System.out.println("The location is " + search1);
        int search2 = search(arrayReader, 20);
        System.out.println("The location is " + search2);
    }
}
