/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsiii;
import java.util.*;

public class MatchStickSquare473
{
    public boolean makesquare(int[] nums) 
    {
        if(nums == null || nums.length < 4)
        {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
        }
        if(sum % 4 != 0)
            return false;
        
        return traverseHelper(0, 0, 0, 0, nums, 0, sum / 4);
    }
    public boolean traverseHelper( int sum1, int sum2, int sum3, int sum4, int nums[], int index, int target)
    {
        if(index >= nums.length)
        {
            if(sum1 != target && sum2 != target && sum3 != target && sum4 != target)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        
        if(sum1 + nums[index] <= target)
        {
            if( traverseHelper(sum1 + nums[index], sum2, sum3, sum4, nums, index + 1, target))
            {
                return true;
            }
        }
        if(sum2 + nums[index] <= target)
        {
            if(traverseHelper(sum1 , sum2 + nums[index], sum3, sum4, nums, index + 1, target))
            {
                return true;
            }
        }
        if(sum3 + nums[index] <= target)
        {
            if(traverseHelper(sum1 , sum2, sum3 + nums[index], sum4, nums, index + 1, target))
                return true;
        }
        if(sum4 + nums[index] <= target)
        {
            if(traverseHelper(sum1 , sum2, sum3, sum4 + nums[index], nums, index + 1, target))
                return true;
        }
        return false;
    }
}
