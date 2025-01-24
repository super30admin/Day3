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

class Solution {
    public int search(ArrayReader reader, int target) {
         int low = 0;
         int high = 1;
        while(reader.get(high) < target)
        {
            low = high;
            high = 2 * high; // we are trying to find the range in which there is target.
        }
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
        return -1;
    }
}
