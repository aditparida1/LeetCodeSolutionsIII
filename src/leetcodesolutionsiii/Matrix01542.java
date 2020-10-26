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
public class Matrix01542
{
    public int[][] updateMatrix(int[][] matrix) 
    {
        if(matrix == null || matrix.length == 0|| matrix[0].length == 0)
        {
            return null;
        }
        int[][] res = new int[matrix.length][matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    res[i][j] = 0;
                }
                
            }
        }
        int[][] dirs = new int[][]{{1,0},{-1,0}, {0,1}, {0, -1}};
        int lvl = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size > 0)
            {
                int[] curr = q.poll();
                
                for(int[] dir: dirs)
                {
                    int[] newPos = new int[]{curr[0] + dir[0], curr[1] + dir[1]};
                    if(isValid(newPos[0], newPos[1], matrix) && !visited[newPos[0]][newPos[1]])
                    {
                        visited[newPos[0]][newPos[1]] = true;
                        if(matrix[newPos[0]][newPos[1]] == 0)
                        {
                            res[newPos[0]][newPos[1]] = 0;
                        }
                        else
                        {
                            res[newPos[0]][newPos[1]] = lvl + 1;
                        }
                    }
                }
                
                size --;
            }
            lvl++;
        }
        
        
        return res;
    }
    
    public boolean isValid(int i, int j, int[][] matrix)
    {
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length)
        {
            return false;
        }
        return true;
    }
}
