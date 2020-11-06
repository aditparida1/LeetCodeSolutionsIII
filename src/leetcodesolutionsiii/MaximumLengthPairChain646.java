
package leetcodesolutionsiii;
import java.util.*;

public class MaximumLengthPairChain646
{
    public int findLongestChain(int[][] pairs) 
    {
        if(pairs == null || pairs.length == 0)
        {
            return 0;
        }
        int count = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
        new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                if(o1[1] < o2[1])
                {
                    return -1;
                }
                else
                {
                    return 1;
                }
            }
            
        }
        );
        for (int i = 0; i < pairs.length; i++)
        {
            pq.add(pairs[i]);
        }
        int[] curr = null;
        
        while(!pq.isEmpty())
        {
            if(curr == null)
            {
                curr = pq.poll();
                count++;
            }
            else
            {
                int[] temp = pq.poll();
                if(temp[0] > curr[1])
                {
                    curr = temp;
                    count++;
                }
            }
        }
        
        return count;
    }
}
