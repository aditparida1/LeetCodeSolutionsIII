
package leetcodesolutionsiii;
import java.util.*;


public class KillProcess582
{
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) 
    {
        List<Integer> ls = new ArrayList<>();
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < ppid.size(); i++)
        {
            if(ppid.get(i) != 0)
            {
                if(map.containsKey(ppid.get(i)))
                {
                    map.get(ppid.get(i)).add(pid.get(i));
                }
                else
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(pid.get(i));
                    map.put(ppid.get(i), temp);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        
        q.add(kill);
        
        set.add(kill);
        
        while(!q.isEmpty())
        {
            int curr = q.poll();
            if(map.containsKey(curr))
            {
                List<Integer> temp = map.get(curr);
                for(int i: temp)
                {
                    if(!set.contains(i))
                    {
                        q.add(i);
                        set.add(i);
                    }
                }
            }
        }
        for(int i : set)
        {
            ls.add(i);
        }
        return ls;
    }
}
