
package leetcodesolutionsiii;
import java.util.*;


public class FindRightInterval436
{
    public int[] findRightInterval(int[][] intervals) 
    {
        if(intervals == null || intervals.length == 0)
        {
            return new int[]{};
        }
        
        if(intervals.length == 1)
        {
            return new int[]{-1};
        }
        int[][] newInterval = new int[intervals.length][3];
        for (int i = 0; i < intervals.length; i++)
        {
            newInterval[i][0] = intervals[i][0];
            newInterval[i][1] = intervals[i][1];
            newInterval[i][2] = i;
        }
        Arrays.sort(newInterval, new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b)
            {
                if(a[0] < b[0])
                {
                    return -1;
                }
                else if (a[0] == b[0])
                {
                    if(a[1] < b[1])
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
        }
        );
        int[] res = new int[newInterval.length];
        for (int i = 0; i < newInterval.length; i++)
        {
            int idx = -1;
            for (int j =  i + 1; j < newInterval.length; j++)
            {
                if(newInterval[j][0] >= newInterval[i][1])
                {
                    idx = newInterval[j][2];
                    break;
                }
            }
            res[newInterval[i][2]] = idx;
        }
        return res;
    }
}
