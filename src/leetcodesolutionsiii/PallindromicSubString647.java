
package leetcodesolutionsiii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class PallindromicSubString647
{
    public int countSubstrings(String s) 
    {
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        int[][] dpMat = new int[s.length()][s.length()];
        int count = 0;
        for (int i = 0; i < dpMat.length; i++)
        {
            dpMat[i][i] = 1;
            count++;
        }
        
        for (int i = 0; i < dpMat.length - 1; i++)
        {
            if(s.charAt(i) == s.charAt(i + 1))
            {
                dpMat[i][i + 1] = 1;
                count++;
            }
        }
        
        for(int size = 3; size <= s.length(); ++size)
        {
            boolean isChanged = false;
            for (int i = 0; i <= s.length() - size; i++)
            {
                int j = i + size - 1;
                if(s.charAt(i) == s.charAt(j) && dpMat[i + 1][j - 1] == 1)
                {
                    count++;
                    dpMat[i][j] = 1;
                    isChanged = true;
                }
            }
            if(!isChanged)
                break;
        }
        
        return count;
    }
}
