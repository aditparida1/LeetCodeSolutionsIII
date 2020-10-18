package leetcodesolutionsiii;
import java.util.*;

public class CoinChangeII518
{
    HashMap<Integer, Integer>[] map;
    public int change(int amount, int[] coins) 
    {
        if(amount == 0)
        {
            return 1;
        }
        if(coins == null || coins.length == 0)
        {
            return 0;
        }
        map = new HashMap[coins.length];
        for (int i = 0; i < map.length; i++)
        {
            map[i] = new HashMap<>();
        }
        return helperCoinchange2(amount, 0, coins);
    }
    public int helperCoinchange2(int target, int idx, int[] coins)
    {
        if(target == 0)
        {
            return 1;
        }
        if(target < 0)
        {
            return 0;
        }
        if(idx >= coins.length)
        {
            return 0;
        }
        
        if(map[idx].containsKey(target))
        {
            return map[idx].get(target);
        }
        
        int taken = helperCoinchange2(target - coins[idx], idx, coins);
        int notTaken = helperCoinchange2(target, idx + 1, coins);
        map[idx].put(target, taken + notTaken);
        return map[idx].get(target);
    }
}
