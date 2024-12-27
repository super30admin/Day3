// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
public class SearchRotatedArray {

    int findPivotElement(int[] nums){
        int l = 0; int h=nums.length - 1;
        int p =l;
        int mid = (h+p)/2;
        while(h>p){
            if(nums[l] < nums[mid]){
                if(mid>0 && nums[mid] < nums[mid-1]){
                    return mid;
                }
                p=mid+1;
            }else{
                if(mid >0 && nums[mid] < nums[mid-1]){
                    return mid;
                }
                h=mid-1;
            }
            mid = (h+p)/2;
        }
        return h==-1? mid+1: mid;
    }

    int findTarget(int[] arr, int l, int h, int target){
        while(h>=l){
            int mid = (h+l)/2;
            if(target > arr[mid]){
                l = mid+1;
            }
            else if(target < arr[mid])
            {
                h = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int pivot = findPivotElement(nums);
        int result = findTarget(nums, 0, pivot-1, target);
        if(result == -1){
            return findTarget(nums, pivot, nums.length-1, target);
        }
        return result;
    }
}
