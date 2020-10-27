
package leetcodesolutionsiii;



public class ValidSquare593
{
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) 
    {
        int[][] arr = new int[][]{p1, p2, p3, p4};
        return permute(arr, 0);
    }
    
    public boolean permute(int[][] points, int idx)
    {
        if(idx >= points.length)
        {
            return isPossible(points);
        }
        
        for (int i = idx; i < points.length; i++)
        {
            swap(points, idx, i);
            boolean isPoss = permute(points, idx + 1);
            if(isPoss)
                return true;
            swap(points, idx, i);            
        }
        return false;
    }
    public void swap(int[][] points, int i, int idx)
    {
        int[] temp = points[i];
        points[i] = points[idx];
        points[idx] = temp;
    }
    public float getDistance(int[] p1, int[] p2)
    {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }
    public boolean isPossible(int[][] points)
    {      
        float side1 = getDistance(points[0], points[1]);
        float side2 = getDistance(points[1], points[2]);
        float side3 = getDistance(points[2], points[3]);
        float side4 = getDistance(points[0], points[3]);
        
        if(side1 != side2 || side2 != side3 || side3 != side4 || side4 != side1)
        {
            return false;
        }
        float diagonal1 = getDistance(points[0], points[2]);
        float diagonal2 = getDistance(points[1], points[3]);
        if(diagonal1 ==  side1 || diagonal2 == side1)
        {
            return false;
        }
        if(diagonal1 != diagonal2 && diagonal1 != 2 * side1)
        {
            return false;
        }
        
        return true;
    }
}
