/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsiii;

/**
 *
 * @author aditp
 */
public class Interview1
{
    public int[] solution(int[] a, int f , int m)
    {
        if(f<0 || m <1 || m > 6)
            return new int[]{0};
        int n = a.length;
        int total = n + f;
        int sum  = 0;
        for(int i : a)
        {
            sum += i;
        }
        int missedsum = total * m  - sum;
        if(missedsum <= 0)
        {
            return new int[]{0};
        }
        if(Math.ceil(missedsum / f) > 6)
        {
            return new int[]{0};
        }
        int[] arr = new int[f];
        int part = missedsum/f;
        int i = 0;
        while(missedsum - part >= part)
        {
            arr[i] = part;
            i++;
            missedsum -= part;
        }
        arr[i] = missedsum;
        return arr;
    }
}
