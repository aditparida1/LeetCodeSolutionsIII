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
public class Interview2
{
    int sol;
    public int solution(int[] a)
    {
        this.sol = 0;
        helper(a, 0, a.length - 1);
        return sol;
    }
    public void helper(int[] a, int start, int end)
    {
        if(start == end)
        {
            sol += a[start];
            a[start] = 0;
            return ;
        }
        if(start <= end)
        {
            int min = -1;
            int idx = -1;
            for (int i = start; i <= end; i++)
            {
                if (min == -1)
                {
                    min = a[i];
                    idx = i;
                }
                else
                {
                    if(min > a[i])
                    {
                        idx = i;
                        min = a[i];
                    }
                    
                    
                }
            }
            for (int i = start; i <= end && min != 0; i++)
            {
                a[i] -= min;
            }
            sol += min;
            int left = idx - 1;
            int right = idx + 1;
            if(left >= start)
            {
                helper(a, start, left);
            }
            if(right <= end)
            {
                helper(a, right, end);
            }
        }
    }
}
