
package leetcodesolutionsiii;
import java.util.*;


public class BinaryWatch401
{
    public List<String> readBinaryWatch(int num) 
    {
        if(num > 8)
        {
            return new ArrayList<String>();
        }
        int fr = 0, sr = 0;
        if(num < 4)
        {
            fr = num;
        }
        else
        {
            fr = 3;
            sr = num - fr;
        }
        List<String> timeLs = new ArrayList<>();
        boolean isPoss = true;
        while(isPoss)
        {
            List<Integer> hr = new ArrayList<>();
            List<Integer> min = new ArrayList<>();
            createCombinations(4, 0, fr, 0, hr);
            createCombinations(6, 0, sr, 0, min);
            createTime(hr, min, timeLs);
            fr--;
            sr++;
            if(fr <= 0)
            {
                isPoss = false;
            }
            if(sr >= 6)
            {
                isPoss = false;
            }
        }
        return timeLs;
    }
    public void createCombinations(int numberOfPlace, int currentPlace, int remaining, int total, List<Integer> ls)
    {
        if(remaining == 0)
        {
            if(numberOfPlace == 4)
            {
                if(total <= 11)
                {
                    ls.add(total);                    
                }
            }
            if(numberOfPlace == 6)
            {
                if(total <= 59)
                {
                    ls.add(total);
                }
            }
            return;
        }
        if(currentPlace >= numberOfPlace)
        {
            return;
        }
        createCombinations(numberOfPlace, currentPlace + 1, remaining - 1, total + (int)Math.pow(2, numberOfPlace - currentPlace - 1), ls);
        createCombinations(numberOfPlace, currentPlace + 1, remaining, total, ls);
    }
    public void createTime(List<Integer> hr, List<Integer> min, List<String> timeLs)
    {
        for (int i = 0; i < hr.size(); i++)
        {
            String hourStr = Integer.toString(hr.get(i));
            for (int j = 0; j < min.size(); j++)
            {
               int minute = min.get(j);
               
               if(minute < 10)
               {
                   String minStr = "0" + Integer.toString(minute);
                   timeLs.add(hourStr + ":" + minStr);
               }
               else
               {
                   String minStr = Integer.toString(minute);
                   timeLs.add(hourStr + ":" + minStr);
               }
            }
        }
    }
}
