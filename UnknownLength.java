class Solution {
    public int search(ArrayReader reader, int target) {
        int low=reader.get(0);
        int high=reader.get((low+1)*2);
        int mid=0;

        while(low<=high){
            mid=(low+high)/2;
            if(reader.get(mid)==target)
             return mid;
             if(reader.get(low)==target)
             return low;
             if(reader.get(high)==target)
             return high;
             if(!(reader.get(low)<=target && reader.get(high)>=target)){
                low=high+1;
                high=low*2;
            }else{
                 if(reader.get(low)<=target && reader.get(mid)>=target)
                 high=mid-1;
                   else
                   low=mid+1;
            
            } 
                
        }
        return -1;
    }
}