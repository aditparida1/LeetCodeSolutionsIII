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
public class TopKFrequentWords692
{
    public List<String> topKFrequent(String[] words, int k) 
    {
        HashMap<String, Integer> map = new HashMap<>();
        
        for( int i = 0; i < words.length; ++i)
        {
            if(!map.containsKey(words[i]))
            {
                map.put(words[i], 1);
            }
            else
            {
                map.put(words[i], map.get(words[i]) + 1);
            }
        }
        List<String> ls = new ArrayList<>();
        for(String key: map.keySet())
        {
            ls.add(key);
        }
        Collections.sort(ls, new Comparator<String>(){
           public int compare(String a, String b)
           {
               if(map.get(a) < map.get(b))
               {
                   return 1;
               }
               else if(map.get(a) > map.get(b))
               {
                   return -1;
               }
               else
               {
                   return a.compareTo(b);
               }
           }
        });
        List<String> fls = new ArrayList<>();
        for(int i = 0; i < k; ++i)
        {
            fls.add(ls.get(i));
        }
        return fls;
    }
}
