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
public class LongestSubStringwithKrepeatingchars395
{
    public int longestSubstring(String s, int k) 
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            if(!map.containsKey(s.charAt(i)))
            map.put(s.charAt(i), 1);
            else
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        StringBuilder sb = new StringBuilder();
        boolean added = false;
        for(Character c: map.keySet())
        {
            if(map.get(c) < k)
            {
                if(!added)
                {
                    sb.append(c);
                    added = !added;
                }
                else
                {
                    sb.append("|");
                    sb.append(c);
                }
            }
        }
        String regex = sb.toString();
        if(regex.length() == 0)
        {
            return s.length();
        }
        String[] split = s.split(regex);
        int maxLen = 0;
        for(String sp: split)
        {
            if(sp.isEmpty())
                continue;
            int len = longestSubstring(sp, k);
            maxLen = maxLen < len ? len : maxLen;
        }
        return maxLen;
    }
}
