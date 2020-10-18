
package leetcodesolutionsiii;
import java.util.*;

public class BeautifulArrangement526
{
    public int countArrangement(int n) 
    {
        if(n == 0)
            return 0;
        Set<Integer> ls = new HashSet<>();
        for (int i = 1; i <= n; i++)
        {
            ls.add(i);
        }
        
        return countHelper(ls, 1, n);
    }
    private int countHelper(Set<Integer> ls, int index, int n)
    {
        if(index > n)
        {
            return 1;
        }
        int count = 0;
        for(int i = 1; i <= n; ++i)
        {
            if(ls.contains(i) && (i % index == 0 || index % i == 0))
            {
                ls.remove(i);
                count += countHelper(ls, index + 1, n);
                ls.add(i);
            }
        }
        
        return count;
    }
}
