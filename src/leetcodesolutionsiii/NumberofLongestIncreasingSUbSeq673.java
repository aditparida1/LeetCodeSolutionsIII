
package leetcodesolutionsiii;
import java.util.*;


public class NumberofLongestIncreasingSUbSeq673
{
    public int findNumberOfLIS(int[] nums) 
    {
        if(nums== null || nums.length == 0)
            return 0;
        int[] largest = new int[nums.length];
        int[] count = new int[nums.length];
        int max = -1;
        int maxCount = -1;
        for(int i = 0; i < nums.length; ++i)
        {
            int currLen = 0;
            int currCount = 0;
            for(int j = 0; j < i; ++j)
            {
                if(nums[i] > nums[j])
                {
                    if(currLen < largest[j])
                    {
                        currLen = largest[j];
                        currCount = count[j];
                    }
                    else if(currLen == largest[j])
                    {
                        currCount += count[j];
                    }
                }
            }
            if(currLen == 0)
            {
                largest[i] = 1;
                count[i] = 1;
            }
            else
            {
                largest[i] = currLen + 1;
                count[i] = currCount;
            }
        }
        for (int i = 0; i < largest.length; i++)
        {
            if(largest[i] > max)
            {
                max = largest[i];
                maxCount = count[i];
            }
            else if(largest[i] == max)
            {
                maxCount += count[i];
            }
        }
        return maxCount;
    }
}
