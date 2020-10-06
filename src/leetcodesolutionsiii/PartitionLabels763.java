
package leetcodesolutionsiii;
import java.util.*;

public class PartitionLabels763
{
    public List<Integer> partitionLabels(String s) 
    {
        if(s == null)
        {
            return new ArrayList<>();
        }
        if(s.length() == 0)
        {
            List<Integer> ls = new ArrayList<>();
            ls.add(0);
            return ls;
        }
        if(s.length() == 1)
        {
            List<Integer> ls = new ArrayList<>();
            ls.add(1);
            return ls;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); ++i)
        {
            map.put(s.charAt(i), i);
        }
        int fp = 0; int curr = 0;
        List<Integer> ls = new ArrayList<>();
        while(fp < s.length())
        {
            int lastIdx = map.get(s.charAt(fp));
            
            while(curr <= lastIdx)
            {
                char currChar = s.charAt(curr);
                int lastIdxCurr = map.get(currChar);
                if(lastIdx < lastIdxCurr)
                {
                    lastIdx = lastIdxCurr;
                }
                curr++;
            }
            ls.add(curr - fp);
            fp = curr;
        }
        return ls;
    }
}
