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
public class LargestNumber179
{
    public String largestNumber(int[] nums) 
    {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < 10; ++i)
        {
            map.put(Integer.toString(i), new ArrayList<String>());
        }
        for (int i = 0; i < nums.length; i++)
        {
            String num = Integer.toString(nums[i]);
            map.get(Character.toString( num.charAt(0))).add(num);
        }
        for (String key : map.keySet())
        {
            List<String> ls = map.get(key);
            Collections.sort(ls, new Comp());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0 ; i--)
        {
            List<String> ls = map.get(Integer.toString(i));
            for (int j = 0; j < ls.size(); j++)
            {
                sb.append(ls.get(j));
            }
        }
        int start = sb.length();
        for(int i = 0; i < sb.length(); ++i)
        {
            if(sb.charAt(i) != '0')
            {
                start = i;
                break;
            }
        }
        if(start == sb.length())
        {
            return "0";
        }
        return sb.toString().substring(start, sb.length());    
    }
    
}
class Comp implements Comparator<String>
    {

        @Override
        public int compare(String o1, String o2)
        {
            String res1 = o1 + o2;
            String res2 = o2 + o1;
            return -1 * res1.compareTo(res2);
        }
        
    }
