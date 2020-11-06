
package leetcodesolutionsiii;
import java.util.*;

public class MinimumFactorization625
{
    public int smallestFactorization(int a) 
    {
        if(a == 1)
            return 1;
        List<Integer> fls = new ArrayList<>();
        helperFindAllCombinations(a, 2, fls, new ArrayList<>());
        if(fls.size() == 0)
        {
            return 0;
        }
        Collections.sort(fls);
        return fls.get(0);
    }
    private void helperFindAllCombinations(int input, int curr, List<Integer> fls, List<String> ls)
    {
        if(input == 1)
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ls.size(); i++)
            {
                sb.append(ls.get(i));
            }
            try{
                int num = Integer.parseInt(sb.toString());
                fls.add(num);
            }
            catch(Exception ex)
            {
                return;
            }
        }
        else if(ls.size() > 9)
        {
            return;
        }
        for (int i = curr; i < 10; i++)
        {
            if(input % i == 0)
            {
                ls.add(Integer.toString(i));
                helperFindAllCombinations(input / i, i, fls, ls);
                ls.remove(ls.size() - 1);
            }
        }
    }
}
