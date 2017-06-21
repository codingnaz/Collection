import Exceptions.inputNotFoundException;
import OrderList.OrderList;

/**
 * Created by SAimon22 on 6/20/2017.
 */
public class test {
    public static void main(String[] args) throws inputNotFoundException {
        OrderList newlist = new OrderList();
         // newlist.add("a");

       //newlist.add("b");
       newlist.add("e");
        newlist.add("r");
        newlist.add("y");
        newlist.add("z");



       // newlist.add("c");
        newlist.add("c");
        System.out.println(newlist);

        newlist.remove("j");
        System.out.println(newlist);


        System.out.println(newlist.size());

        System.out.println(newlist.toString());
        System.out.println(newlist.size());
        System.out.println(" getNext "+ newlist.getNext("c"));

    }

}