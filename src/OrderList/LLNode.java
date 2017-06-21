package OrderList;

/**
 * Created by SAimon22 on 6/19/2017.
 */
public class LLNode<T extends Comparable<T>> implements Comparable<LLNode<T>> {
    protected T info;
    protected LLNode<T> link;

    public LLNode(T info){
        this.info=info;
        link=null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public LLNode<T> getLink() {
        return link;
    }

    public void setLink(LLNode<T> link) {
        this.link = link;
    }

    @Override
    public int compareTo(LLNode<T> o) {



        return info.compareTo(o.info);
    }
}
