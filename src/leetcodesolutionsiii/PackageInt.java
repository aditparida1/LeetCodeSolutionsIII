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
public class PackageInt
{
    public int ret(int[] box, int[] unit, int truck)
    {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < box.length; i++)
        {
            if(!tm.containsKey(unit[i]))
            {
                tm.put(unit[i], box[i]);
            }
            else
            {
                tm.put(unit[i], tm.get(unit[i]) + box[i]);
            }
        }
        int totalbox = 0;
        int total = 0;
        for(int un: tm.descendingKeySet())
        {
            if(totalbox >= truck)
            {
                break;
            }
            if(totalbox + tm.get(un) > truck)
            {
                int newItems = truck - totalbox;
                total += newItems * un;
                totalbox += newItems;
            }
            else
            {
                int newItems = tm.get(un);
                total += newItems * un;
                totalbox += newItems;
            }
        }
        return total;
    }
}
