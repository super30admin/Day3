/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */



class Solution {
    public int search(ArrayReader reader, int target) {
        int front = 1;
        int back = front/2;
        while(back<=front){
            if(reader.get(back)==target) return back;
            if(reader.get(front)==target) return front;
            //Check if the target is in between back and front
            if(target>reader.get(back) && reader.get(front)>target){
                int mid = back + (front-back)/2;
                if(reader.get(mid)==target) return mid;
                if(target>reader.get(back) && reader.get(mid)>target){
                    front = mid-1;
                }else{
                    back = mid+1;
                }
            }else{
                back = front;
                front = front * 2; 
            }
            
            System.out.println("Back :"+ back + "Front :"+ front);

        }

        return -1;
    }
}