
package leetcodesolutionsiii;
import java.util.*;

public class FindDuplicateInFilesystem609
{
    public List<List<String>> findDuplicate(String[] paths) 
    {
        List<List<String>> fls = new ArrayList<>();
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String ip: paths)
        {
            String[] sp = ip.split(" ");
            for(int i = 1; i < sp.length; ++i)
            {
                int startIdx = sp[i].indexOf('(');
                StringBuilder sb = new StringBuilder(sp[0]);
                sb.append("/");
                if(startIdx != -1)
                {
                    int endIdx = sp[i].length() - 1;
                    String cont = sp[i].substring(startIdx + 1, endIdx);
                    String fileName =sp[i].substring(0, startIdx);
                    sb.append(fileName);
                    if(map.containsKey(cont))
                    {
                        map.get(cont).add(sb.toString());
                    }
                    else
                    {
                        List<String> ls = new ArrayList<>();
                        ls.add(sb.toString());
                        map.put(cont, ls);
                    }
                }
            }
        }
        for(String key: map.keySet())
        {
            if(map.get(key).size() > 1)
            fls.add(map.get(key));
        }
        return fls;
    }
}
