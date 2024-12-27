public class SortedArrayUnknownSize {
    public int search(ArrayReader reader, int target) {
        int h = 1;
        while(reader.get(h) < target){
            h=h<< 1;
        }
        int l = h >> 1;

        while(h>=l){
            int mid = (l+h)/2;
            if(reader.get(mid) > target){
                h=mid-1;
            }
            else
            if(reader.get(mid) < target){
                l = mid+1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
