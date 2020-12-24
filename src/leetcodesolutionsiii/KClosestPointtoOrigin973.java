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
public class KClosestPointtoOrigin973
{
    public int[][] kClosest(int[][] points, int K) 
    {
        if(points == null || points.length == 0 || K ==0)
        {
            return new int[0][2];
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new PointsComparator());
        for (int i = 0; i < points.length; i++)
        {
            pq.add(points[i]);
            if(pq.size() > K)
            {
                pq.poll();
            }
        }
        int[][] res = new int[pq.size()][2];
        int i = 0;
        while(!pq.isEmpty())
        {
            res[i] = pq.poll();
            i++;
        }
        return res;
    }
}
class PointsComparator implements Comparator<int[]>
{

    @Override
    public int compare(int[] o1, int[] o2)
    {
        int o1Dist = distanceFromOrigin(o1);
        int o2Dist = distanceFromOrigin(o2);
        if(o1Dist < o2Dist)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
    int distanceFromOrigin(int[] point)
    {
        return (int)(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}
