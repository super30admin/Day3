    
    int search(const ArrayReader& reader, int target) {
        int low = 0;
        while(reader.get(low)<=target){
            if(reader.get(low)==target) return low;
            low = 2*low+1;
        }
        int high = low;
        low = (low-1)/2;
        while(low<high){
            int mid = (low+high)/2;
            if(reader.get(mid)==target) return mid;
            else if(reader.get(mid)>target) high = mid-1;
            else low = mid+1;
        }
        if(reader.get(low)==target) return low;
        return -1;
    }