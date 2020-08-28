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
public class KPairsWithSmallest373
{
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) 
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b)
            {
                if(nums1[a[0]] + nums2[a[1]] < nums1[b[0]] + nums2[b[1]])
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
                //return 0;
            }
        });
        for (int i = 0; i < nums1.length; i++)
        {
            for (int j = 0; j < nums2.length; j++)
            {
                int[] toAdd = new int[] {i, j};
                pq.add(toAdd);
                int[] discard = null;
                if(pq.size() > k)
                {
                    discard = pq.poll();
                }
                if(toAdd == discard)
                {
                    break;
                }
            }
        }
        List<List<Integer>> ls  = new ArrayList<>();
        while(!pq.isEmpty())
        {
            int[] temp = pq.poll();
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[temp[0]]);
            pair.add(nums2[temp[1]]);
            ls.add(pair);
        }
        return ls;   
    }
}
