
package leetcodesolutionsiii;
import java.util.*;
public class CoinChange322
{
    public int coinChange(int[] coins, int amount) 
    {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++)
        {
            for (int j = 0; j < coins.length; j++)
            {
                if(coins[j] <= i)
                {
                    dp[i] = min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[dp.length - 1] > amount ? -1 : dp[amount];
    }
    private int min(int a, int b)
    {
        return a < b ? a : b;
    }
}
