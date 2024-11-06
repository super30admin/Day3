/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */
 // array of the undefined size is given 
 // if the size of the array is known and it is sorted we can apply the binary search
 // but we can define the end as INT_MAX and perform the binary search
 // other better way would be to start from small range and increase range by multiple of 2
 // here we have deciding factor if we want to increase the range by 2, 4, 6,10,5
 // but 2 can be good starting point as decreasing the multiple factor will increase num of trys
 // it will decrease the search speed.
class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int start = 0;
        int end = 1;
        while(reader.get(end) < target)
        {
            start = end;
            end = end *2;
        }
        //once we have the range
        while(start <= end)
        {
            int mid = start + (end- start)/2;

            if(reader.get(mid) == target)
                return mid;
            else if (target <= reader.get(mid))
                end = mid-1;
            else
                start = mid + 1;
        }
        return -1;
    }
};