
package leetcodesolutionsiii;
import java.util.*;
public class LeetCodeSolutionsIII
{

    public static void main(String[] args)
    {
        String s = "3[a]2[bc]";
        String[] split = s.split("[\\[\\]]");
        for(String ip : split)
        {
            System.out.println(ip);
        }
        //return null;
    }
    
}
