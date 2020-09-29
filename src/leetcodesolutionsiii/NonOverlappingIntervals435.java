
package leetcodesolutionsiii;
import java.util.*;

public class NonOverlappingIntervals435
{
    public int eraseOverlapIntervals(int[][] intervals) 
    {
        if(intervals.length <= 1)
        {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>()
        {
            public int compare(int[] a , int[] b)
            {
                if(a[0] < b[0])
                {
                    return -1;
                }
                else if(a[0] > b[0])
                {
                    return 1;
                }
                else
                {
                    if(a[1] < b[1])
                    {
                        return -1;
                    }
                    else if(a[1] > b[1])
                    {
                        return 1;
                    }
                    else
                    {
                        return 0;
                    }
                }
            }
        });
        int res = 0;
        int prev = 0;
        for(int i = 1; i < intervals.length; ++i)
        {
            if(isOverlapping(intervals[prev], intervals[i]))
            {
                if(intervals[prev][1] > intervals[i][1])
                {
                    prev = i;
                }
                res++;
            }
            else
            {
                prev = i;
            }
        }
        return res;
        
    }
    public boolean isOverlapping(int[] a, int[] b)
    {
        if(b[0] < a[1])
        {
            return true;
        }
        return false;
    }
}
