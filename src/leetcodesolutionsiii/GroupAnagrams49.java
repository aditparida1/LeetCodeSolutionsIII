
package leetcodesolutionsiii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class GroupAnagrams49
{
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        List<List<String>> fls = new ArrayList<>();
        if(strs == null || strs.length == 0)
        {
            return fls;
        }
        HashMap<String, List<String>> map  = new HashMap<>();
        for(int i = 0; i < strs.length; ++i)
        {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            if(map.containsKey(new String(arr)))
            {
                map.get(new String(arr)).add(strs[i]);
            }
            else
            {
                List<String> ls = new ArrayList<>();
                ls.add(strs[i]);
                map.put(new String(arr), ls);
            }
        }
        for(String k : map.keySet())
        {
            fls.add(map.get(k));
        }
        return fls;
    }
}
