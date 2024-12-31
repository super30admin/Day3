// here the approach is to find a range where the target could exist and for that we're moving the high ptr by 2 because we divide by 2 if we're using B.S.
public class SearchInASortedArrayOfUnknownSize {
    public static class ArrayReader{
        public int get(int index){
            return Integer.MAX_VALUE;// this will actually be the value at the particular index.
        }
    }
    public int search(ArrayReader arrayReader, int target) {
        int low = 0;
        int high = 1;

        //loop until the value at high becomes greater than target.
        while (arrayReader.get(high) < target) {
            low = high;
            high = high * 2;
        }
        if (arrayReader.get(high) == target) {
            return high;
        }
        //binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arrayReader.get(mid) == target) {
                return mid;
            } else if (arrayReader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 44564;
    }
}
