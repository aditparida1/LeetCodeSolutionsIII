/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsiii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class FindAllDuplicatesinArray442
{
    public List<Integer> findDuplicates(int[] nums) 
    {
        
        List<Integer> ls = new ArrayList<>();
        if(nums == null || nums.length <= 1)
        {
            return ls;
        }
        for (int i = 0; i < nums.length; i++)
        {
            int curr = nums[i] < 0 ? -nums[i] : nums[i];
            curr --;
            if(nums[curr] < 0)
            {
                ls.add(curr+1);
            }
            else
            {
                nums[curr] *= -1;
            }
        }
        return ls;
    }
}
