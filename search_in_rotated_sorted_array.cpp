/*
 *                  Search in a rotated sorted array
 *
 * Leetcode : https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * Time complexity : O(log N)
 * Space complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : -
 * Your code here along with comments explaining your approach in three sentences only
 *          - Using binary search, and eliminating the respective halves which may not 
 *            contain the target
 */

#include<iostream>
#include<vector>

using namespace std;

// Return the index at which the element is found.
int searchTarget(vector<int> input, int target) {
    int low = 0;
    int high = input.size() - 1;

    while (low <= high) {
        int mid = (low+high)/2;

        if (input[mid] == target) return mid;

        if (input[low] <= input[mid]) {
            if(input[mid] <= target && target <= input[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } else {
            if (input[mid] <= target && target <= input[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
    return -1;
}

int main() {

    std::vector<int> row1;
    int index = 0;

    row1.push_back(7);
    row1.push_back(8);
    row1.push_back(9);
    row1.push_back(1);
    row1.push_back(2);
    row1.push_back(3);
    row1.push_back(4);
    row1.push_back(5);
    row1.push_back(6);

    index = searchTarget(row1, 2);

    cout << "Target present at " << index << endl;
    return 0;
}