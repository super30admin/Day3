//The approach here we will follow is we will search in a specific range and apply binary search to it accordingly since we cannot get the whole range of array
Class Solution{
    public int search(ArrayReader reader, int target){
        int s=0;
        int e=1;
        while(reader.get(high)<target){
            s=e;
            e = e+1;
            
        }
        while(s<e){
            int mid = s+(e-s)/2;
            if(reader.get(mid)>=target){
               e = mid;
            }
            else{
                s = mid+1;
            }
        }
        if(reader.get(s)==target) return low;
        return -1;
    }
}