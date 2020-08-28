
package leetcodesolutionsiii;


public class BombEnemy361
{
    public int maxKilledEnemies(char[][] grid) 
    {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
        {
            return 0;
        }
        int max = 0;
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[][] count = new int[rowCount][colCount];
        for(int i = 0; i < rowCount; ++i)
        {
            int enemyCount = 0;
            for (int j = 0; j < colCount; j++)
            {
                if(grid[i][j] == 'E')
                {
                    enemyCount += 1;
                }
                else if(grid[i][j] == 'W')
                {
                    enemyCount = 0;
                }
                else
                {
                    count[i][j] += enemyCount;
                }
            }
            enemyCount = 0;
            for (int j = colCount - 1; j >= 0; j--)
            {
                if(grid[i][j] == 'E')
                {
                    enemyCount += 1;
                }
                else if(grid[i][j] == 'W')
                {
                    enemyCount = 0;
                }
                else
                {
                    count[i][j] += enemyCount;
                }
            }
        }
        for (int j = 0; j < colCount; j++)
        {
            int enemyCount = 0;
            for (int i = 0; i < rowCount; i++)
            {
                if(grid[i][j] == 'E')
                {
                    enemyCount += 1;
                }
                else if(grid[i][j] == 'W')
                {
                    enemyCount = 0;
                }
                else
                {
                    count[i][j] += enemyCount;
                }
            }
            enemyCount = 0;
            
            for (int i = rowCount - 1; i >= 0; i--)
            {
                if(grid[i][j] == 'E')
                {
                    enemyCount += 1;
                }
                else if(grid[i][j] == 'W')
                {
                    enemyCount = 0;
                }
                else
                {
                    count[i][j] += enemyCount;
                }
                max = Math.max(max, count[i][j]);
            }
        }
        
        
        return max;
    }
}
