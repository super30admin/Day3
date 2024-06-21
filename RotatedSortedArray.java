// Time Complexity : O(log n)
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/* Find the min elemnt and divide the search space in two halves, call binary search function on the respective halves.*/
class RotatedSortedArray {
    public int search(int[] nums, int target) {

        int minValueIndex = findMinValueIndex(nums);
        int index = binarySearch(nums,0,minValueIndex-1, target);
        int index2 = binarySearch(nums,minValueIndex,nums.length-1, target);
        return index==-1?index2:index;

    }

    int findMinValueIndex(int[] nums){
        int N = nums.length;
        int start =0;
        int end = N-1;

        while(start < end){
            int mid = start +(end-start)/2;

            if(nums[mid] < nums[end])
                end = mid;

            else
                start = mid + 1;
        }

        return start;
    }

    int binarySearch(int[] nums,int start, int end, int target){
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid]== target)
                return mid;

            else if(nums[mid]<= target){
                start = mid + 1;
            }
            else {
                end = mid -1;
            }
        }
        return -1;
    }

}