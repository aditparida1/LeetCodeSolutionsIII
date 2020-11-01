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
public class TaskScheduler621
{
    public int leastInterval(char[] tasks, int n) 
    {
        if(tasks == null)
        {
            return 0;
        }
        if(n == 0)
        {
            return tasks.length;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < tasks.length; i++)
        {
            if(map.containsKey(tasks[i]))
            {
                map.put(tasks[i], map.get(tasks[i]) + 1);
            }
            else
            {
                map.put(tasks[i], 1);
            }
        }
        
        return 0;
    }
}
