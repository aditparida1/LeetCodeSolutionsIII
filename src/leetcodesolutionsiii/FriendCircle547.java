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
public class FriendCircle547
{
    public int findCircleNum(int[][] M) 
    {
        int[][] ip = M;
        int total = 0;
        boolean[] visited = new boolean[ip.length];
        //Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < ip.length; i++)
        {
            if(!visited[i])
            {
                q.add(i);
                visited[i] = true;
                while(!q.isEmpty())
                {
                    int curr = q.poll();
                    
                    for (int j = 0; j < ip.length; j++)
                    {
                        if(!visited[j] && ip[curr][j] == 1)
                        {
                            q.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
            total++;
        }
        
        return total;
        
    }
    public int findCircleNumUF(int[][] M) 
    {
        int[][] ip = M;
        int[] uf = new int[ip.length];
        int total = 0;
        
        for (int i = 0; i < ip.length; i++)
        {
            boolean isUpdated = false;
            for (int j = 0; j < i; j++)
            {
                if(ip[i][j] == 1)
                {
                    isUpdated = true;
                    break;
                }
            }
            if(!isUpdated)
            {
                uf[i] = i;
                total++;
            }
            for (int j = i + 1; j < ip.length; j++)
            {
                if(ip[i][j] == 1)
                {
                    uf[j] = i;
                }
            }
        }
        
        return total;
    }
}
