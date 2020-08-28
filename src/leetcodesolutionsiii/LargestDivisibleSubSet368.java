
package leetcodesolutionsiii;
import java.util.*;


public class LargestDivisibleSubSet368
{
    public List<Integer> largestDivisibleSubset(int[] nums) 
    {
        
        if(nums.length == 0)
        {
            return new ArrayList<>();
        }
        List<Integer>[] ls = new ArrayList[nums.length];
        for(int i = 0; i<  nums.length; ++i)
        {
            ls[i] = new ArrayList<Integer>();
        }
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++)
        {
            List<Integer> temp = new ArrayList<>();
            
            for (int j = 0; j < i; j++)
            {
                if(nums[i] % nums[j] == 0 && temp.size() < ls[j].size())
                {
                    temp = ls[j];
                }
            }
            ls[i].addAll(temp);
            ls[i].add(nums[i]);
        }
        
        List<Integer> fin = new ArrayList<>();
        for (int i = 0; i < ls.length; i++)
        {
            if(ls[i].size() > fin.size())
            {
                fin = ls[i];
            }
        }
        return fin;
    }
}
