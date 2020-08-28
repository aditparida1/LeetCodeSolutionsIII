
package leetcodesolutionsiii;
import java.util.*;

public class RangeAddition370
{
    public int[] getModifiedArray(int length, int[][] updates) 
    {
        int[] nums = new int[length];
        
        Arrays.sort(updates, new Comparator<int[]>()
                {
                    @Override
                    public int compare(int[] a, int[] b)
                    {
                        if(a[0] > b[0])
                            return 1;
                        else if(a[0] < b[0])
                            return -1;
                        else
                        {
                            if(a[1] > b[1])
                                return 1;
                            else
                                return -1;
                        }
                        //return 0;
                    }
                });
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>()
                {
                    @Override
                    public int compare(int[] a, int[] b)
                    {
                        if(a[0] > b[0])
                            return 1;
                        else if(a[0] < b[0])
                            return -1;
                        else
                        {
                            if(a[1] > b[1])
                                return 1;
                            else
                                return -1;
                        }
                        //return 0;
                    }
                });
        for (int i = 0; i < updates.length; i++)
        {
            int[] temp = new int[3];
            temp[0] = updates[i][0];
            temp[1] = updates[i][1];
            temp[2] = updates[i][2];
            pq.offer(temp);
        }
        while(!pq.isEmpty())
        {
            if(pq.size() >= 2)
            {
                int[] temp1 = pq.poll();
                int[] temp2 = pq.poll();
                if(temp1[0] == temp2[0] && temp1[1] == temp2[1])
                {
                    int[] temp3 = new int[]{temp1[0], temp1[1], temp1[2] + temp2[2]};
                    pq.add(temp3);
                }
                else if(isOverlapping(temp1, temp2))
                {
                    int[] fi = new int[]{temp1[0], temp2[0] -1, temp1[2]};
                    int[] si = new int[]{temp2[0], temp1[1], temp1[2] + temp2[2]};
                    int[] ti = new int[]{temp1[1] + 1, temp2[1], temp2[2]};
                    if(fi[0] <= fi[1])
                    {
                        pq.add(fi);
                    }
                    if(si[0] <= si[1])
                    {
                        pq.add(si);
                    }
                    if(ti[0] <= ti[1])
                    {
                        pq.add(ti);
                    }
                }
                else
                {
                    pq.add(temp2);
                    int start = temp1[0];
                    int end = temp1[1];
                    int inc = temp1[2];
                    for (int i = start; i <= end; i++)
                    {
                        nums[i] += inc;
                    }
                }
            }
            else
            {
                int[] temp = pq.poll();
                int start = temp[0];
                int end = temp[1];
                int inc = temp[2];
                for (int i = start; i <= end; i++)
                {
                    nums[i] += inc;
                }
            }
        }
        return nums;        
    }
    public boolean isOverlapping(int[] a, int[] b)
    {
        if(b[0] >= a[0] && b[0] <= a[0])
        {
            return true;
        }
        return false;
    }
}
