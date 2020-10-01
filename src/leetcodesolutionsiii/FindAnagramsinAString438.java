
package leetcodesolutionsiii;
import java.util.*;
public class FindAnagramsinAString438
{
    public List<Integer> findAnagrams(String s, String p) 
    {
        List<Integer> ls = new ArrayList<Integer>();
        if(p.length() > s.length())
        {
            return ls;
        }
        char[] arr = p.toCharArray();
        Arrays.sort(arr);
        String ana = new String(arr);
        
        for (int i = 0; i <= s.length() - p.length(); i++)
        {
            char[] cand = s.substring(i, i + p.length()).toCharArray();
            Arrays.sort(cand);
            String cndStr = new String(cand);
            if(cndStr.equals(ana))
            {
                ls.add(i);
            }
        }
        
        return ls;
    }
}
