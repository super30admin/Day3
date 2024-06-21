//userd binary search by doubling the inetrvals of low and high
//until high is less/equal to target
//TC: for getting search space = O(logN)
//TC: to search element in search space = O(logN)
//SC: O(N) just input reader is used, no extra memory used
class Solution {
    public int Search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        
        while(reader.get(high)<= target){
            low = high;
            high = high*2;
        }
        
        while(low<= high){
            int mid = low +(high-low)/2;
            int midval = reader.get(mid);
            if(midval == target){
                return mid;
            }
            
            if(target>midval){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        
        return -1;
    }
}