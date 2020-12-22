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
public class IslandPerimeterEasy463
{
    public int islandPerimeter(int[][] grid) 
    {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
        {
            return 0;
        }
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][] {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        boolean isAdded = false;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    q.add(new int[]{i, j});
                    grid[i][j] = -1;
                    isAdded = true;
                    break;
                }
            }
            if(isAdded)
            {
                break;
            }
        }
        while(!q.isEmpty())
        {
            int[] currPos = q.poll();
            for(int[] dir: dirs)
            {
                int nexti = currPos[0] + dir[0];
                int nextj = currPos[1] + dir[1];
                if(isValid(nexti, nextj, grid) && grid[nexti][nextj] != -1)
                {
                    if(grid[nexti][nextj] == 1)
                    {
                        q.add(new int[]{nexti, nextj});
                        grid[nexti][nextj] = -1;
                    }
                    else
                    {
                        count++;
                    }
                }
                else if(!isValid(nexti, nextj, grid))
                {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isValid(int i, int j, int[][] grid)
    {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
        {
            return false;
        }
        return true;
    }
}
