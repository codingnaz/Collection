package TheQueue;

import TheStack.TheStackOutOfBoundsExceptions;

/**
 * Created by SAimon22 on 6/19/2017.
 */
public interface Stack <T> {

        void push(T input) throws TheStackOutOfBoundsExceptions;
        T pop() throws TheStackOutOfBoundsExceptions;

}
