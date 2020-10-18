

package leetcodesolutionsiii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class TheMaze494
{
    public boolean hasPath(int[][] maze, int[] start, int[] destination) 
    {
        if(maze == null || maze.length == 0 || maze[0].length == 0)
        {
            return false;
        }
        if(start[0] == destination[0] && start[1] == destination[1])
        {
            return true;
        }
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        String[] dirs = {"up", "down", "left", "right"};
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            
            if(curr[0] == destination[0] && curr[1] == destination[1])
            {
                return true;
            }
            
            for(String dir: dirs)
            {
                int[] dirXY = new int[2];
                if(dir.equals("up"))
                {
                    dirXY[0] = 0;
                    dirXY[1] = -1;        
                }
                else if(dir.equals("down"))
                {
                    dirXY[0] = 0;
                    dirXY[1] = 1;
                }
                else if(dir.equals("left"))
                {
                    dirXY[0] = -1;
                    dirXY[1] = 0;
                }
                else
                {
                    dirXY[0] = 1;
                    dirXY[1] = 0;
                }
                int[] temp = {curr[0], curr[1]};
                travelDir(temp, dir, maze);
                int[] res = {temp[0] - dirXY[0], temp[1] - dirXY[1]};
                if(res[0] == destination[0] && res[1] == destination[1])
                {
                    return true;
                }
                if(!visited[res[0]][res[1]])
                {
                    q.add(res);
                    visited[res[0]][res[1]] = true;
                }
            }
        }
        return false;        
    }
    public void travelDir(int[] pos, String dir, int[][] mat)
    {
        int[] dirXY = new int[2];
        if(dir.equals("up"))
        {
            dirXY[0] = 0;
            dirXY[1] = -1;        
        }
        else if(dir.equals("down"))
        {
            dirXY[0] = 0;
            dirXY[1] = 1;
        }
        else if(dir.equals("left"))
        {
            dirXY[0] = -1;
            dirXY[1] = 0;
        }
        else
        {
            dirXY[0] = 1;
            dirXY[1] = 0;
        }
        while(pos[0] >= 0 && pos[1] >= 0 && pos[0] < mat.length && pos[0] < mat[0].length && mat[pos[0]][pos[1]] != 1)
        {
            pos[0] += dirXY[0];
            pos[1] += dirXY[1];
        }
    }
}
