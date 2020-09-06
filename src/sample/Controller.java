package sample;
import java.sql.Time;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

import com.sun.webkit.network.URLs;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ChoiceBoxListCell;
import javafx.scene.text.Text;

public class Controller {

    //Add Ingredients
    @FXML TextField ingredientName;
    @FXML TextArea ingredientDesc;
    @FXML TextField alcoholContent;
    @FXML Button addIngredient;
    @FXML Button addIngredientBTN1;

    //Add Drinks
    @FXML Button addDrinkBTN;
    @FXML TextField drinkName;
    @FXML TextArea drinkDesc;
    @FXML TextField drinkOrigin;
    @FXML TextField drinkURL;

    //Add Recipe
    @FXML ListView listDrinks;
    @FXML ListView<Ingredients> selectIngredients;
    @FXML TextField ingredientAmount;
    @FXML ListView selectedIngredients;
    @FXML Button addIngredientRecipe;
    @FXML Text drinkNameField;
    @FXML ListView selectedRecipe;

    //Search Tab
    @FXML Button searchBTN;
    @FXML ListView listView1;
    @FXML ChoiceBox ingredientCB;

    //Delete Tab
    @FXML ListView listDrink2;
    @FXML ListView listIngredient2;

    //Save / Load Tab


    /* ######################
    ADD INGREDIENTS TAB
    #########################*/

    public void addIngredient(){
        if(alcoholContent.getCharacters().length() == 0) {
            String name = ingredientName.getCharacters().toString();
            String desc = ingredientDesc.getText();
            double ABV = 0.0;
            Ingredients i = new Ingredients(name,desc,ABV);
            int code = Main.getHashCode(name);
            Main.ingredients.addHash(i, code);
            Main.ingredients.displayHashTable();
        }
        else {
            String name = ingredientName.getCharacters().toString();
            String desc = ingredientDesc.getText();
            double ABV = Double.parseDouble(alcoholContent.getText());
            Ingredients i = new Ingredients(name, desc, ABV);
            int code = Main.getHashCode(name);
            Main.ingredients.addHash(i, code);
            Main.ingredients.displayHashTable();
        }

    }

    /* ################################
                SEARCH TAB
     ##################################*/

    public void populateCB(){
        Main.ingredients.displayHashTableinChoiceBox(ingredientCB);
    }

    public void populateListView(){
        int code = Main.getHashCode(ingredientCB.getSelectionModel().toString());
        MyList recipes = Main.recipes.getHash(code);
        for(int i =0; i < recipes.size; i++){
            listView1.getItems().add(recipes);
        }
    }


     /* #################################
                  DELETE TAB
       #################################
     */

    public void populateDelViews(){
        Main.drinks.displayHashTableInListView(listDrink2);
        Main.ingredients.displayHashTableInListView(listIngredient2);
    }

    public void deleteDrink(){
        Object obj = listDrink2.getSelectionModel().getSelectedItem();
        String name = listDrink2.getSelectionModel().getSelectedItem().toString();
        int code = Main.getHashCode(name);
        Main.drinks.deleteHash(obj, code);
        Main.drinks.displayHashTableInListView(listDrink2);
    }

    public void deleteIngredient(){
        Object obj = listIngredient2.getSelectionModel().getSelectedItem();
        String name = listIngredient2.getSelectionModel().getSelectedItem().toString();
        int code = Main.getHashCode(name);
        Main.ingredients.deleteHash(obj, code);
        Main.ingredients.displayHashTableInListView(listIngredient2);
    }

    /* ########################
            ADD DRINKS TAB
    ##########################*/

    public void addDrink(){
        String name = drinkName.getCharacters().toString();
        String origin = drinkOrigin.getCharacters().toString();
        String desc = drinkDesc.getText();
        String image = drinkURL.getCharacters().toString();

        Drinks i = new Drinks(name, origin, desc, image);
        int code = Main.getHashCode(name);
        Main.drinks.addHash(i, code);
        Main.drinks.displayHashTable();
    }


    /* #########################
        RECIPES TAB
     ###########################*/

    Drinks drinkObj;
    String drinkName2;


    public void populateDrinksView(){
        //repopulates each time
        Main.drinks.displayHashTableInListView(listDrinks);
    }

    public void populateIngredients(){
        Main.ingredients.displayHashTableInListView(selectIngredients);
        drinkNameField.setText(listDrinks.getSelectionModel().getSelectedItem().toString());
        drinkObj = (Drinks)listDrinks.getSelectionModel().getSelectedItem();
        drinkName2 = listDrinks.getSelectionModel().getSelectedItems().toString();
    }

    MyList<Components> comp = new MyList<>();
    public void addIngredientToLV(){
        Ingredients ing = selectIngredients.getSelectionModel().getSelectedItem();
        if(ingredientAmount.getCharacters().length() > 0) {
            selectedIngredients.getItems().add(ing + " "+ ingredientAmount.getCharacters().toString() +"ml");
            comp.addElement(new Components(Integer.parseInt(ingredientAmount.getText()),ing));
            ingredientAmount.clear();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention");
            alert.setHeaderText("Invalid arguments");
            alert.setContentText("Please enter an amount");

            alert.showAndWait();
        }
    }

    public void recipeListView() {
        //selectedRecipe.getItems().add(listDrinks.getSelectionModel().getSelectedItems().toString());
        MyList<Recipes> recipes= new MyList<>();

    }
    public void addRecipe(){
        int code = Main.getHashCode(comp.head.getContents().getIng().name + ", ABV=" + comp.head.getContents().getIng().ABV);
        Main.recipes.addHash(new Recipes(drinkObj, comp), code);

        drinkName2 = null;
        comp.clearList();
        selectIngredients.getItems().clear();
        selectedIngredients.getItems().clear();
        Main.recipes.displayHashTable();
    }


    /* ##########################
        MISCELLANEOUS METHODS
     ############################*/

    public void initialize(){

    }

    /* #########################
             SAVE TAB
     #########################*/
    public void save(){
        try{
            Main.save();
        }
        catch(Exception e){
        }
    }

    public void load(){
        try{
            Main.load();
        }
        catch(Exception e){
        }

    }
}
