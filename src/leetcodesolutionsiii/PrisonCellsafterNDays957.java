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
public class PrisonCellsafterNDays957
{
    public int[] prisonAfterNDays(int[] cells, int N) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        
        
        int current = convertToBin(cells);
        map.put(current, index);
        while(N > 0)
        {
            N--;
            cells = flip(cells);
            current = convertToBin(cells);
            if(map.containsKey(current))
                break;
            index++;
            map.put(current, index);
        }
        if(N == 0)
        {
            return cells;
        }
        TreeMap<Integer, Integer> rev = new TreeMap<>();
        for(int key: map.keySet())
        {
            rev.put(map.get(key), key);
        }
        int currIdx = map.get(current);
        int cycle = index - currIdx + 1;
        N = N + 1;
        int res = N % cycle;
        int result;
        if(res == 0)
        {
            result = rev.get(index);
        }
        else
        {
            result = rev.get(currIdx + res - 1);
        }
        
        for(int i = 7; i >= 0; --i)
        {
            int bit = result % 2;
            result /= 2;
            cells[i] = bit;
        }
        return cells;
    }
    private int convertToBin(int[] cells)
    {
        int result = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cells.length; i++)
        {
            if(cells[i] == 0)
            {
                sb.append('0');
            }
            else
            {
                sb.append('1');
            }
        }
        result = Integer.parseInt(sb.toString(), 2);
        return result;
    }
    private int[] flip(int[] cells)
    {
        int[] res = new int[cells.length];
        for (int i = 0; i < cells.length; i++)
        {
            if(i == 0 || i == cells.length - 1)
            {
                res[i] = 0;
            }
            else if(cells[i - 1] == 0 && cells[i + 1] == 0)
            {
                res[i] = 1;
            }
            else if(cells[i - 1] == 1 && cells[i + 1] == 1)
            {
                res[i] = 1;
            }
            else
            {
                res[i] = 0;
            }
        }
        return res;
    }
}
