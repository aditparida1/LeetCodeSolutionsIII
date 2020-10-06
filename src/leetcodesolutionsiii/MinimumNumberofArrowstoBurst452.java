
package leetcodesolutionsiii;
import java.util.*;

public class MinimumNumberofArrowstoBurst452
{
    public int findMinArrowShots(int[][] points) 
    {
        if(points == null)
        {
            return 0;
        }
        if(points.length <= 1)
        {
            return 1;
        }
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b)
            {
                if(a[0] < b[0])
                {
                    return -1;
                }
                else if(a[0] == b[0])
                {
                    if(a[1] <= b[1])
                    {
                        return -1;
                    }
                    else
                    {
                        return 1;
                    }
                }
                else
                {
                    return 1;
                }
            }
        });
        
        int total = 0;
        int[] interval = null;
        for(int i = 0; i < points.length; ++i)
        {
            if(interval == null)
            {
                interval = points[i];
            }
            int[] curr = points[i];
            
            if(isOverlapping(interval, curr))
            {
                interval[1] = interval[1] > curr[1] ? curr[1] : interval[1];
                interval[0] = interval[0] < curr[0] ? curr[0] : interval[0];
            }
            else
            {
                interval = curr;
                total++;
            }
        }
        total++;
        return 0;        
    }
    public boolean isOverlapping(int[] interval1, int[] interval2)
    {
        if(interval1[1] >= interval2[0])
        {
            return true;
        }
        return false;
    }
}
