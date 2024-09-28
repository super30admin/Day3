// Time complexity to O(log(n))
// Space complexity  O(1)

public class SearchInInfiniteSortedArray{
    public void search(){
        int l=0, h = 1;
        while(reader.get(h)<target){
            l=h;
            h = 2 *h;
        }
        int mid;
        while(l<=h){
            mid = l + (h-l)/2;
            if(reader.get(mid)>target){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }

    }
}