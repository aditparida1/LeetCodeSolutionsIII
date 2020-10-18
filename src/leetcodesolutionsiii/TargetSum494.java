
package leetcodesolutionsiii;

import java.util.*;

public class TargetSum494
{
    HashMap<Integer, Integer>[] plus;
    HashMap<Integer, Integer>[] minus;
    public int findTargetSumWays(int[] nums, int S) 
    {
        plus = new HashMap[nums.length];
        minus = new HashMap[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            plus[i] = new HashMap<>();
            minus[i] = new HashMap<>();
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++)
        {
            res += nums[i];
        }
        if(res < S)
        {
            return 0;
        }
        
        
        return helperTraverse(nums, 0, S, 0);
    }
    private int helperTraverse(int[] nums, int sum, int target, int i)
    {        
        
        if(i == nums.length)
        {
            if (sum == target)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        if(plus[i].containsKey(sum))
        {
            return plus[i].get(sum) + minus[i].get(sum);
        }
        int a = nums[i];
        int b = nums[i] * -1;
        
        int res1 = helperTraverse(nums, sum + a, target, i + 1);
        int res2 = helperTraverse(nums, sum + b, target, i + 1);
        int res = res1 + res2;
        plus[i].put(sum, res1);
        minus[i].put(sum, res2);
        return res;
    }
}
