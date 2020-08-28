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
public class DiagonalMatrixSortingInt
{
    public void getDiagonals(String[][] matrix)
    {
        int n = matrix.length;
        //int col = matrix[0].length - 1;
        int count = 1;
        int row = n - 1;
        int col = 0;
        while(count < n * 2 - 1)
        {
            //List<String> ls = new ArrayList<String>();
        }
    }
    
    public List<Integer> getResults(int[] a, int[] b, List<int[]> ls)
    {
        List<Integer> res = new ArrayList<Integer>();
        boolean f = false;
        if(a.length > b.length)
        {
            int[] temp = b;
            b = a;
            a = b;
            f = true;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < b.length; ++i)
        {
            if(map.containsKey(b[i]))
            {
                map.put(b[i], 1);
            }
            else
            {
                map.put(b[i], map.get(b[i]) + 1);
            }
        }
        for (int i = 0; i < ls.size(); i++)
        {
            int[] arr = ls.get(i);
            if(arr.length == 3)
            {
                if(!f)
                {
                    int temp = b[arr[1]];
                    map.put(temp, map.get(temp) - 1);
                    
                    b[arr[1]] = arr[2];
                    if(map.containsKey(arr[2]))
                    {
                        map.put(arr[2], map.get(arr[2]) + 1);
                    }
                    else
                    {
                        map.put(arr[2], 1);
                    }
                }
                else
                {
                    a[arr[1]] = arr[2];
                }
            }
            else
            {
                int sum = arr[1];
                int total = 0;
                for (int j = 0; j < a.length; j++)
                {
                    int rem = sum - a[j];
                    if(map.containsKey(rem))
                    {
                        total += map.get(rem);
                    }
                }
                res.add(total);
            }
            
        }
        return res;
    }
}
