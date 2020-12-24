
package leetcodesolutionsiii;
import java.util.*;

public class TrappingRainWater42
{
    public int trap(int[] height) 
    {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        
        for (int i = 0; i < height.length; i++)
        {
            if(i == 0)
            {
                left[i] = 0;
            }
            else
            {
                if(left[i - 1] < height[i - 1])
                {
                    left[i] = height[i - 1];
                }
                else
                {
                    left[i] = left[i - 1];
                }
            }
        }
        for (int i = height.length - 1; i >= 0; i--)
        {
            if(i == height.length - 1)
            {
                right[i] = 0;
            }
            else
            {
                if(right[i + 1] < height[i + 1])
                {
                    right[i] = height[i + 1];
                }
                else
                {
                    right[i] = right[i + 1];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < height.length; i++)
        {
            int leftHigh = left[i];
            int rightHigh = right[i];
            int minHigh = Math.min(leftHigh, rightHigh);
            if(minHigh > height[i])
            {
                res += minHigh - height[i];
            }
        }
        return res;
    }
}
