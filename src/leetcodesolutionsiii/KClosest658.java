
package leetcodesolutionsiii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class KClosest658
{
    public List<Integer> findClosestElements(int[] arr, int k, int x) 
    {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0)
        {
            return result;
        }
        if(arr.length <= k)
        {
            for (int i = 0; i < arr.length; i++)
            {
                result.add(arr[i]);
            }
            return result;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                int dist1 = Math.abs(o1 - x);
                int dist2 = Math.abs(o2 - x);
                if(dist1 < dist2)
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
            
        });
        for (int i = 0; i < arr.length; i++)
        {
            pq.add(arr[i]);
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        
        while(!pq.isEmpty())
        {
            result.add(pq.poll());
        }
        return result;
    }
}
