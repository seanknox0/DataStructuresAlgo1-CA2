package sample;

import java.util.Iterator;

public class ListIterator<K> implements Iterator<K> {

    //Current position
    private Node<K> pos;

    public ListIterator(Node<K> fnode) {
        pos = fnode;
    }

    @Override
    public boolean hasNext() {
        return pos != null;
    }

    @Override
    public K next() {
        Node<K> temp = pos;
        pos = pos.next;
        return temp.getContents();
    }
}
