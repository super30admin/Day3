package BinarySearch;


// Time Complexity : O(Log(high-low))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// NOTE: Adding this part of the code in comment  section since ArrayReader is not defined:


public class ArrayOfUnknownLength {
//    public static int search(ArrayReader reader, int target) {
//        int low = 0;
//        int high = 1;
//
//        while(reader.get(high) < target) {
//            low = high;
//            high = high * 2;
//        }
//
//        if(reader.get(high) == target) {
//            return high;
//        }
//
//        return binarySearch(reader, low, high, target);
//    }
//
//    public static int binarySearch(ArrayReader reader, int low, int high, int target) {
//        while(low<=high) {
//            int mid = low + (high-low)/2;
//
//            if(reader.get(mid) == target) {
//                return mid;
//            }
//
//            else if(target > reader.get(mid)) {
//                low = mid+1;
//            }
//            else {
//                high = mid - 1;
//            }
//        }
//
//        return - 1;
//
//    }
}
