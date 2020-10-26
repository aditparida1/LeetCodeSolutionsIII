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
public class SingleElemSorted540
{
    public int singleNonDuplicate(int[] nums) 
    {
        if(nums.length < 2)
        {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right)
        {
            int mid = left + right;
            mid/=2;
            String res = isItSingle(nums, mid);
            int nm = -1;
            if(res.equals("none"))
            {
                return nums[mid];
            }
            else if(res.equals("left"))
            {
               nm = mid - 1;
            }
            else
            {
                nm = mid + 1;
            }
            int sm = nm < mid ? nm : mid;
            int bg = nm < mid ? mid : nm;
            int leftLen = sm - left;
            if(leftLen % 2 == 0)
            {
                left = bg + 1;
            }
            else
            {
                right = sm - 1;
            }
            
        }
        return nums[left];
    }
    String isItSingle(int[] nums, int i)
    {
        if(i == 0)
        {
            if(nums[i] != nums[i + 1])
            {
                return "none";
            }
        }
        if(i == nums.length - 1)
        {
            if(nums[i] != nums[i - 1])
            {
                return "none";
            }
        }
        
        if(nums[i] == nums[i - 1] )
        {
            return "left";
        }
        else if(nums[i] == nums[i + 1])
        {
            return "right";
        }
        return "none";
    }
}
