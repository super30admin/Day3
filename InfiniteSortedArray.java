// Time Complexity :o(logn logm)
// Space Complexity :o(1) 
// Did this code successfully run on Leetcode : it runs good in leat code
// Any problem you faced while coding this : no
 public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        if(reader.get(low) == target) return low;
        while(reader.get(high) <= target){
           low = high;
           high *= 2;
        }

        while(low <= high){
            int mid = (low + high) / 2;
            if(reader.get(mid) == target) return mid;
            if(reader.get(mid) > target){
                high = mid - 1;
                }
            else{
                low = mid + 1;
            }
        }

        return -1;
    }
}