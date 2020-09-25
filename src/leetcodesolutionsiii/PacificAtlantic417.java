
package leetcodesolutionsiii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class PacificAtlantic417
{
    public List<List<Integer>> pacificAtlantic(int[][] matrix) 
    {
        List<List<Integer>> fls = new ArrayList<>();
        int[][] flowMatrix = new int[matrix.length][matrix[0].length];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < matrix.length; ++i)
        {
            flowMatrix[i][0] = 1;
            q.add(new int[]{i,0});
        }
        for(int j = 0; j < matrix[0].length; ++j)
        {
            flowMatrix[0][j] = 1;
            q.add(new int[]{0,j});
        }
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            int[] up = new int[]{curr[0] -1, curr[1]};
            int[] left = new int[]{curr[0], curr[1] - 1};
            int[] right = new int[]{curr[0] , curr[1] + 1};
            int[] down = new int[]{curr[0] +1, curr[1]};
            
            if(isValid(up[0], up[1], matrix))
            {
                if(matrix[curr[0]][curr[1]] <= matrix[up[0]][up[1]] && flowMatrix[up[0]][up[1]] == 0)
                {
                    q.add(new int[]{up[0], up[1]});
                    flowMatrix[up[0]][up[1]] = 1;
                }
            }
            if(isValid(left[0], left[1], matrix))
            {
                if(matrix[curr[0]][curr[1]] <= matrix[left[0]][left[1]] && flowMatrix[left[0]][left[1]] == 0)
                {
                    q.add(new int[]{left[0], left[1]});
                    flowMatrix[left[0]][left[1]] = 1;
                }
            }
            if(isValid(right[0], right[1], matrix))
            {
                if(matrix[curr[0]][curr[1]] <= matrix[right[0]][right[1]] && flowMatrix[right[0]][right[1]] == 0)
                {
                    q.add(new int[]{right[0], right[1]});
                    flowMatrix[right[0]][right[1]] = 1;
                }
            }
            if(isValid(down[0], down[1], matrix))
            {
                if(matrix[curr[0]][curr[1]] <= matrix[down[0]][down[1]] && flowMatrix[down[0]][down[1]] == 0)
                {
                    q.add(new int[]{down[0], down[1]});
                    flowMatrix[down[0]][down[1]] = 1;
                }
            }
        }
        
        for(int i = 0; i < flowMatrix[0].length; ++i)
        {
            flowMatrix[flowMatrix.length - 1][i] += 2;
            q.add(new int[]{flowMatrix.length - 1, i});
        }
        for(int i = 0; i < flowMatrix.length - 1; ++i)
        {
            flowMatrix[i][flowMatrix[0].length - 1] += 2;
            q.add(new int[]{i, flowMatrix[0].length - 1});
        }
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            if(flowMatrix[curr[0]][curr[1]] == 3)
            {
                List<Integer> ls = new ArrayList<>();
                ls.add(curr[0]);
                ls.add( curr[1]);
                fls.add(ls);
            }
            
            int[] up = new int[]{curr[0] -1, curr[1]};
            int[] left = new int[]{curr[0], curr[1] - 1};
            int[] right = new int[]{curr[0] , curr[1] + 1};
            int[] down = new int[]{curr[0] +1, curr[1]};
            
            if(isValid(up[0], up[1], matrix))
            {
                if(flowMatrix[up[0]][up[1]] != 2 && flowMatrix[up[0]][up[1]] != 3)
                {
                    if(matrix[up[0]][up[1]] >= matrix[curr[0]][curr[1]])
                    {
                        flowMatrix[up[0]][up[1]] += 2;
                        q.add(new int[]{up[0], up[1]});
                    }
                }
            }
            if(isValid(down[0], down[1], matrix))
            {
                if(flowMatrix[down[0]][down[1]] != 2 && flowMatrix[down[0]][down[1]] != 3)
                {
                    if(matrix[down[0]][down[1]] >= matrix[curr[0]][curr[1]])
                    {
                        flowMatrix[down[0]][down[1]] += 2;
                        q.add(new int[]{down[0], down[1]});
                    }
                }
            }
            if(isValid(left[0], left[1], matrix))
            {
                if(flowMatrix[left[0]][left[1]] != 2 && flowMatrix[left[0]][left[1]] != 3)
                {
                    if(matrix[left[0]][left[1]] >= matrix[curr[0]][curr[1]])
                    {
                        flowMatrix[left[0]][left[1]] += 2;
                        q.add(new int[]{left[0], left[1]});
                    }
                }
            }
            if(isValid(right[0], right[1], matrix))
            {
                if(flowMatrix[right[0]][right[1]] != 2 && flowMatrix[right[0]][right[1]] != 3)
                {
                    if(matrix[right[0]][right[1]] >= matrix[curr[0]][curr[1]])
                    {
                        flowMatrix[right[0]][right[1]] += 2;
                        q.add(new int[]{right[0], right[1]});
                    }
                }
            }
        }
        return fls;
    }
    
    boolean isValid(int i, int j, int[][] matrix)
    {
        if(i < 0 || j < 0 || i >= matrix.length ||j >= matrix[0].length)
        {
            return false;
        }
        return true;
    }
}
