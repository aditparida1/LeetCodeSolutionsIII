
package leetcodesolutionsiii;
import java.util.*;

public class CombinationSumIV377
{
    public int combinationSum4(int[] nums, int target) 
    {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        //Arrays.sort(nums);
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> fls = new ArrayList<>(); //final list
        helperCombination(nums, 0, target, 0, ls, fls);
        int res = 0;
        for (int i = 0; i < fls.size(); i++)
        {
            ls = fls.get(i);
            int total = ls.size();
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int num: ls)
            {
                if(!map.containsKey(num))
                {
                    map.put(num, 1);
                }
                else
                {
                    map.put(num, map.get(num) + 1);
                }
            }
            total = fact(total);
            for(int key: map.keySet())
            {
                total /= fact(map.get(key));
            }
            res += total;
        }
        
        return res;
    }
    public int fact(int n)
    {
        if(n <= 1)
        {
            return 1;
        }
        return fact(n - 1) * n;
    }
    public void helperCombination(int[] nums, int currPos, int target, int currSum, List<Integer> ls, List<List<Integer>> fls)
    {
        if(currSum > target)
        {
            return;
        }
        if(currSum == target)
        {
            fls.add(new ArrayList<Integer>(ls));
            return;
        }
        for (int i = currPos; i < nums.length; i++)
        {
            ls.add(nums[i]);
            helperCombination(nums, i, target, currSum + nums[i], ls, fls);
            ls.remove(ls.size() - 1);
        }
    }
}
