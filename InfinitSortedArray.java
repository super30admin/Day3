/*
 * Given a sorted array of unknown length and a number to search for, 
 * return the index of the number in the array. Accessing an element 
 * out of bounds throws exception. If the number occurs multiple times, 
 * return the index of any occurrence. If it isn’t present, return -1.
 */

class InfinteSortedArray {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(reader.get(high) <= target) {
            low = high;
            high = 2*high;
        }
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target) return mid;
            else if(target < reader.get(mid)) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}