
package leetcodesolutionsiii;
import java.util.*;

public class FindAllDissppeared448
{
    public List<Integer> findDisappearedNumbers(int[] nums) 
    {
        List<Integer> ls = new ArrayList<Integer>();
        if(nums == null || nums.length <= 1)
        {
            return ls;
        }
        for (int i = 0; i < nums.length; i++)
        {
            int curr = nums[i] < 0 ? -nums[i] : nums[i];
            curr--;
            if(nums[curr] > 0)
            {
                nums[curr] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i] > 0)
            {
                ls.add(i + 1);
            }
        }
        return ls;
    }
}
