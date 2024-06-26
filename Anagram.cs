/*
Time Complexity --> O(nk)
Space Complexity --> O(n)
Code Submitted in LeetCode without any issue : Yes
Any Issue faced : Faced issue because i started the Prime number with 1 and another issue faced was 
I had to use double instead of int and long data type for product
 */

 public class Solution {
    Dictionary<double,List<string>> anagram =  new Dictionary<double,List<string>>(); 
        long[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};

    public IList<IList<string>> GroupAnagrams(string[] strs) {
    
        List<string> anagrams = new List<string>(); 
        foreach(string str in strs)
        {
            double product = GetProductOfInteger(str);
            if(!anagram.ContainsKey(product))
                anagram.Add(product,new List<string>());

             anagram[product].Add(str);   

        }
         var listOfLists = anagram.Values.Select(list => list.ToList()).ToList();

        // Convert List<List<string>> to IList<IList<string>> (if needed)
        IList<IList<string>> result = listOfLists.Cast<IList<string>>().ToList();
        return result;

  }
  public double GetProductOfInteger(string str){
    double product = 1; 
    foreach(char c in str){
      product *= primes[c-'a'] ;
    }  
    return product; 

  }
}