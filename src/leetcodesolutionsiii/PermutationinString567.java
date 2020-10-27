
package leetcodesolutionsiii;

import java.util.Arrays;


public class PermutationinString567
{
    public boolean checkInclusion(String s1, String s2) 
    {
        char[] s1Char =  s1.toCharArray();
        Arrays.sort(s1Char);
        s1 = new String(s1Char);
        
        for (int i = 0; i <= s2.length() - s1.length(); i++)
        {
            String temp = s2.substring(i, i + s1.length());
            char[] tempChar = temp.toCharArray();
            Arrays.sort(tempChar);
            temp = new String(tempChar);
            if(temp.equals(s1))
            {
                return true;
            }
        }
        
        return false;
    }
}
