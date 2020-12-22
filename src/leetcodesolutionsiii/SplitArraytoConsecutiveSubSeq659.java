/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsiii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class SplitArraytoConsecutiveSubSeq659
{
    public boolean isPossible(int[] nums) 
    {
        if(nums == null || nums.length == 0)
        {
            return false;
        }
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++)
        {
            int curr = nums[i];
            int req = curr - 1;
            
            if(map.containsKey(req))
            {
                var pq = map.get(req);
                int size = pq.poll();
                if(pq.isEmpty())
                {
                    map.remove(req);
                }
                size++;
                if(map.containsKey(curr))
                {
                    pq = map.get(curr);
                    pq.add(size);
                }
                else
                {
                    pq = new PriorityQueue<>();
                    pq.add(size);
                    map.put(curr, pq);
                }
            }
            else
            {
                if(map.containsKey(curr))
                {
                    var pq = map.get(curr);
                    pq.add(1);
                }
                else
                {
                    var pq = new PriorityQueue<Integer>();
                    pq.add(1);
                    map.put(curr, pq);
                }
            }
        }
        
        for(var key: map.keySet())
        {
            var pq = map.get(key);
            while(!pq.isEmpty())
            {
                if(pq.poll() < 3)
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}
