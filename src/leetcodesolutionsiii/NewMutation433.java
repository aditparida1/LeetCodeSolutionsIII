
package leetcodesolutionsiii;
import java.util.*;
public class NewMutation433
{
    public int minMutation(String start, String end, String[] bank) 
    {
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < bank.length; i++)
        {
            set.add(bank[i]);
        }
        Set<String> visited = new HashSet<>();
        visited.add(start);
        int lvl = 0;
        Queue<String> q = new LinkedList<>();
        q.add(start);
        char[] poss = {'A', 'C', 'G', 'T'};
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size > 0)
            {
                String s = q.poll();
                if(s.equals(end))
                {
                    return lvl;
                }
                for (int i = 0; i < s.length(); i++)
                {
                    StringBuilder sb = new StringBuilder(s);
                    for (int j = 0; j < poss.length; j++)
                    {
                        sb.setCharAt(i, poss[j]);
                        if(set.contains(sb.toString()) && !visited.contains(sb.toString()))
                        {
                            q.add(sb.toString());
                            visited.add(sb.toString());
                        }
                    }
                }
                
                size --;
            }
        }
        lvl++;
        
        return -1;
    }
}
