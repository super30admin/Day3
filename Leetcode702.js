/**
 TC: O(log(n)) 
 SC: O(1)
 Solved in LC: Yes
 */
/**
 * @param {ArrayReader} reader
 * @param {number} target
 * @return {number}
 */
var search = function (reader, target) {
    var left=0,right=10000;
    while(left<=right){
        var mid = Math.floor((left+right)/2);
        if(reader.get(mid)==target){return mid;}
        if(reader.get(mid)<target){
            left++;
        }else{
            right--;
        }
    }
    return -1;
};