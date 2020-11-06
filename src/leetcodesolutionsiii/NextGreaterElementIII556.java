
package leetcodesolutionsiii;
import java.util.*;

public class NextGreaterElementIII556
{
    public int nextGreaterElement(int n) 
    {
        char[] input = Integer.toString(n).toCharArray();
        
        int pivot;
        for(pivot = input.length - 2; pivot >= 0; --pivot)
        {
            if(input[pivot] < input[pivot + 1])
            {
                break;
            }
        }
        if(pivot < 0)
        {
            return -1;
        }
        int swapIdx = pivot + 1;
        for(int i = pivot + 1; i < input.length; ++ i)
        {
            if(input[i] < input[swapIdx] && input[pivot] < input[i])
            {
                swapIdx = i;
            }
        }
        char temp = input[pivot];
        input[pivot] = input[swapIdx];
        input[swapIdx] = temp;
        String output = new String(input);
        
        StringBuilder sb = new StringBuilder(output.substring(0, pivot + 1));
        input = output.substring(pivot + 1).toCharArray();
        Arrays.sort(input);
        sb.append(new String(input));
        String s = sb.toString();
        int val = -1;
        try
        {
            val = Integer.parseInt(s);
        }
        catch(Exception ex)
        {

        }
        
        return val;
    }
}
