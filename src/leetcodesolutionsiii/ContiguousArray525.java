
package leetcodesolutionsiii;
import java.util.*;

public class ContiguousArray525
{
    public int findMaxLength(int[] nums) 
    {
        int size = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int zeros = 0; int ones = 0;
        
        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                zeros++;
            }
            else
            {
                ones++;
            }
            
            int dist = zeros - ones;
            if(map.containsKey(dist))
            {
                int start = map.get(dist);
                size = size < i - start? i - start : size;
            }
            if(!map.containsKey(dist))
            {
                map.put(dist, i);
            }
        }
        return size;
    }
}
