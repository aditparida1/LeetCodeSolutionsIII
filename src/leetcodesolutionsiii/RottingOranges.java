
package leetcodesolutionsiii;
import java.util.*;


public class RottingOranges
{
    public int orangesRotting(int[][] grid) 
    {
        if(grid == null)
        {
            return -1;
        }
        if(grid.length == 0 || grid[0].length == 0)
        {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        int good = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1)
               {
                   good++;
               }
            }
        }
        
        int rounds = 0;
        if(q.isEmpty() && good == 0)
       {
           return 0;
       }
        else if(q.isEmpty() && good != 0)
        {
            return -1;
        }
        while(!q.isEmpty())
        {
            rounds++;
            int size = q.size();
            for (int i = 0; i < size; i++)
            {
                int[] pos = q.poll();
                int[] left = new int[2];
                int[] right = new int[2];
                int[] up = new int[2];
                int[] down = new int[2];
                left[0] = pos[0];
                left[1] = pos[1] - 1;
                right[0] = pos[0];
                right[1] = pos[1] + 1;
                up[0] = pos[0] - 1;
                up[1] = pos[1];
                down[0] = pos[0] + 1;
                down[1] = pos[1];
                if(isValid(grid, left[0], left[1]))
                {
                    if(grid[left[0]][left[1]] == 1)
                    {
                        grid[left[0]][left[1]] = 2;
                        q.add(left);
                    }
                }
                if(isValid(grid, right[0], right[1]))
                {
                    if(grid[right[0]][right[1]] == 1)
                    {
                        grid[right[0]][right[1]] = 2;
                        q.add(right);
                    }
                }
                if(isValid(grid, up[0], up[1]))
                {
                    if(grid[up[0]][up[1]] == 1)
                    {
                        grid[up[0]][up[1]] = 2;
                        q.add(up);
                    }
                }
                if(isValid(grid, down[0], down[1]))
                {
                    if(grid[down[0]][down[1]] == 1)
                    {
                        grid[down[0]][down[1]] = 2;
                        q.add(down);
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    return -1;
                }
            }
            
        }
        if(rounds == 0)
        {
            return 0;
        }
        return rounds - 1;
    }
    private boolean isValid(int[][] matrix, int i, int j)
    {
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length)
        {
            return false;
        }
        return true;
    }
}
