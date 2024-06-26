public class Solution {
    public bool IsIsomorphic(string str1, string str2) {
            if(str1.Length != str2.Length) return false; 
    Dictionary<char,char> sChar = new Dictionary<char, char>();
    Dictionary<char,char> tChar = new Dictionary<char, char>();
    for(int i=0; i< str1.Length;i++)
    {
       if(sChar.ContainsKey(str1[i]))
        if(sChar[str1[i]] != str2[i]) return false;
       
       if(tChar.ContainsKey(str2[i]))
        if(tChar[str2[i]] != str1[i]) return false;
       
       if(!sChar.ContainsKey(str1[i]))
        sChar.Add(str1[i],str2[i]);

           if(!tChar.ContainsKey(str2[i]))
        tChar.Add(str2[i],str1[i]);
    }
   return true; 
    }
}