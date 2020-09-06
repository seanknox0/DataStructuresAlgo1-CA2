package sample;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.CodingErrorAction;

public class Main extends Application {

    //HashSets
    public static HashSetSC<Ingredients> ingredients = new HashSetSC<>(10);
    public static HashSetSC<Drinks> drinks = new HashSetSC<>(20);
    public static HashSetSC<Recipes> recipes = new HashSetSC<>(20);

    //Sorting by Alphabetical
    public void selectionSort(MyList<Recipes> names)
    {
        for(int i = names.size(); i > 0; i--){
            int posLargest = findLargest(names, i);
            Swap(names, posLargest, i-1);
        }
    }

    //Used to find the largest position in the list and returns
    private int findLargest(MyList<Recipes> name, int size){
        int largestPos = 0;
        for (int i = 1; i < size; i++){
            if (name.get(i).getContents().getDrink().getName().compareTo(name.get(largestPos).getContents().getDrink().getName()) > 0)
                largestPos = i;
        }
        return largestPos;
    }

    //Swaps the two positions
    private void Swap(MyList<Recipes> mList, int pos, int swapPos){
        mList.swapNodes(pos, swapPos);
    }

    //getHashCode method which gets ascii value of string passed
    public static int getHashCode(String code){
        int total =0;
        for(int i=0; i<code.length();i++)
            total+=code.charAt(i);
            return total;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CA2.fxml"));
        primaryStage.setTitle("Drinks Manager");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //Loads the saved fxml file
    public static void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream((new FileReader("drinksingredients.xml")));
        drinks = (HashSetSC<Drinks>) is.readObject();
        ingredients = (HashSetSC<Ingredients>) is.readObject();
        is.close();
    }

    //Saves the current running fxml file
    public static void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("drinksingredients.xml"));
        out.writeObject(drinks);
        out.writeObject(ingredients);
        out.close();
    }
}
