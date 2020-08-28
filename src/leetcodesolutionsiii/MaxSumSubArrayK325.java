/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsiii;

import java.util.HashMap;

/**
 *
 * @author aditp
 */
public class MaxSumSubArrayK325
{
    public int maxSubArrayLen(int[] nums, int k) 
    {
        int len = 0;
        int currSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++)
        {
            currSum += nums[i];
            if(!map.containsKey(currSum))
            {
                map.put(currSum, i);
            }
            int remSum = currSum - k;
            
            if(map.containsKey(remSum))
            {
                int fp = map.get(remSum);
                len = len < (i - fp) ? (i - fp) : len;
            }
            else if(remSum == 0)
            {
                len = len < i + 1 ? i + 1 : len;
            }
        }
        return len;
    }
}
