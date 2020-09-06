package sample;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

import java.util.*;

public class HashSetSC<E> {
    MyList<E>[] hashTable;
    int size = 0;


    @SuppressWarnings("unchecked")
    public HashSetSC(int size) {
        hashTable = (MyList<E>[])new MyList[size];
        for(int i = 0;i<hashTable.length;i++)
            hashTable[i] = new MyList<>();
    }

    //Prints hashtable in the terminal
    public void displayHashTable() {
        int num = 1;
        for(MyList<E> lis : hashTable){
            System.out.println("Chain "+num++);
            System.out.println("===========");
            for(E item: lis) {
                System.out.println(item);
            }
        }
    }

    //Displays all the hashtable objects in a ChoiceBox
    public void displayHashTableinChoiceBox(ChoiceBox cb) {
        cb.getItems().clear();
        for(MyList<E> lis : hashTable){
            for(E item: lis) {
                cb.getItems().add(item);
            }
        }
    }

    //Displays all the hashtable objects in a ListView
    public void displayHashTableInListView(ListView lv){
        lv.getItems().clear();
        for(MyList<E> lis : hashTable){
            for(E item : lis){
                lv.getItems().add(item);
            }
        }
    }

    //Using an object to hash an object to the map
    public int hashFunction(E obj) {
        return obj.hashCode()%hashTable.length;
    }

    //Using a key to hash an object to the map
    public int hashFunction2(int key) {
        return key%hashTable.length;
    }

    public void addHash(E item) {
        hashTable[hashFunction(item)].addElement(item);
    }

    //Adds a hash with an item and key
    public void addHash(E item, int key)  {
        hashTable[hashFunction2(key)].addElement(item);
    }

    //Returns the hash by using the key
    public MyList<E> getHash(int key) {
        return hashTable[hashFunction2(key)];
    }

    //deleting a hash using an objects index location and key
    public void deleteHash(Object index, int key)  {
        hashTable[hashFunction2(key)].removeElement(index);
    }
}