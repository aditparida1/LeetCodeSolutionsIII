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
public class PartEqualSubSum416
{
    public boolean canPartition(int[] nums)
    {
        int target = 0;
        for (int i = 0; i < nums.length; i++)
        {
            target += nums[i];
        }
        if(target % 2 != 0)
        {
            return false;
        }
        target /= 2;
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < nums.length; i++)
        {
            Set<Integer> set = new HashSet<>();
            if(i == 0)
            {
                st.push(nums[i]);
                set.add(nums[i]);
                if(!set.contains(0))
                {
                    set.add(0);
                    st.push(nums[i]);
                }
            }
            else
            {
                Stack<Integer> temp = new Stack<Integer>();
                while(st.isEmpty() != true)
                {
                    int currNum = st.pop();
                    if(!set.contains(currNum))
                    {
                        if(currNum == target)
                        {
                            return true;
                        }
                        set.add(currNum);
                        temp.push(currNum);
                    }
                    int newNum = currNum + nums[i];
                    if(newNum == target)
                    {
                        return true;
                    }
                    if(!set.contains(newNum) && newNum < target)
                    {
                        set.add(newNum);
                        temp.push(newNum);
                    }
                    
                }
                st = temp;
            }
        }
        
        return false;
    }
}
