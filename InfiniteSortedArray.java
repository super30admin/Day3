/**
 * Solving using binary search, first trying to find the high point in the array
 * Then runing Binary search in the remaining portion.
 * Time complexity of O(LogN + LogM)
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        if(reader.get(low) == target) return low;
        while(reader.get(high) <= target){
           low = high;
           high *= 2;
        }

        while(low <= high){
            int mid = (low + high) / 2;
            if(reader.get(mid) == target) return mid;
            if(reader.get(mid) > target){
                high = mid - 1;
                }
            else{
                low = mid + 1;
            }
        }

        return -1;
    }
}