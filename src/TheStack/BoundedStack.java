package TheStack;

import TheQueue.Stack;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by SAimon22 on 6/17/2017.
 *
 *  it has BoundedStack with push(), pop(),top(), isEmpty, isfull().
 */

public class BoundedStack <T> implements Stack<T> {
    private T[] stackArray;
    private int stackSize;
    private int topOfStack= -1;
    BoundedStack(int size){
        stackSize = size;
        stackArray= (T[])  new Object[size];
       // Arrays.fill(stackArray,-1);
    }


    @Override
    public void push( T input) throws TheStackOutOfBoundsExceptions {
        if(topOfStack+1<stackSize){
            topOfStack++;
            stackArray[topOfStack]=input;
        }else{
            throw new TheStackOutOfBoundsExceptions("Stack is full");
        }

    }

    public T pop() throws TheStackOutOfBoundsExceptions{
        if(topOfStack >=0){
            T temp = stackArray[topOfStack];
            stackArray[topOfStack] = null;
            topOfStack--;
           return temp;
        }else {
            throw new TheStackOutOfBoundsExceptions("Stack is empty");

        }

    }

    public T top(){
        return stackArray[topOfStack];
    }

    public boolean isEmpty(){
        if(topOfStack<(stackSize-1)){
            return true;
        }else {
            return false;
        }
    }
    public boolean  isFull(){
        if(stackSize < topOfStack){ return true;}
        else { return false;}

    }

    public int size(){
        return stackSize;
    }

    public String toString(){
        String temp = " ";
        for (int i=0; i< stackArray.length; i++){
            temp = temp + " "+stackArray[i];
        }
        return temp;

    }

}
