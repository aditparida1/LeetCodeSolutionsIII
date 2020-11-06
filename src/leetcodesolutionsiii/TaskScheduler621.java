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
        int[] freq = new int[26];
        for (int i = 0; i < tasks.length; i++)
        {
            freq[tasks[i] - 65] += 1;
        }
        Arrays.sort(freq);
        
        int addedGaps = (freq[freq.length - 1] - 1) * n;
        
        for(int i = freq.length - 2; i >= 0 && addedGaps > 0; --i)
        {
            addedGaps -= Math.min(freq[i] - 1, addedGaps);
        }
        addedGaps = Math.min(addedGaps, 0);
        return tasks.length + addedGaps;
    }
}
