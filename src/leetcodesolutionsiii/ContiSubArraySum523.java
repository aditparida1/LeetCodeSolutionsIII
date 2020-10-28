
package leetcodesolutionsiii;
import java.util.HashMap;



public class ContiSubArraySum523
{
    public boolean checkSubarraySum(int[] nums, int k) 
    {
        if(nums == null || nums.length == 0 || nums.length == 1)
        {
            return false;
        }
        if(k < 0)
        {
            k *= -1;
        }
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        int curr = 0;
        for (int i = 0; i < nums.length; i++)
        {
            curr += nums[i];
            sum[i + 1] = curr;
            for (int j = 0; j <= i - 1; j++)
            {
                if(k == 0)
                {
                    if(curr - sum[j] == 0)
                    {
                        return true;
                    }
                }
                else if((curr - sum[j]) % k == 0)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
