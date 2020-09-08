
package leetcodesolutionsiii;
import java.util.*;

public class LexicalOrder386
{
    public List<Integer> lexicalOrder(int n) 
    {
        //HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        List<Integer> ls = new ArrayList<>();
        for(int i = 1; i <= n; ++i)
        {
            ls.add(i);
            
        }
        Collections.sort(ls,
                         new Comparator<Integer>()
                         {
                             public int compare(Integer a, Integer b)
                             {
                                 return Integer.toString(a).compareTo(Integer.toString(b));
                             }
                         }
                        );
        return ls;
    }
}
