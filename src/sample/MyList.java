package sample;

import java.util.Iterator;

public class MyList<F> implements Iterable<F> {

    public Node<F> head = null;
    int size = 0;

    //Used with sorting methods
    public void swapNodes(int x, int y){
        F Swap = getSort(x);
        this.set(x, this.getSort(y));
        this.set(y, Swap);
    }

    public int size(){
        return size;
    }

    //Adds an element to the list
    public void addElement(F e) {
        Node<F> ml = new Node<>();
        ml.setContents(e);
        ml.next = head;
        head = ml;
        size++;
    }

    //Gets an element from the list
    public Node<F> get(int index) {
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    //Compares the selected object with every object in a list to get the same object
    public int getSameObj(Object obj) {
        Node temp = head;
        int i = 0;
        while(temp !=null){
            if(obj.equals (temp.getContents())){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    //Removes an element that has been selected and passing to next method
    public Node removeElement(Object obj){
        int index = getSameObj(obj);
        return removeElement2(index);
    }

    //Delete an element by index
    public Node removeElement2(int index){
        Node temp = head;

        if(index == 0) {
            head = temp.next;
        }
        else{
            for (int i = 0; i < (index -1); i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        return temp;
    }

    //Sorting method
    public F getSort(int index) {
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return (F) temp.getContents();
    }

    //returns a node from the list
    public Node<F> getNode(int index){
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    //Setter method
    public F set(int index, F element){
        this.getNode(index).setContents(element);
        return null;
    }

    //Clears all elements in the list
    public void clearList(){
        this.head = null;
    }

    @Override
    public Iterator<F> iterator() {
       return new ListIterator<F>(head);
    }


}