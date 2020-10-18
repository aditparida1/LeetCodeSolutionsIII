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
public class NextGreaterElementII503
{
    public int[] nextGreaterElements(int[] nums) 
    {
        if(nums == null || nums.length == 0)
        {
            return new int[0];
        }
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            res[i] = -1;
        }
        for (int i = 0; i < 2; i++)
        {
            for (int idx = 0; idx < nums.length; idx++)
            {
                if(st.isEmpty())
                {
                    st.push(idx);
                }
                else
                {
                    while(!st.isEmpty() && nums[st.peek()] < nums[idx])
                    {
                        int temp = st.pop();
                        res[temp] = nums[idx];
                    }
                    st.push(idx);
                }
            }
        }
        return res;
    }
    public int increamentIndex(int[] nums, int i)
    {
        i++;
        if(i >= nums.length)
        {
            i = 0;
        }
        return i;
    }
}
