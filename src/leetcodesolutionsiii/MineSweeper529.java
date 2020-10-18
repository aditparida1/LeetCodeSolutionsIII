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
public class MineSweeper529
{
    public char[][] updateBoard(char[][] board, int[] click) 
    {
        if(board == null || board.length == 0 || board[0].length == 0)
        {
            return board;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
//        for (int i = 0; i < board.length; i++)
//        {
//            for (int j = 0; j < board[0].length; j++)
//            {
//                visited[i][j] = false;
//            }
//        }
        //Arrays.fill(board, false);
        Queue<int[]> q = new LinkedList<>();
        
        if(board[click[0]][click[1]] == 'M')
        {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        visited[click[0]][click[1]] = true;
        q.add(click);
        
        while(!q.isEmpty())
        {
            int[] pos = q.poll();
            
            //4 different directions
            //8 total directions to check for mines
            int count = 0;
            if(isValid(board, pos[0] - 1, pos[1] - 1))
            {
                if(board[pos[0] - 1][pos[1] - 1] == 'M')
                {
                    count++;
                }
            }
            if(isValid(board, pos[0] + 1, pos[1] + 1))
            {
                if(board[pos[0] + 1][pos[1] + 1] == 'M')
                {
                    count++;
                }
            }
            if(isValid(board, pos[0] - 1, pos[1] + 1))
            {
                if(board[pos[0] - 1][pos[1] + 1] == 'M')
                {
                    count++;
                }
            }
            if(isValid(board, pos[0] + 1, pos[1] - 1))
            {
                if(board[pos[0] + 1][pos[1] - 1] == 'M')
                {
                    count++;
                }
            }
            
            if(isValid(board, pos[0] - 1, pos[1]))
            {
                if(board[pos[0] - 1][pos[1]] == 'M')
                {
                    count++;
                }                
            }
            
            if(isValid(board, pos[0] + 1, pos[1]))
            {
                if(board[pos[0] + 1][pos[1]] == 'M')
                {
                    count++;
                }
                
            }
            
            if(isValid(board, pos[0], pos[1] - 1))
            {
                if(board[pos[0]][pos[1] - 1] == 'M')
                {
                    count++;
                }
                
            }
            if(isValid(board, pos[0], pos[1] + 1))
            {
                if(board[pos[0]][pos[1] + 1] == 'M')
                {
                    count++;
                }
            }
            if(count  == 0)
            {
                board[pos[0]][pos[1]] = 'B';
                if(isValid(board, pos[0], pos[1] + 1))
                {
                    if(!visited[pos[0]][pos[1] + 1])
                    {
                        visited[pos[0]][pos[1] + 1] = true;
                        q.add(new int[]{pos[0], pos[1] + 1});
                    }
                }
                if(isValid(board, pos[0], pos[1] - 1))
                {
                    if(!visited[pos[0]][pos[1] - 1])
                    {
                        visited[pos[0]][pos[1] - 1] = true;
                        q.add(new int[]{pos[0], pos[1] - 1});
                    }
                }
                if(isValid(board, pos[0] - 1, pos[1]))
                {
                    if(!visited[pos[0] - 1][pos[1]])
                    {
                        visited[pos[0] - 1][pos[1]] = true;
                        q.add(new int[]{pos[0] - 1, pos[1]});
                    }
                }
                if(isValid(board, pos[0] + 1, pos[1]))
                {
                    if(!visited[pos[0] + 1][pos[1]])
                    {
                        visited[pos[0] + 1][pos[1]] = true;
                        q.add(new int[]{pos[0] + 1, pos[1]});
                    }
                }
                if(isValid(board, pos[0] - 1, pos[1] - 1))
                {
                    if(!visited[pos[0] - 1][pos[1] - 1])
                    {
                        visited[pos[0] - 1][pos[1] - 1] = true;
                        q.add(new int[]{pos[0] - 1, pos[1] - 1});
                    }
                }
                if(isValid(board, pos[0] + 1, pos[1] + 1))
                {
                    if(!visited[pos[0] + 1][pos[1] + 1])
                    {
                        visited[pos[0] + 1][pos[1] + 1] = true;
                        q.add(new int[]{pos[0] + 1, pos[1] + 1});
                    }
                }
                if(isValid(board, pos[0] - 1, pos[1] + 1))
                {
                    if(!visited[pos[0] - 1][pos[1] + 1])
                    {
                        visited[pos[0] - 1][pos[1] + 1] = true;
                        q.add(new int[]{pos[0] - 1, pos[1] + 1});
                    }
                }
                if(isValid(board, pos[0] + 1, pos[1] - 1))
                {
                    if(!visited[pos[0] + 1][pos[1] - 1])
                    {
                        visited[pos[0] + 1][pos[1] - 1] = true;
                        q.add(new int[]{pos[0] + 1, pos[1] - 1});
                    }
                }
            }
            else
            {
                board[pos[0]][pos[1]] = (char)((int)'0' + count);
            }
            
        }
        
        
        return board;
    }
    public boolean isValid(char[][] board, int i, int j)
    {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length)
        {
            return false;
        }
        return true;
    }
}
