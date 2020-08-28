
package leetcodesolutionsiii;

public class IncreasingTripletSubsequence334
{
    public boolean increasingTriplet(int[] nums) 
    {
        boolean fFirst = true;
        boolean sFirst = true;
        int f = 0;
        int s = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if(fFirst)
            {
                f = nums[i];
                fFirst = false;
            }
            else
            {
                if(nums[i] < f)
                {
                    f = nums[i];
                }
                else if(nums[i] > f)
                {
                    if(sFirst)
                    {
                        sFirst = false;
                        s = nums[i];
                    }
                    else
                    {
                        if(s < nums[i])
                        {
                            return true;
                        }
                        else if(s > nums[i])
                        {
                            s = nums[i];
                        }
                    }
                }
            }
        }
        return false;
    }
}
