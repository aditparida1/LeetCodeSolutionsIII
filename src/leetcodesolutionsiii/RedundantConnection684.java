
package leetcodesolutionsiii;
import java.util.*;

public class RedundantConnection684
{
    public int[] findRedundantConnection(int[][] edges) 
    {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++)
        {
            int u = edges[i][0] - 1;
            int v = edges[i][1] - 1;
            if(!map.containsKey(u))
            {
                var ls = new ArrayList<Integer>();
                ls.add(v);
                map.put(u, ls);
            }
            else
            {
                map.get(u).add(v);
            }
            if(!map.containsKey(v))
            {
                var ls = new ArrayList<Integer>();
                ls.add(u);
                map.put(v, ls);
            }
            else
            {
                map.get(v).add(u);
            }
        }
        int length = 0;
        for(int key: map.keySet())
        {
            length = Math.max(length, key);
        }
        int[] visited = new int[length + 1];
        int[] res = {-1, -1};
        
        getEdge(map, 0, 0, visited, res);
        
        return res;
    }
    private boolean getEdge(HashMap<Integer, List<Integer>> map, int prev, int curr, int[] visited, int[] res)
    {
        if(visited[curr] == 2)
            return false;
        if(visited[curr] == 1)
        {
            res[0] = prev;
            res[1] = curr;
            Arrays.sort(res);
            return true;
        }
        var ls = map.get(curr);
        visited[curr] = 1;
        
        for(int child: ls)
        {
            if(child != prev)
            {
                boolean got = getEdge(map, curr, child, visited, res);
                if(got)
                {
                    return true;
                }
            }
        }
        
        visited[curr] = 2;
        return false;
    }
    
}
