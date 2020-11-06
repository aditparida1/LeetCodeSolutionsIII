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
public class CircularQueue622
{
    private int[] queue;
    private int front;
    private int back;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public CircularQueue622(int k) 
    {
        queue = new int[k];
        front = -1;
        back = -1;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull())
        {
            return false;
        }
        if(isEmpty())
        {
            front = 0;
        }
        back = increaseOneStep(back);
        queue[back] = value;
        
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty())
        {
            return false;
        }
        if(front == back)
        {
            front = back = -1;
        }
        else
        {
            front = increaseOneStep(front);
        }
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
         return queue[front];
        //return 1;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        return queue[back];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(queue.length == 0)
        {
            return true;
        }
        if(front == back && front == -1)
        {
            return true;
        }
        return false;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(queue.length == 0)
        {
            return true;
        }
        if(increaseOneStep(back) == front)
        {
            return true;
        }
        return false;
    }
    private int increaseOneStep(int index)
    {
        int i = index + 1;
        if(i >= queue.length)
        {
            i = 0;
        }
        return i;
    }
    private int decreaseoneStep(int index)
    {
        int i = index - 1;
        if(i < 0)
        {
            i = queue.length - 1;
        }
        return i;
    }
}
