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
public class DiagonalTraverse498
{
    public int[] findDiagonalOrder(int[][] matrix) 
    {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return new int[0];
        }
        int idx = 0;
        int[] res = new int[matrix.length * matrix[0].length];
//        boolean isUp = true;
//        boolean downRow = true;
//        boolean upRow = false;
        boolean isRev = false;
        int currCol = 0;
        int row = 0; int col =0;
        
        for (int i = 0; i < matrix.length; i++)
        {
            List<Integer> ls = new ArrayList<>();
            row = i;
            col = 0;
            while(isValid(row, col, matrix))
            {
                ls.add(matrix[row][col]);
                row--;
                col++;
            }
            if(i % 2 != 0)
            {
                int[] temp = new int[ls.size()];
                for (int j = ls.size() - 1; j >= 0; j--)
                {
                    res[idx] = ls.get(j);
                    idx++;
                }
            }
            else
            {
                for (int j = 0; j < ls.size(); j++)
                {
                    res[idx] = ls.get(j);
                    idx++;
                }
            }
        }
        if((matrix.length - 1) % 2 == 0)
        {
            isRev = true;
        }
        for (int i = 1; i < matrix[0].length; i++)
        {
            List<Integer> ls = new ArrayList<>();
            row = matrix.length - 1;
            col = i;
            while(isValid(row, col, matrix))
            {
                ls.add(matrix[row][col]);
                row--;
                col++;
            }
            if(isRev)
            {
                int[] temp = new int[ls.size()];
                for (int j = ls.size() - 1; j >= 0; j--)
                {
                    res[idx] = ls.get(j);
                    idx++;
                }
            }
            else
            {
                for (int j = 0; j < ls.size(); j++)
                {
                    res[idx] = ls.get(j);
                    idx++;
                }
            }
            isRev = !isRev;
        }
        return res;
    }
    public boolean isValid(int row, int col, int[][] mat)
    {
        if(row < 0 || col < 0 || row >= mat.length || col >=  mat[0].length)
        {
            return false;
        }
        return true;
    }
}
