
package leetcodesolutionsiii;
import java.util.*;

public class TwoKeysKeyboard650
{
    int[][] dp;
    public int minSteps(int n) 
    {
        dp = new int[n + 1][n + 1];
        int min = minStepsHelper(1, 1, n);
        if(min == 0)
            return 0;
        return min + 1;
    }
    private int minStepsHelper(int screen, int clip, int n)
    {
        if(screen > n)
            return -1;
        if(screen == n)
        {
            return 0;
        }
        if(dp[screen][clip] != 0)
        {
            return dp[screen][clip];
        }
        if(screen != clip)
        {
            int copied = minStepsHelper(screen, screen, n);
            int paste = minStepsHelper(screen + clip, clip, n);
            if(copied == -1 && paste == -1)
            {
                dp[screen][clip] = -1;
                return -1;
            }
            if(copied == -1)
            {
                dp[screen][clip] = paste + 1;
                return paste + 1;
            }
            if(paste == -1)
            {
                dp[screen][clip] = copied + 1;
                return copied + 1;
            }
            int min = Math.min(copied, paste) + 1;
            dp[screen][clip] = min;
            return min;
        }
        else
        {
            int paste = minStepsHelper(screen + clip, clip, n);
            if(paste == -1)
            {
                dp[screen][clip] = -1;
                return -1;
            }
            dp[screen][clip] = paste + 1;
            return paste + 1;
        }
    }
}
