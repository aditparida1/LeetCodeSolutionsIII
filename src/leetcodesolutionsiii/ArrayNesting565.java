/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsiii;

/**
 *
 * @author aditp
 */
public class ArrayNesting565
{
    public int arrayNesting(int[] nums) 
    {   
        int max = -1;
        for (int i = 0; i < nums.length; i++)
        {
            nums[i] += 1;
        }
        
        for (int i = 0; i < nums.length; i++)
        {
            int len = 1;
            if(nums[i] > 0)
            {
                int p = i;
                while(nums[p] > 0)
                {
                    nums[p] *= -1;
                    p = -1* nums[p];
                    len++;
                }
                max = max < len ? len : max;
            }
        }
        return max;
    }
}
