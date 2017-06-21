package OrderList;

import Exceptions.inputNotFoundException;

/**
 * Created by SAimon22 on 6/19/2017.
 * make sure your OrderList implements Comparable
 *
 */
public class OrderList <T extends Comparable<T>>  {
LLNode head=new LLNode(null);
LLNode tail;

LLNode previous;

/***
 * its takes the list and turn it into a string and returns it.
 */

public String toString(){
    //tail = head;
    LLNode current = head;
    String returnS="";
    while (current != null){
        returnS +=(String) current.getInfo();
        current = current.getLink();
    }
    return returnS;
}
/**
 * isEmpty checks if there is an head or not
 * no head means not list
 * */

public  boolean isEmpty(){
   return  head.getInfo() == null;


}
/**
 * first, the add method checks to see if the list is empty. If it's empty, its takes the input parameter and set it to the head.
 * else it compare to the input parameter to the exiting list and find the ordered location to store the info
 *
 *
 */

public void add (T input) {

    LLNode current = head;
    LLNode newInput = new LLNode(input);
    LLNode lastNode = head;
    if (isEmpty()){                                                             // if empty
        head= newInput;
    }
        else                                                                    // not emply do this
            {
            if(current.getInfo().compareTo(input)>0){                              //place it infront of the head and set head to the newInput
                      newInput.setLink(head);
                      head = newInput;

             }else {                                                              //if it is not empty or it is smeller then head do this

                        //while we are still in the list, and the guy in the list is bigger than the new guy
                        while (current != null && current.getInfo().compareTo(input)<= 0) {
                            //assume we can add the new guy to this one
                            lastNode = current;
                            current = current.getLink();
                        }
                        //if the loop stopped, it means the last guy we assumed was right, so add...
                         if(lastNode.getInfo().compareTo(input)==0){
                             System.out.println("Input already exist");
                        }else{

                      //but make sure that our new guy connects to the rest of the list first
                        newInput.setLink(lastNode.getLink());
                       lastNode.setLink(newInput);

                    }


                 }
        }
}
/**
 * first, its check the head if it contains any information. If it doesn't contain any information that means it is an empty list so it returns false.
 * Then, it checks the information in the head. If they are the same, it returns true.
 *Else, it goes through the linked List to find the match and returns true.
 *
 * */

public boolean contains(T input){

    boolean returns= false;
    LLNode current = head;
    if(head.getInfo()==null){
        return false;
    }
    else if(head.getInfo().compareTo(input)==0){
        return true;
    }else {

         while ( current.getLink()!=null) {
             if (current.getInfo().compareTo(input) == 0) {
                 returns = true;
                 break;
             }
             previous = current;
             current = current.getLink();
         }


    }

    return returns;
}

/**
 *remove() first to check if size() is 1 and it has the removing information in it
 * if it does then it set its information to NULL becouse we cannot delete anything, we can just point to NULL
 * else its goes through the list and connect its previous link to the next node
 *
 * */

    public void remove(T information) throws inputNotFoundException {
         previous= head;
        LLNode current = previous.getLink();
        if(size()==1 && contains(information)){                                   // if it is size 1
            current.setInfo(null);
        }else {
            if (contains(information)&& head.getInfo().equals(information)) {       // if it is head
                previous.setLink(current.getLink());

            }else {
                if(!contains(information)){
                    throw new inputNotFoundException("Cannot remove something that does not exit");
                }else {

                    while ( current.getInfo().compareTo(information)<= 0) {
                    //inputesNode = current;

                         if (current.getInfo().compareTo(information) == 0) {
                                previous.setLink(current.getLink());
                                break;
                         }
                          current = current.getLink();
                    }
                }



                    previous.setLink(current.getLink());
                System.out.println("removed - " + information);

            }
        }


    }

    /**
     * size() checks to see if it's empty or not
     * if it's empty its returns 0
     * else it counts the node as it goes through the LinkedList then its returns the count
     *
     * */

    public int size(){
        LLNode current= head;
        current = head;
        int count=1;
        if (isEmpty()){
            count=0;

        }else {

            while ( current.getLink()!=null){
             count++;

             current = current.getLink();
            }
        }return count;
    }

    /**
     * I'm not sure what to return in get() method
     * so I just returned the head
     *
     * */
    public T get( T input) throws inputNotFoundException {
        if (contains(input)){
            return input;
        }else {
            throw new inputNotFoundException("element doesnot exit");
        }


    }

    /**
     * the reset() method sets its head's information and it's link to NULL
     * */
    public T reset(){
        head.setInfo(null);
        head.setLink(null);
        return (T) head;
    }



/**
 *The getnext(T input) method checks if the input parameter is contained in the head
 * *** if it is the head then its returns the next node's information
 * if it's not true then its go the linking list and assigns the information containing node to the next node
 * then its returns the next node's information
 *
 *
 *
 * */




    public T getNext(T input) {
        LLNode current = head;
        LLNode inputesNode = head;
        LLNode next=null;
        if(head.getInfo().compareTo(input)==0){
            return (T) head.getLink().getInfo();

        }else{
             while ( current.getInfo().compareTo(input)<= 0) {
                 inputesNode = current;
                current = current.getLink();
                    if(current.getInfo().compareTo(input)== 0){
                        next= current;
                        break;
                  }
             }return (T) next.getLink().getInfo();
        }
    }

}


