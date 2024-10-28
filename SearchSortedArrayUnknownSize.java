/*
Time Complexity: O(log m), where m is the index at which the target would be or the nearest higher value.
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes

Here we are increasing the search space by twice which is also Binary search. We can also use any other number to multiply, but the only thing is
we will be doing binary search on more elements
 */

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class SearchSortedArrayUnknownSize {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;

        /*We want find the range so we make the high pointer jump by 2, we can also make high jump by a  high number, say high = max value 2^31, if we do this, the number of iterations
        to get the range (log m) will be less, and if we have to do another binary search to identify the target, (log k), so even though we get the range quicker, during binary search
        we wlll be have more number of elements, as we are going in more depth, that will make the time complexity as O(log infinity) which we don't want.
        */

        //While loop to identify the range to perform search
        while(reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        //Now we have the range so perform binary search
        while(low<=high)
        {
            int mid = (low+(high-low)/2);

            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(mid) > target)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }
}