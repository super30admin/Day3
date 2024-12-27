/**
 * Time Complexity : O(logN) + O(logN) = O(2logN) ~ O(logN)
 * Space Complexity : O (1)
 * Did this code successfully run on Leetcode : No access to premium, cannot test
 * Any problem you faced while coding this : no
 */
public class SearchInUnknownSizeArray {
    public static class ArrayReader {
        private final int[] arr;

        public ArrayReader(int[] arr) {
            this.arr = arr;
        }

        public int get(int index) {
            return (index >= arr.length) ? Integer.MAX_VALUE : arr[index];
        }
    }

    public int search(ArrayReader secret, int target) {
        // handle base conditions
        if (secret == null || secret.get(0) == Integer.MAX_VALUE)
            return -1;

        if (secret.get(0) == target)
            return 0;

        int start = 0;
        int end = 1;
        int value = secret.get(start);

        // value of end is exponentially increased 2^k, so it takes logN steps to
        while(value < target || value != Integer.MAX_VALUE - 1) {
            start = end;
            end *= 2;
            value = secret.get(end);
        }

        // once start and end for range is derived, binary search for target in the secret array takes logN
        return binarySearch(secret, target, start, end);
    }

    /**
     * Helper method to perform binary search on secret array
     *
     * @param secret array with unknown size
     * @param target element to search
     * @param start start index
     * @param end end index
     * @return index if target is found, -1 otherwise
     */
    private static int binarySearch(ArrayReader secret, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start)/2;
            int value = secret.get(mid);
            if (value== target)
                return mid;
            if (value < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {-1,0,3,5,9,12};
        ArrayReader reader = new ArrayReader(array);
        SearchInUnknownSizeArray obj = new SearchInUnknownSizeArray();
        int result = obj.search(reader, 9);
        System.out.println("First search result: " + result);
        array = new int[]{-1,0,3,5,9,12};
        ArrayReader reader2 = new ArrayReader(array);
        result = obj.search(reader2, 2);
        System.out.println("Second search result: " + result);
        int[] array3 = new int[1000000000];
        for (int i = 0; i < 1000000000; i++)
            array3[i] = i*2;
        ArrayReader reader3 = new ArrayReader(array3);
        result = obj.search(reader3, 1000000000 - 2);
        System.out.println("Third Search result: " + result);
    }
}
