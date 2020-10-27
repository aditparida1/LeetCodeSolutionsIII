
package leetcodesolutionsiii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class ShortestUnsortedContinuousSubarray581
{
    public int findUnsortedSubarray(int[] nums) 
    {
        if(nums==null||nums.length == 0)
        {
            return 0;
        }
        int[] small = new int[nums.length];
        int[] large = new int[nums.length];
        small[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--)
        {
            if(nums[i] < small[i + 1])
            {
                small[i] = nums[i];
            }
            else
            {
                small[i] = small[i + 1];
            }
        }
        
        large[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++)
        {
            if(nums[i] > large[i - 1])
            {
                large[i] = nums[i];
            }
            else
            {
                large[i] = large[i - 1];
            }
        }
        int left = 0;
        while(left < nums.length && nums[left] == small[left])
        {
            left++;
        }
        if(left == nums.length)
        {
            return 0;
        }
        int right = nums.length - 1;
        while(right >= 0 && nums[right] == large[right])
        {
            right--;
        }
        return right - left + 1;
    }
}
