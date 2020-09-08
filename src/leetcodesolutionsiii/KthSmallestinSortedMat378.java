
package leetcodesolutionsiii;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestinSortedMat378
{
    public int kthSmallest(int[][] matrix, int k) 
    {
        boolean[][] visited = new boolean[matrix.length][matrix.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
        new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b)
            {
                if(matrix[a[0]][a[1]] > matrix[b[0]][b[1]])
                {
                    return 1;
                }
                else if(matrix[a[0]][a[1]] < matrix[b[0]][b[1]])
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }
        }
        );
        int count = 0;
        int currElem = -1;
        pq.add(new int[]{0,0});
        visited[0][0] = true;
        while(count < k)
        {
            int[] currPos = pq.poll();
            
            int[] neighLeft = new int[2];
            neighLeft[0] = currPos[0];
            neighLeft[1] = currPos[1] + 1;
            
            int[] neighRight = new int[2];
            neighRight[0] = currPos[0] + 1;
            neighRight[1] = currPos[1];
            
            if(isValid(neighLeft[0], neighLeft[1], matrix) && !visited[neighLeft[0]][neighLeft[1]])
            {
                pq.add(neighLeft);
                visited[neighLeft[0]][neighLeft[1]] = true;
            }
            if(isValid(neighRight[0], neighRight[1], matrix) && !visited[neighRight[0]][neighRight[1]])
            {
                pq.add(neighRight);
                visited[neighRight[0]][neighRight[1]] = true;
            }
            
            currElem = matrix[currPos[0]][currPos[1]];
            count++;
        }
        return currElem;
    }
    public boolean isValid(int i, int j, int[][] matrix)
    {
        if(i < matrix.length && i >= 0 && j < matrix.length && j >= 0)
        {
            return true;
        }
        return false;
    }
    
}
