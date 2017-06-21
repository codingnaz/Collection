package TheQueue;

import java.util.Arrays;

/**
 * Created by SAimon22 on 6/18/2017.
 */
public class TheQueue {
    private String[] queueArray;
    private int queueSize, front, rear, numberOfItems=0;

    TheQueue(int size){
        queueSize= size;
        queueArray= new String[size];
        Arrays.fill(queueArray,-1);
    }
    public void enqQueue(String input)throws TheQueueOutOfBoundsExceptions{
        if(numberOfItems+1<= queueSize){
            queueArray[rear]=input;
            rear++;
            numberOfItems++;

        }else {
            throw new TheQueueOutOfBoundsExceptions("Queue is full");
        }
    }
    public void dequeue() throws TheQueueOutOfBoundsExceptions{
        if (numberOfItems>0){
            queueArray[front]="-1";
            front++;
            numberOfItems--;
        }
        else {
            throw new TheQueueOutOfBoundsExceptions("Nothing in the Queue");

        }
    }
    public boolean  isEmpty(){
        if(numberOfItems>0){return false;}
        else {return true;}
    }

    public boolean isFull(){
        if(numberOfItems+1>= queueSize){
            return true;
        }
        else {return false;}
    }

    public int  size(){
        return queueSize;
    }

}
