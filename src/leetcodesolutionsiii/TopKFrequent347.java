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
public class TopKFrequent347
{
    public int[] topKFrequent(int[] nums, int k) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i], 1);
            }
            else
            {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        PriorityQueue<Frequency> pq = new PriorityQueue<>(k, new FreqComp());
        for(int key: map.keySet())
        {
            int freq = -1 *map.get(key);
            Frequency temp = new Frequency(key, freq);
            
            pq.add(temp);
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        int[] res = new int[k];
        int j = 0;
        while(!pq.isEmpty())
        {
            res[j] = pq.poll().val;
            j++;
        }
        return res;
    }
}
class Frequency
{
    public int val;
    public int freq;
    public Frequency(int val, int freq)
    {
        this.val = val;
        this.freq = freq;
    }
}
class FreqComp implements Comparator<Frequency>
{
    public int compare(Frequency a, Frequency b)
    {
        if(a.freq < b.freq)
        {
            return 1;
        }
        else if (a.freq > b.freq)
        {
            return -1;
        }
        return 0;
    }
}
