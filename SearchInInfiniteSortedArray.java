// here in this implementation we would be trying to find the range of the numbers in which the number could be found. This could be acheived by starting our initial range to be between 0 and 1 indices and then increase the search till h < target and use this range to do a binary search on these sorted numbers to find the target.
// Time complexity would be O(log(n)) + O (log(h-l) ) which would be equivalent to O(log(n))
// Space complexity would be O(1)

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