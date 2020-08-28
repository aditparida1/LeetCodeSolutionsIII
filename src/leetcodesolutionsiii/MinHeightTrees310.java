
package leetcodesolutionsiii;
import java.util.*;
/**
 *
 * @author aditp
 */

public class MinHeightTrees310
{
    public List<Integer> findMinHeightTrees(int n, int[][] edges) 
    {
        if(n == 0)
        {
            return new ArrayList<Integer>();
        }
        HashMap<Integer, ArrayList<Integer>> adjMap = convertToAdjList(n, edges);
        
        Queue<Integer> q = new LinkedList<>();
        for(int key: adjMap.keySet())
        {
            if(adjMap.get(key).size() == 1)
            {
                q.add(key);
            }
             
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
        {
            set.add(i);
        }
        while(set.size() > 2)
        {
            while(!q.isEmpty())
            {
                int node = q.poll();
                set.remove(node);
                adjMap.remove(node);
                for(int key : adjMap.keySet())
                {
                    adjMap.get(key).remove((Object)node);
                }
            }
            for(int key: adjMap.keySet())
            {
                if(adjMap.get(key).size() == 1)
                {
                    q.add(key);
                }

            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i : set)
        {
            list.add(i);
        }
        return list;
    }
    public HashMap<Integer, ArrayList<Integer>> convertToAdjList(int n, int[][] edges)
    {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for (int i = 0; i < edges.length; i++)
        {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            if(!adj.containsKey(node1))
            {
                adj.put(node1, new ArrayList<Integer>());
                adj.get(node1).add(node2);
            }
            else
            {
                adj.get(node1).add(node2);
            }
            if(!adj.containsKey(node2))
            {
                adj.put(node2, new ArrayList<Integer>());
                adj.get(node2).add(node1);
            }
            else
            {
                adj.get(node2).add(node1);
            }
        }
        return adj;
    }
}
