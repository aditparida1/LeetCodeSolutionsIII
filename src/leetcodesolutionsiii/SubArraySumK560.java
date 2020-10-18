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
public class SubArraySumK560
{
    public int subarraySum(int[] nums, int k) 
    {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int total = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
//        List<Integer> ls = new ArrayList<>();
//        ls.add(-1);
//        map.put(0, ls);
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            
            int rem = sum - k;
            if(rem == 0 && k == 0)
            {
                total++;
            }
            if(rem == 0 && k != 0)
            {
                total++;
            }
            else if(map.containsKey(rem))
            {
                List<Integer> temp = map.get(rem);
                total += temp.size();
            }
            if(map.containsKey(sum))
            {
                map.get(sum).add(i);
            }
            else
            {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(sum, temp);
            }
        }
        
        return total;
    }
}
