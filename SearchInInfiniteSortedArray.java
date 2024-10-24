// Time Complexity :search: O(log n) , in Binary search we're eliminating the half of the input
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : don't have leetcode premium
// Any problem you faced while coding this : couldnt run, debug and see


class SearchInInfiniteSortedArray {
        public int search(ArrayReader reader, int target) {
            int low = 0;
            int high = 1;

            while(reader.get(high)<target) {
                low = high;
                high = high * 2;
            }
            while(low<=high){
                int mid= low +(high-low)/2;

                if(reader.get(mid)==target){
                    return mid;
                }else if(reader.get(mid)>target){
                    high = mid-1;
                } else{
                    low = mid+1;
                }

            }

            return -1;

        }
}
