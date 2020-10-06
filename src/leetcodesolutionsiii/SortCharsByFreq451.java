
package leetcodesolutionsiii;
import java.util.*;

public class SortCharsByFreq451
{
    public String frequencySort(String s) 
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            if(!map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i), 1);
            }
            else
            {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        List<Holder> ls = new ArrayList<>();
        
        for(Character c : map.keySet())
        {
            ls.add(new Holder(c, map.get(c)));
        }
        Collections.sort(ls, new Comparator<Holder>(){
            public int compare(Holder a, Holder b)
            {
                if(a.freq > b.freq)
                {
                    return -1;
                }
                else
                {
                    return 1;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Holder a : ls)
        {
            for(int i = 0 ; i < a.freq; ++i)
            {
                sb.append(a.c);
            }
        }
        return sb.toString();
    }
    class Holder
    {
        char c;
        int freq;
        public Holder(Character c, int freq)
        {
            this.c = c;
            this.freq = freq;
        }
    }
}
