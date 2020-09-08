
package leetcodesolutionsiii;

public class WiggleSubSeq376
{
    public int wiggleMaxLength(int[] nums) 
    {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int[] dpPos = new int[nums.length];
        int[] dpNeg = new int[nums.length];
        dpPos[0] = 1;
        dpNeg[0] = 1;
        
        for(int i = 1; i < nums.length; ++i)
        {
            int maxPos = 1;
            int maxNeg = 1;
            for(int j = 0; j < i; ++j)
            {
                if(nums[i] < nums[j])
                {
                    //that means i is in negetive sequence
                    if(maxNeg < dpPos[j] + 1)
                    {
                        maxNeg = dpPos[j] + 1;
                    }
                    
                }
                if(nums[i] > nums[j])
                {
                    if(maxPos < dpNeg[j] + 1)
                    {
                        maxPos = dpNeg[j] + 1;
                    }
                }
            }
            dpPos[i] = maxPos;
            dpNeg[i] = maxNeg;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++)
        {
            max = max < dpPos[i] ? dpPos[i] : max;
            max = max < dpNeg[i] ? dpNeg[i] : max;
        }
        return max;
    }
}
