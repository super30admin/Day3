
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */




// Time Complexity : O(logn) because everytime we are incrementing the search space by 2x and then when the range is found then we can perform the binary search O(log n).
// Space Complexity : O(1) there is no extra space used.
// Did this code successfully run on Leetcode : yes, it did.
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
class ArrayReader
{
    private int[] arr;
    
    public ArrayReader(int[] arr)
    {
        this.arr = arr;
    }
    public int get(int i)
    {
        return arr[i];
    }
}
class Reader {
    public int search(ArrayReader reader, int target) {
         // since we don't know the high, we start with 0 and 1,
        int low = 0;
         int high = 1;
         // then check if the target is within the range and increase the range by 2X till we find the correct range.
         while(reader.get(high) < target)
        {
            low = high;
            high = 2 * high;
        }
        //when find the correct range in which the target might present, then apply binary search for that range.
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(mid)>target)
                high = mid-1;
            else
                low = mid+1;
        }
        //is not found then return -1;
        return -1;
    }
}