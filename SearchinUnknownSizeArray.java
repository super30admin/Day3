public class SearchinUnknownSizeArray {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        if (reader.get(high) == target) {
            return high;
        }

        return binarySearchTarget(reader, target, low, high);
    }

    public int binarySearchTarget(ArrayReader reader, int target, int low, int high){

        while(low <=high){
            int mid = low +(high-low)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            if(reader.get(mid) < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }

}

