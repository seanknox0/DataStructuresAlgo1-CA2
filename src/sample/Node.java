package sample;

public class Node<N> {

    public Node<N> next = null;

    //ADT reference
    private N contents;

    public N getContents() {
        return contents;
    }

    public void setContents(N c) {
        contents=c;
    }
}
