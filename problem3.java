//Problem3
//Search in Infinite sorted array:
//
//https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
//
//Given a sorted array of unknown length and a number to search for, return the index of the number in the array.
//Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence.
//If it isn’t present, return -1

// the time complexity is O(n)
interface ArrayReader {
    public default int get(int index) {
        return index;
    }
}
public class problem3 {

    public int search(ArrayReader reader, int target) {
        int low=0, high= 1;
        while(reader.get(high)<target) {
            low= high;
            high= high*2;
        }
        while(low<=high) {
            int mid=low+(high-low)/2;
            if(reader.get(mid)==target) {
                return mid;
            }
            else if(reader.get(mid)>target) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return -1;
    }
}
