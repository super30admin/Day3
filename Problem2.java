// Time complexity is log m + log n where m is the doubling of high or the search space
// and log n is the time complexity of binary search in that range

// space complexity is o(1)


public class Problem2 {
    public int search(ArrayReader reader, int target){

        int low = 0;
        int high = 1;
        
        while(reader.get(high) < target){
            low = high;
            high = 2*high;
        }
        while(low<=high){
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
