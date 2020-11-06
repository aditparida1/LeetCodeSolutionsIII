
package leetcodesolutionsiii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class MaxDistanceinArrays624
{
    public int maxDistance(List<List<Integer>> arrays) 
    {
        if(arrays == null)
        {
            return 0;
        }
        List<Integer> fls = new ArrayList<>();
        for(List<Integer> ls : arrays)
        {
            for(int i: ls)
            {
                fls.add(i);
            }
        }
        Collections.sort(fls);
        
        
        return fls.get(fls.size() - 1) - fls.get(0);
    }

}
