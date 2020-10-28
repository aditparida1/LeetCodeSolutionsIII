/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsiii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aditp
 */
public class SplitArrayWithEqualSum548
{
    public boolean splitArray(int[] nums) 
    {
        if(nums == null || nums.length < 7)
        {
            return false;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        int sum = 0;
        int[] sumStorage = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            sumStorage[i] = sum;
            if(map.containsKey(sum))
            {
                map.get(sum).add(i);
            }
            else
            {
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                map.put(sum, ls);
            }
        }
        
        
        for (int i = 1; i <= nums.length - 6; i++)
        {
            
        }
        
        return false;
    }
    public boolean isPossible(Map<Integer, List<Integer>> map, int idx, int sum, int anchorNum, int[] nums)
    {
        //int sec = 
        if(anchorNum == 3)
        {
            
        }
        int currStart = idx + 2;
        if(currStart >= nums.length)
        {
            return false;
        }
        boolean isPoss = false;
        
        
        return isPoss;
    }
}
