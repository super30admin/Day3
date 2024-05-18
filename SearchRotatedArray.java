public class SearchRotatedArray {
        // Time Complexity: O(logN)
        // Space Complexity: O(1)
        public int search(int[] nums, int target) {
            int low=0, high=nums.length-1;
            int mid =0;
            while(low<=high){
                mid = low + (high- low)/2;
                if(nums[mid]==target){
                    return mid;
                }
                else if(nums[mid]>=nums[low]){
                    if(nums[mid]>target&&nums[low]<=target){
                        high = mid-1;
                    }else{
                        low = mid+1;
                    }

                }else {
                    if(nums[mid]<target&&nums[high]>=target){
                        low = mid+ 1;

                    }else{
                        high = mid-1;
                    }

                }
            }
            return -1;
        }
    }