/*
 *                  Search in a rotated sorted array
 *
 * Leetcode : https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/description/
 * 
 * Time complexity : O(log M) + O(log N)
 * Space complexity : O(1) - No auxillary datastructure used.
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : -
 * Your code here along with comments explaining your approach in three sentences only
 *          - Using binary search, and increasing the bounds by 2x till we find the
 *            desired range where the target lies.
 */

#include <iostream>
#include <vector>
#include <limits.h>

// Mock implementation of ArrayReader for testing
class ArrayReader {
    std::vector<int> arr;
    
    public:
        ArrayReader(const std::vector<int>& input) : arr(input) {}

        int get(int index) const {
            if (index >= arr.size()) {
                return INT_MAX; // Assuming INT_MAX for elements out of bounds
            }
            return arr[index];
        }
};

// Solution class with the search method
class Solution {
    public:
        int search(const ArrayReader& reader, int target) {
            int low = 0;
            int high = 1;

            // Expand the search range exponentially until the target is within the range
            while(reader.get(high) < target) {
                low = high;
                high = 2 * high;
            }

            // Perform binary search within the identified range
            while(low <= high) {
                int mid = low + (high - low) / 2;

                if(reader.get(mid) == target) {
                    return mid;
                }

                if(reader.get(mid) > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return -1;
        }
};

// Main function for testing the Solution class
int main() {
    std::vector<int> input = {-1, 0, 3, 5, 9, 12};
    ArrayReader reader(input);
    Solution solution;

    int target = 9;
    int result = solution.search(reader, target);

    if (result != -1) {
        std::cout << "Target " << target << " found at index " << result << std::endl;
    } else {
        std::cout << "Target " << target << " not found" << std::endl;
    }

    return 0;
}
