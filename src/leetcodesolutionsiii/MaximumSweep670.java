
package leetcodesolutionsiii;
import java.util.*;



public class MaximumSweep670
{
    public int maximumSwap(int num) 
    {
        char[] input = Integer.toString(num).toCharArray();
        char[] largest = new char[input.length];
        if(input.length == 1)
        {
            return num;
        }
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < input.length; i++)
        {
            if(map.containsKey(input[i]))
            {
                map.get(input[i]).add(i);
            }
            else
            {
                var ls = new ArrayList<Integer>();
                ls.add(i);
                map.put(input[i], ls);
            }
        }
        largest[largest.length - 1] = input[input.length - 1];
        for(int i = input.length - 2; i >= 0; --i)
        {
            if(input[i] > largest[i + 1])
            {
                largest[i] = input[i];
            }
            else
            {
                largest[i] = largest[i + 1];
            }
        }
        int result = -1;
        for(int i = 0; i < input.length - 1; ++i)
        {
            if(input[i] < largest[i + 1])
            {
                var ls = map.get(largest[i + 1]);
                for(int idx: ls)
                {
                    if(idx > i)
                    {
                        swap(input, idx, i);
                        result = Math.max(result, Integer.parseInt(new String(input)));
                        swap(input, idx, i);
                        
                    }
                }
                break;
            }
        }
        return result == -1? num : result;        
    }
    private void swap(char[] input, int i, int j)
    {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
