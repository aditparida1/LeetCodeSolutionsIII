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
public class OnesAndZeros474
{
    public int findMaxForm(String[] strs, int m, int n) 
    {
        int[][][] map = new int[strs.length][m + 1][n + 1];
        return traverse(strs, 0, m, n, map);
    }
    public int traverse(String[] strs, int idx, int m, int n, int[][][] map) 
    {
        if(idx == strs.length)
        {
            return 0;
        }
        if(map[idx][m][n] != 0)
        {
            return map[idx][m][n];
        }
        int taken = 0;
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < strs[idx].length(); i++)
        {
            if(strs[idx].charAt(i) == '0')
            {
                zeros++;
            }
            else
            {
                ones++;
            }
        }
        if(m - zeros >= 0 && n - ones >= 0)
        {
            taken = traverse(strs, idx + 1, m - zeros, n - ones, map) + 1;
        }
        int notTaken = traverse(strs, idx + 1, m, n, map);
        map[idx][m][n] = Math.max(taken, notTaken);
        return map[idx][m][n];
    }
    
}
