
package leetcodesolutionsiii;
import java.util.*;



public class ReconstructItenerary332
{
    public List<String> findItinerary(List<List<String>> tickets) 
    {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++)
        {
            if(hm.containsKey(tickets.get(i).get(0)))
            {
                hm.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
            }
            else
            {
                hm.put(tickets.get(i).get(0), new ArrayList<>());
                hm.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
            }
        }
        for (String s : hm.keySet())
        {
            Collections.sort(hm.get(s));
        }
        List<String> fls = new ArrayList<String>();
        DFS("JFK", hm, fls);
        return fls;
    }   
    public void DFS(String port, HashMap<String, List<String>> map, List<String> ls)
    {
        if(map.containsKey(port))
        {
            List<String> dest = map.get(port);
            while(!dest.isEmpty())
            {
                String nextPort = dest.get(0);
                dest.remove(0);
                DFS(nextPort, map, ls);
            }
        }
        ls.add(0,port);
    }
}
