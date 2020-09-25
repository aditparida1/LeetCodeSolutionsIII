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
public class Compa
{
    public  List<Integer> getUnallottedUsers(List<List<Integer>> bids, int totalShares) {
    // Write your code here
        int[][] mat = new int[bids.size()][4];
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < bids.size(); ++i)
        {
            List<Integer> curr = bids.get(i);
            set.add(i);
            for(int j = 0; j < 4; ++j)
            {
                mat[i][j] = curr.get(j);
            }
        }

        Arrays.sort(mat, new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b)
            {
                if(a[2] < b[2])
                {
                    return 1;
                }
                else if(a[2] == b[2])
                {
                    if(a[3] > b[3])
                    {
                        return 1;
                    }
                    else if(a[3] < b[3])
                    {
                        return -1;
                    }
                    else{
                        return 0;
                    }
                }
                else
                {
                    return -1;
                }
            }
        });
        int i = 0;
        while(totalShares != 0 && i <mat.length)
        {
            int j = i + 1;
            for(; j < mat.length; ++j)
            {
                if(mat[j][2] != mat[j - 1][2])
                {
                    break;
                }
            }
            j--;
            if(i == j)
            {
                if(mat[i][1] <= totalShares)
                {
                    totalShares -= mat[i][1];
                }
                else{
                    totalShares = 0;
                }
                mat[i][1] = 0;
                set.remove(i);
            }
            else
            {
                int k = i;
                boolean updatesMade = false;
                while(totalShares != 0)
                {
                    for(k = i; k <= j && totalShares!=0; ++k)
                    {
                        if(mat[k][1] > 0)
                        {
                            mat[k][1]--;
                            totalShares--;
                            updatesMade = true;
                            if(set.contains(k))
                            {
                                set.remove(k);
                            }
                        }
                    }
                    if(!updatesMade)
                    {
                        break;
                    }
                }
            }
            i = j + 1;
        }
        List<Integer> ls = new ArrayList<>();
        for(int k : set)
        {
            ls.add(k);
        }
        Collections.sort(ls);
        return ls;
    }
}
