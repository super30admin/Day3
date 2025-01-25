// Overall Time Complexity : O log(m+n) . The m is range of elements  and n is the number of elements where binary search is executed.
// Overall Space Complexity : O(1) . The space complexity of storing the values in variables like low , high uses constant space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No issues faced during implementation


// The array reader problem involves finding the range where the element lies within the stream
// Then run the binary search algorithm on the range to find the index of the target.

public class ArrayReader {
        public int search(ArrayReader reader, int target) {
            int low = 0;
            int high = Integer.MAX_VALUE;
    
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (reader.get(mid) == Integer.MAX_VALUE) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
    
            int length = low;
            
            low = 0;
            high = length - 1;
    
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int val = reader.get(mid);
                if (val == target) {
                    return mid;
                } else if (val < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
    
             return reader.get(low) == target ? low : -1;
        }
    }

