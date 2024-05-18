class SearchInArrUnknownSize {
    public int search(ArrayReader reader, int target) {

        int low =0;
        int high = 1; //take any random value

        //Keep doing the expontential search for high until we find a index whose value is greater than target
        //This provides a range for the binary search
        while(reader.get(high) < target) {
            low = high;
            high *= 2;
        }

        while(low <= high) {
            int mid = low + (high-low)/2;
            if(target == reader.get(mid))
                return mid;

            if(target < reader.get(mid))
                high = mid-1;

            else
                low = mid+1;
        }

        return -1;
    }
}
