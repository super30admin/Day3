/*
Time Complexity:
The given solution uses a binary search approach, which typically operates in O(logn) time complexity,
where n is the number of elements in the array.

Space Complexity:
The algorithm uses a constant amount of extra space, as only a few integer variables (low, high, mid) are used.
Therefore, the space complexity is O(1).

Did this code successfully run on Leetcode : Yes

Brute Force way to do it using Linear Search. While using Binary search, half of the array will always be sorted.
 */

class SearchRotatedSortedArray {
    public int search(int[] nums, int target)
    {
        int len = nums.length;
        int low = 0, high = len-1;

        while(low <= high) {
            /*
            Here we can also right low < high, but in that case it won't check the element as target when low and high point to the same element
            say, 2,3,4,5,6,0,1 suppose in the end low and high point to 3, it wont check if 3 is the target, so to handle that scenario, in the end of while
            loop we should be checking if arr[low] == target, if yes return the position else return -1

            /*
            The reason we don't use (l+h)/2 to produce mid is because if my low + high produces a value that goes beyond the range i.e. 2^31, then
            it will go to the negative range, count those many values a produce a result either in negative range or positive range. So we need to use,
            low + [(high-low)/2] in all the programming languages, however in python (low+high)/2 will work.

            eg: low = 100, high = 200, so mid would be 100 + [(200-100)/2] = 100 + 50 = 150.

            */

            int mid = low + ((high-low)/2);

            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[low]<=nums[mid]) {//Left Sorted array,

                //Check if target lies in left sorted range
                if(nums[low]<=target && nums[mid]>target) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1; //Target is not in the left sorted range
                }
            }
            else {//Right Sorted Array

                //Check if target lies in right sorted range
                if(nums[mid]<target && nums[high]>=target) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1; //Target is not in the right sorted range
                }
            }
        }

        return -1; //If the target is not found
    }
}