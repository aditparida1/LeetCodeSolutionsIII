
package leetcodesolutionsiii;
import java.util.*;
public class LeetCodeSolutionsIII
{
    public static void main(String[] args)
    {
        int[] arr = {14,10,5,1,0};
        //System.out.println(search(6, arr));
//        System.out.println(new LongestUnivaluePath687().longestUnivaluePath(root));
        System.out.println(solution(arr));
    }
    public static int solution(int[] A) 
    {

    Arrays.sort(A);
    if(A.length <= 4)
      return 0;
    int min = Integer.MAX_VALUE;
    for(int i =0; i < 4; ++i)
    {
       min = Math.min(min, A[A.length - 3 + i -1] - A[i]);
    }
    return min;
    }
}