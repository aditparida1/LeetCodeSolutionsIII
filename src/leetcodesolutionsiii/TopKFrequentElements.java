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
public class TopKFrequentElements
{
    public int[] topKFrequent(int[] nums, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
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
        return null;
    }
}
