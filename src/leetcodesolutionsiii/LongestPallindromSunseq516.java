
package leetcodesolutionsiii;
import java.util.*;

public class LongestPallindromSunseq516
{
    //another solution
    public int longestPalindromeSubseqOther(String s) 
    {
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        
        dp[0][0] = 1;
        for (int i = 1; i < s.length(); i++)
        {
            dp[i][i] = 1;
            if(s.charAt(i) == s.charAt(i - 1))
            {
                dp[i][i - 1] = dp[i - 1][i] = 1;
            }
        }
        int size = 3;
        for (size = 3; size <= s.length(); size++)
        {
            boolean isUpdated = false;
            for (int i = 0; i <= s.length() - size; i++)
            {
                int end = i + size - 1;
                if(dp[i + 1][end - 1] == 1 && s.charAt(end) == s.charAt(i))
                {
                    dp[i][end] = dp[end][i] = 1;
                    isUpdated = true;
                }
            }
            if(!isUpdated)
            {
                break;
            }
        }
        
        return size - 1;        
    }
    
}
